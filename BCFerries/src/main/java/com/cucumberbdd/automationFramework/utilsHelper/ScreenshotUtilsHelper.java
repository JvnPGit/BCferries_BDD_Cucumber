package com.cucumberbdd.automationFramework.utilsHelper;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.base.Base;

public class ScreenshotUtilsHelper extends Base {
	
	/****************************************************************************************************************************
	 * Function Name : get_ScreenShot() Description : Capture Screenshot
	 * 
	 * @param fileName: FileName screenshot save in local directory
	 ****************************************************************************************************************************/
	public static String get_ScreenShot(String fileName) {
		String screenshotDestinationPath = "";
		RemoteWebDriver driver = null;
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String source = scrFile.getAbsolutePath().substring(scrFile.getAbsolutePath().lastIndexOf(File.separator) + 1).toString();
			
			FileUtils.moveToDirectory(scrFile, new File(fileName), false);
			File newFile = new File( fileName + File.separator + source);
			screenshotDestinationPath = fileName + File.separator + Base.currentTestMethodName + "_" + CalendarHelper.getLocalDateTime().replace(" ", "_").replace(":", "_").replace("/", "_") + ".png";
			new File(newFile.toString()).renameTo((new File(screenshotDestinationPath)));
			
		} catch (Exception e) {
			Log4j.info("Failed to get the screenshot destination path");
			Log4j.info(e.getMessage());
		}
		
		return screenshotDestinationPath;
	}
	
	/**
	 * This method is used to capture the screenshot and save in the Results folder
	 * @return
	 */
	public static String getScreenshot() {
		String destination = "";
		RemoteWebDriver driver = null;
		
		try {
			if (!(currentBrowserName == "") && (currentBrowserName.length() > 0)) {
				String dateName = CalendarHelper.getCurrentTime().replace(" ", "_").replace(":", "_").replace("/", "_");
				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File latestResultsFolder = FileUtilityHelper.getLatestDirectory(System.getProperty("user.dir") + File.separator + "Results" + File.separator);
				String failedTestCaseScreenshotPath =  latestResultsFolder.toString();
				destination = failedTestCaseScreenshotPath + File.separator + dateName + ".png";
				File finalDestination = new File(destination);
				FileUtils.copyFile(source, finalDestination);
				destination = finalDestination.getName();
			
			} else if (currentBrowserName == "") {
				if (deviceType.equalsIgnoreCase("Desktop")) {
					logHelper.info("As browser does not exist, providing the desktop screenshot. This may not capture exact failure info, please check the logs for failure cause." );
					destination = ScreenshotUtilsHelper.captureFailureDesktopScreenshot();
				}
			}
			return destination;
		
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to capture screenshot");
			return destination;
		}
	}

	/**
	 * This method is used to capture the screenshot and save in a MS Word document
	 */
	public static void captureScreenshot() {
		try {
			RemoteWebDriver driver = null;
			
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String source = scrFile.toString();
			BufferedImage screenFullImage = createImage(source);

			// create word doc
			XWPFDocument doc = new XWPFDocument();
			// create para and run
			XWPFParagraph para = doc.createParagraph();
			XWPFRun run = para.createRun();
			String docFilePath = FileUtilityHelper.getTestcaseScreenshotsPath() + "TestResultsWithScreenshots.docx";
	
			para.setAlignment(ParagraphAlignment.CENTER);

			// convert buffered image to Input Stream
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(screenFullImage, "png", baos);
			baos.flush();
			ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
			baos.close();

			// add image to word doc
			run.addBreak();
			run.addPicture(bis, XWPFDocument.PICTURE_TYPE_PNG, "image file", Units.toEMU(220), Units.toEMU(350)); // 200x200 pixels

			// write word doc to file
			FileOutputStream fos = new FileOutputStream(docFilePath);
			doc.write(fos);
			fos.close();

			bis.close();
			doc.close();
	            
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to capture screenshot");
		}
	}
	
	/**
	 * This method is used to create an image file
	 * @param sourceFileName
	 * @return
	 * @throws Exception
	 */
	public static  BufferedImage createImage(String sourceFileName) {
	    BufferedImage bufferedImage = null;
	    
	    try {
	    	String destFileName = FileUtilityHelper.getTestcaseImagesPath() + "pic" + "_" + FileUtilityHelper.getImageTimeStamp() +".png";
	    	FileUtilityHelper.renameFile(sourceFileName, destFileName);
	    	bufferedImage = ImageIO.read(new File(destFileName));
	    	return bufferedImage;
	    
	    } catch (Exception e) {
	    	Log4j.info(e.getMessage());
			Log4j.info("Failed to create image");
			return bufferedImage;
	    }
	}
	
	/**
	 * This method copies images to MS Word document
	 * @
	 */
	public static void copyImagesToWord()  {
		try {
			String docFilePath = FileUtilityHelper.getTestcaseScreenshotsPath() + "TestResultsWithScreenshots.docx" ;
			FileUtilityHelper.moveFilesWithDirectory(FileUtilityHelper.getTestcaseImageFilesPath());
			FileUtilityHelper.copyImagesToWordDoc(FileUtilityHelper.getTestcaseImageFilesPath(), docFilePath);
			
			deleteImageProcessingFolder();	
		} catch (Exception e) {
	    	Log4j.info(e.getMessage());
			Log4j.info("Failed to copy images to Word document");
	    }
	}
	
	/**
	 * This method captures Screenshots into a local directory
	 * @param fileName
	 * @throws Exception
	 */
	public static void captureDesktopScreenshot(String fileName) {
		try {
			Robot robot = new Robot();
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			ImageIO.write(screenFullImage, "png", new File(fileName));

			// create word doc
			XWPFDocument doc = new XWPFDocument();
			// create para and run
			XWPFParagraph para = doc.createParagraph();
			XWPFRun run = para.createRun();
			String docFilePath = FileUtilityHelper.getTestcaseScreenshotsPath() + "TestResultsWithScreenshots.docx";

			para.setAlignment(ParagraphAlignment.CENTER);

			// convert buffered image to Input Stream
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(screenFullImage, "png", baos);
			baos.flush();
			ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
			baos.close();

			// add image to word doc
			run.addBreak();
			run.addPicture(bis, XWPFDocument.PICTURE_TYPE_PNG, "image file", Units.toEMU(650), Units.toEMU(350)); // 200x200 pixels
			bis.close();
			
			// write word doc to file
			FileOutputStream fos = new FileOutputStream(docFilePath);
			doc.write(fos);
			fos.close();
			doc.close();

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to capture Desktop screenshot");
		}
	}
	
	/**
	 * This method captures desktop screenshot
	 * @param fileName
	 * @throws Exception
	 */
	public static void getDesktopScreenshot(String fileName) {
		try {
			Robot robot = new Robot();
		    Rectangle screenRect  = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		    BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
		    ImageIO.write(screenFullImage , "png", new File(fileName));
		    
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to capture Desktop screenshot");
		}
	}
	
	/**
	 * This method captures desktop screenshot at the beginning of the test case
	 * @throws Exception
	 */
	public static String captureFirstDesktopScreenshot() {
		String latestResultsFolderPath = "";
		
		try {
			 if (deviceType.equalsIgnoreCase("Desktop")) {
		        	File latestResultsFolder = FileUtilityHelper.getLatestDirectory(System.getProperty("user.dir") + File.separator + "Results" + File.separator);
		            latestResultsFolderPath = latestResultsFolder.toString();
		            ScreenshotUtilsHelper.getDesktopScreenshot(latestResultsFolderPath + File.separator + "DesktopScreenshot.png");
		     }
			 waitFor(1);
			 return latestResultsFolderPath + File.separator + "DesktopScreenshot.png";	
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to capture Desktop screenshot");
			return latestResultsFolderPath + File.separator + "DesktopScreenshot.png";
		}
	}
	
	/**
	 * This method captures desktop screenshot when a test fails on desktop
	 * @throws Exception
	 */
	public static String captureFailureDesktopScreenshot() {
		String latestResultsFolderPath = "";
		String dateName = CalendarHelper.getCurrentTime().replace(" ", "_").replace(":", "_").replace("/", "_");
		
		try {
			if (deviceType.equalsIgnoreCase("Desktop")) {
				File latestResultsFolder = FileUtilityHelper.getLatestDirectory(System.getProperty("user.dir") + File.separator + "Results" + File.separator);
				latestResultsFolderPath = latestResultsFolder.toString();
				ScreenshotUtilsHelper.getDesktopScreenshot(latestResultsFolderPath + File.separator + dateName + ".png");
			}
			 waitFor(1);
			 return new File(latestResultsFolderPath + File.separator + dateName + ".png").getName();	
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to capture Desktop screenshot");
			return latestResultsFolderPath + File.separator + dateName + ".png";
		}
	}
	
	/**
	 * This method is used to capture the screenshot on a mobile and save in a MS Word document and also add a text to it at the beginning of the document
	 */
	public static void captureScreenshotOnMobileAndInsertText(String textToInsert) {
		try {
			RemoteWebDriver driver = null;
			
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String source = scrFile.toString();
			BufferedImage screenFullImage = createImage(source);

			// create word doc
			XWPFDocument doc = new XWPFDocument();
			// create para and run
			XWPFParagraph para = doc.createParagraph();
			
			String docFilePath = FileUtilityHelper.getTestcaseScreenshotsPath() + "TestResultsWithScreenshots.docx";
			
			// Set Bold an Italic
			XWPFRun paragraphOneRunOne = para.createRun();
			paragraphOneRunOne.setBold(true);
			paragraphOneRunOne.setItalic(true);
			paragraphOneRunOne.setText(textToInsert);
			paragraphOneRunOne.addBreak();
	
			XWPFRun run = para.createRun();
			para.setAlignment(ParagraphAlignment.CENTER);

			// convert buffered image to Input Stream
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(screenFullImage, "png", baos);
			baos.flush();
			ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
			baos.close();

			// add image to word doc
			run.addBreak();
			run.addPicture(bis, XWPFDocument.PICTURE_TYPE_PNG, "image file", Units.toEMU(220), Units.toEMU(350)); // 200x200 pixels

			// write word doc to file
			FileOutputStream fos = new FileOutputStream(docFilePath);
			doc.write(fos);
			fos.close();

			bis.close();
			doc.close();
	            
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to capture screenshot");
		}
	}
	
	/**
	 * This method captures screenshot on the mobile and returns image file path
	 * @param webdriver
	 * @param imageFilePath
	 * @return
	 */
	public static String captureMobileScreenshotAndGetFileName(WebDriver webdriver, String imageFilePath) {
		try {
			// Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

			// Call getScreenshotAs method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination
			File DestFile = new File(imageFilePath);

			// Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
			
			String folderPath = FileUtilityHelper.getFilePathWithoutFileName(imageFilePath);
			String fileName = FileUtilityHelper.getFileNameWithExtensionFromFilePath(imageFilePath);
			boolean isFileExist = FileUtilityHelper.isFileExistInAFolder(folderPath, fileName);
			Log4j.info("Is nPerf image file exists: " + isFileExist);
			
			String newImageFileName = new File (imageFilePath).getName(); 
			Log4j.info("New image file name is: " + newImageFileName);
			return newImageFileName;
			
		} catch (Exception e) {
			Log4j.info("Failed to capture screenshot on mobile");
			Log4j.info(e.getMessage());
			return imageFilePath;
		}
	}
}
