package com.cucumberbdd.automationFramework.utilsHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import com.cucumberbdd.automationFramework.base.Base;
import com.cucumberbdd.automationFramework.screenshotUtils.CustomXWPFDocument;

public class FileUtilityHelper extends Base {
	private static Logger Log = Logger.getLogger(FileUtilityHelper.class.getName());
	public static boolean isFinished = false;

	/**
	 * This method is used to replace the Pass Percentage content with Tests Pass
	 * Percentage in the results file
	 */
	public static void replaceContent() {
		File file = getLatestFile(System.getProperty("user.dir") + File.separator + "Results" + File.separator);
		String filePath = file.toString();
		File file2 = FileUtilityHelper.getHTMLFile(filePath);
		String oldFileName = file2.toString();
		String tmpFileName = "tmp_try.html";

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader(oldFileName));
			bw = new BufferedWriter(new FileWriter(tmpFileName));

			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("<span class='panel-name'>Pass Percentage</span>")) {
					line = line.replace("<span class='panel-name'>Pass Percentage</span>",
							"<span class='panel-name'>Tests Pass Percentage</span>");
					bw.write(line);
				}
			}
		} catch (Exception e) {
			return;
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		File oldFile = new File(oldFileName);
		oldFile.delete();

		File newFile = new File(tmpFileName);
		newFile.renameTo(oldFile);
	}

	/**
	 * This method is used to replace the Pass Percentage position in the results
	 * file
	 */
	public static void replacePassPercentagePosition() {
		File file = getLatestFile(System.getProperty("user.dir") + File.separator + "Results" + File.separator);
		String filePath = file.toString();
		File file2 = getHTMLFile(filePath);
		String oldFileName = file2.toString();
		String tmpFileName = "tmp_try.html";

		String actualText = "<div class='col s12 m6 l4 fh'> 						<div class='card-panel'> 							<div>								<span class='panel-name'>Steps View</span>							</div> 							<div class='panel-setting modal-trigger step-status-filter right'>								<a href='#step-status-filter'><i class='mdi-navigation-more-vert text-md'></i></a>							</div> 							<div class='chart-box'>								<canvas class='text-centered' id='step-analysis'></canvas>							</div> 							<div>								<span class='weight-light'><span class='s-pass-count weight-normal'></span> step(s) passed </span>							</div> 							<div>								<span class='weight-light'><span class='s-fail-count weight-normal'></span> step(s) failed, <span class='s-others-count weight-normal'></span> others</span>							</div> 						</div> 					</div>					<div class='col s12 m12 l4 fh'> 						<div class='card-panel'> 							<span class='panel-name'>Tests Pass Percentage</span> 							<span class='pass-percentage panel-lead'></span> 							<div class='progress light-blue lighten-3'> 								<div class='determinate light-blue'></div> 							</div> 						</div> 					</div>";

		String expText = "<div class='col s12 m12 l4 fh'> 						<div class='card-panel'> 							<span class='panel-name'>Tests Pass Percentage</span> 							<span class='pass-percentage panel-lead'></span> 							<div class='progress light-blue lighten-3'> 								<div class='determinate light-blue'></div> 							</div> 						</div> 					</div><div class='col s12 m6 l4 fh'> 						<div class='card-panel'> 							<div>								<span class='panel-name'>Steps View</span>							</div> 							<div class='panel-setting modal-trigger step-status-filter right'>								<a href='#step-status-filter'><i class='mdi-navigation-more-vert text-md'></i></a>							</div> 							<div class='chart-box'>								<canvas class='text-centered' id='step-analysis'></canvas>							</div> 							<div>								<span class='weight-light'><span class='s-pass-count weight-normal'></span> step(s) passed </span>							</div> 							<div>								<span class='weight-light'><span class='s-fail-count weight-normal'></span> step(s) failed, <span class='s-others-count weight-normal'></span> others</span>							</div> 						</div> 					</div>";

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader(oldFileName));
			bw = new BufferedWriter(new FileWriter(tmpFileName));

			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(actualText)) {
					line = line.replace(actualText, expText);
					bw.write(line);
				}
			}
		} catch (Exception e) {
			return;
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		File oldFile = new File(oldFileName);
		oldFile.delete();

		File newFile = new File(tmpFileName);
		newFile.renameTo(oldFile);
	}

	/**
	 * This method is used to replace the Pass and Fail % values in the results file
	 */
	public static void replacePassFailPercent() {
		File file = getLatestFile(System.getProperty("user.dir") + File.separator + "Results" + File.separator);
		String filePath = file.toString();
		File file2 = getHTMLFile(filePath);
		String oldFileName = file2.toString();
		String tmpFileName = "tmp_try.html";

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader(oldFileName));
			bw = new BufferedWriter(new FileWriter(tmpFileName));

			String line;
			String actualText = "<div class='col s12 m12 l4 fh'> 						<div class='card-panel'> 							<span class='panel-name'>Tests Pass Percentage</span> 							<span class='pass-percentage panel-lead'></span> 							<div class='progress light-blue lighten-3'> 								<div class='determinate light-blue'></div> 							</div> 						</div> 					</div>";
			String expText = "<div class='col s12 m12 l4 fh'> <div class='card-panel'> <table style='width:80%;' border='3'> <tr> <th style='background-color: #eeeeee;'>Test Case Status</th> <th style='background-color: #eeeeee;'>Percentage</th> </tr> <tr> <td  align = 'center'>Tests Passed</td> <td  align = 'center'><font color='green'><b>"
					+ getPassPercent()
					+ "%</b></font></td> </tr> <tr> <td  align = 'center'>Tests Failed</td> <td  align = 'center'><font color='red'><b>"
					+ getFailPercent() + "%</b></font></td> </tr> </table> </div> </div>";
			while ((line = br.readLine()) != null) {
				if (line.contains(actualText)) {
					line = line.replace(actualText, expText);
					bw.write(line);
				}
			}
		} catch (Exception e) {
			return;
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		File oldFile = new File(oldFileName);
		oldFile.delete();

		File newFile = new File(tmpFileName);
		newFile.renameTo(oldFile);
	}

	/**
	 * This method is used to add the Summary Report link from the Detailed Report
	 * in the results file
	 */
	public static void summaryReportLinkFromDetailedReport() {
		File latestResultsFolder = getLatestDirectory(System.getProperty("user.dir") + File.separator + "Results");
		File latestDetailedReport = getHTMLFile(latestResultsFolder.toString());
		File latestSummarReport = getHTMLFile(latestResultsFolder.toString() + File.separator + "SummaryResults");
		String oldFileName = latestDetailedReport.toString();
		String tmpFileName = "tmp_try.html";
		BufferedReader br = null;
		BufferedWriter bw = null;
		String tempString1, tempString2;
		String userDirPath = System.getProperty("user.dir");
		userDirPath = userDirPath.replace("\\", "/");
		tempString1 = "<TABLE border=0 cellSpacing=1 cellPadding=1 width='50%' style='float:right'><TR><TD align='right' height = '100' width='20%'><TD align='right' height = '100' width='20%'><img src='file:///" + userDirPath + "/Logos/comcast.png' height='70%' >";
		tempString2 = "</table><center><a href = '" + latestSummarReport.toString() + "'><H2> <B> Summary Report </a></H2></center><TABLE border=0 cellSpacing=1 cellPadding=1 width='50%' style='float:right'><TABLE border=0 cellSpacing=1 cellPadding=1 width='50%' style='float:right'><TR><TD align='right' height = '100' width='20%'><TD align='right' height = '100' width='20%'><img src='file:///" + userDirPath + "/Logos/comcast.png' height='70%' >";

		try {
			br = new BufferedReader(new FileReader(oldFileName));
			bw = new BufferedWriter(new FileWriter(tmpFileName));

			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(tempString1)) {
					line = line.replace(tempString1, tempString2);
					bw.write(line);
				}
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
			return;
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				Log.info(e.getMessage());
			}
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				Log.info(e.getMessage());
			}
		}

		File oldFile = new File(oldFileName);
		oldFile.delete();

		File newFile = new File(tmpFileName);
		newFile.renameTo(oldFile);
	}

	/**
	 * This method returns the last modifiled file in a given path
	 * 
	 * @param path
	 * @return
	 */
	public static File getLatestFile(String path) {
		File lastModifiedFile = null;
		try {
			File dir = new File(path);
			File[] files = dir.listFiles();

			if (files != null && files.length > 0) {

				if (!(files[0].toString().contains(".DS_Store"))) {
					lastModifiedFile = files[0];
				} else {
					lastModifiedFile = files[1];
				}
				// lastModifiedFile = files[0];

				for (int i = 1; i < files.length; i++) {
					if (lastModifiedFile.lastModified() < files[i].lastModified()) {
						lastModifiedFile = files[i];
					}
				}
				return lastModifiedFile;
			}

		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		}
		return lastModifiedFile;
	}

	/**
	 * This method returns the last modified directory in a given path
	 * 
	 * @param path
	 * @return
	 */
	public static File getLatestDirectory(String path) {
		try {
			File lastModifiedFile;
			File dir = new File(path);
			File[] dirList = dir.listFiles();

			if (dirList == null || dirList.length == 0) {
				return null;
			}

			if (!(dirList[0].toString().contains(".DS_Store"))) {
				lastModifiedFile = dirList[0];
			} else {
				lastModifiedFile = dirList[1];
			}

			for (int i = 1; i < dirList.length; i++) {
				if (lastModifiedFile.lastModified() < dirList[i].lastModified()) {
					if (!(dirList[i].toString().contains(".DS_Store"))) {
						lastModifiedFile = dirList[i];
					}
					// Log4j.info(lastModifiedFile);
				}
			}

			return lastModifiedFile;

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the latest directory from given path");
			return null;
		}
	}

	/**
	 * This method returns the .html file from a list of files in a given path
	 * 
	 * @param path
	 * @return
	 */
	public static File getHTMLFile(String path) {
		String htmlFile = null;
		File resultFile = null;

		try {
			File dir = new File(path);
			File[] files = dir.listFiles();

			if (files == null || files.length == 0) {
				return null;
			}

			for (int i = 0; i < files.length; i++) {
				htmlFile = files[i].getName();
				if (htmlFile.contains(".html")) {
					resultFile = files[i];
				}
			}
			return resultFile;

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the latest directory from given path");
			return null;
		}
	}

	/**
	 * This method deletes all the files that are older than 30 days from the
	 * Results folder
	 */
	public static void deleteFilesOlderThan30Days() {
		try {
			String logFilePath = System.getProperty("user.dir") + File.separator + "logs" + File.separator;
			String resultFilePath = System.getProperty("user.dir") + File.separator + "Results" + File.separator;

			deleteLogsOlderThan30days(logFilePath);
			deleteResultFilesOlderThan30days(resultFilePath);

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to delete files older than 30 days");
		}
	}

	/**
	 * This method deletes all the log files that are older than 30 days from the
	 * log folder path
	 * 
	 * @param logFilePath
	 */
	public static void deleteLogsOlderThan30days(String logFilePath) {
		File directory = new File(logFilePath);
		Calendar cal1 = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();

		try {
			if (directory.exists()) {
				File[] listFiles = directory.listFiles();
				for (File listFile : listFiles) {
					Date date1 = new Date();
					cal1.setTime(date1);

					long purgeTime = listFile.lastModified();
					Date date2 = new Date(purgeTime);
					cal2.setTime(date2);

					int days = daysBetween(date1, date2);

					if (days < -30) {
						listFile.delete();
					}
				}
			} else
				Log.info("Files were not deleted, directory " + logFilePath + " does'nt exist!");
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to delete logs older than 30 days");
		}
	}

	/**
	 * This method deletes all the result files older than 30 days from the Results
	 * directory
	 * 
	 * @param resultFilePath
	 */
	public static void deleteResultFilesOlderThan30days(String resultFilePath) {
		try {
			File directory = new File(resultFilePath);
			Calendar cal1 = new GregorianCalendar();
			Calendar cal2 = new GregorianCalendar();

			if (directory.exists()) {
				Date date1 = new Date();
				cal1.setTime(date1);

				long purgeTime = directory.lastModified();
				Date date2 = new Date(purgeTime);
				cal2.setTime(date2);

				int days = daysBetween(date1, date2);

				if (days < -30) {
					Log.info("Directory to be deleted: " + directory.getName());
					directory.delete();
				}
			} else
				Log.info("Files were not deleted, directory " + resultFilePath + " does'nt exist!");
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to delete result files older than 30 days");
		}
	}

	/**
	 * This method returns the number of days between two given dates
	 * 
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static int daysBetween(Date day1, Date day2) {
		return (int) ((day2.getTime() - day1.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * This method converts milli seconds to formatted date in the format:
	 * "MM-DD-yyyy hh:mm:ss"
	 * 
	 * @param milliSeconds
	 * @return
	 */
	public static String ConvertMilliSecondsToFormattedDate(String milliSeconds) {
		String dateFormat = "MM-DD-yyyy hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(Long.parseLong(milliSeconds));
		return simpleDateFormat.format(calendar.getTime());
	}

	/**
	 * This method is used to transfer file from source folder to destination folder
	 * 
	 * @param sourceFile
	 * @param destFile
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void transferFileData(File sourceFile, File destFile) throws IOException {
		FileChannel src = new FileInputStream(sourceFile).getChannel();
		FileChannel dest = new FileOutputStream(destFile).getChannel();
		dest.transferFrom(src, 0, src.size());
	}

	/**
	 * This method is used to compare two files in between the source folder and the
	 * destination folder
	 * 
	 * @param sourceFilePath
	 * @param destFilePath
	 */
	public static void compareFiles(String sourceFilePath, String destFilePath) {
		try {
			BufferedReader reader1 = new BufferedReader(new FileReader(sourceFilePath));
			BufferedReader reader2 = new BufferedReader(new FileReader(destFilePath));
			String line1 = reader1.readLine();
			String line2 = reader2.readLine();
			boolean areEqual = true;
			int lineNum = 1;

			while (line1 != null || line2 != null) {
				if (line1 == null || line2 == null) {
					areEqual = false;
					break;
				} else if (!line1.equalsIgnoreCase(line2)) {
					areEqual = false;
					break;
				}
				line1 = reader1.readLine();
				line2 = reader2.readLine();
				lineNum++;
			}
			if (areEqual) {
				Log4j.info("Two files have same content.");
			} else {
				Log4j.info("Two files have different content. They differ at line " + lineNum);
				Log4j.info("File1 has " + line1 + " and File2 has " + line2 + " at line " + lineNum);
			}

			reader1.close();
			reader2.close();
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to compare files");
		}
	}

	/**
	 * This method is used to print the contents of a file in a given path
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public static void printFileContent(String filePath) throws IOException {
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String line = in.readLine();
			while (line != null) {
				Log4j.info(line);
				line = in.readLine();
			}
			in.close();
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to print file content");
		}
	}

	/**
	 * This method returns the file name based on file extension from a given path
	 * 
	 * @param dirName
	 * @param fileExtn
	 * @return
	 */
	public static File getFileNameBasedOnFileExtensionFromFilePath(String dirName, String fileExtn) {
		File listFile = new File(dirName);
		
		try {
			File dir = new File(dirName);

			for (File file : dir.listFiles()) {
				if (file.getName().endsWith((fileExtn))) {
					listFile = file;
				}
			}
		} catch (Exception e) {
			Log4j.info("Failed to get the file name based on file extension from a given path");
			Log4j.info(e.getMessage());
		}
		
		return listFile;
	}

	/**
	 * This method returns a list of files from a given path based on file extension
	 * 
	 * @param dirName
	 * @param fileExtn
	 * @return
	 */
	/*public File[] fileFinder(String dirName, String fileExtn) {
		File dir = new File(dirName);
		return dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return filename.endsWith(fileExtn);
			}
		});
	} */


	/**
	 * This method returns the testcase images path from the project directory
	 * 
	 * @return @
	 */
	public static String getTestcaseImagesPath() {
		String directory = getTestcaseImageFilesPath();
		String tempFolderName = directory + "Temp_" + getImageTimeStamp() + File.separator;
		File file = new File(tempFolderName);
		if (!file.exists()) {
			new File(tempFolderName).mkdirs();
		}
		return tempFolderName;
	}

	/**
	 * This method returns the testcase image files path from the project directory
	 * 
	 * @return @
	 */
	public static String getTestcaseImageFilesPath() {
		String directory = "ImageProcessing";
		File file = new File(tempTestcaseImagesPath + directory + File.separator);

		if (!file.exists()) {
			new File(tempTestcaseImagesPath + directory).mkdirs();
		}
		return tempTestcaseImagesPath + directory + File.separator;
	}

	/**
	 * This method returns the testcase screenshots path from the project directory
	 * 
	 * @return
	 */
	public static String getTestcaseScreenshotsPath() {
		String testResultsScreenshotPath = "";

		try {
			//String directory = "TestcaseScreenshots";
			String testCaseScreenshotPath = getLatestDirectory(screenshotPath).toString() + File.separator;
			
			File file = new File(testCaseScreenshotPath);

			if (!file.exists()) {
				new File(testCaseScreenshotPath).mkdirs();
			}

			if (getLatestDirectory(screenshotPath).toString().contains(".DS_Store")) {
				testResultsScreenshotPath = getLatestDirectory(screenshotPath).toString().replace(File.separator + ".DS_Store", "");
				testResultsScreenshotPath = testResultsScreenshotPath + File.separator;
			} else {
				testResultsScreenshotPath = testCaseScreenshotPath;
			}
			
		} catch (Exception e) {
			Log4j.info("Failed to get the test case screenshots path");
			Log4j.info(e.getMessage());
		}
		
		return testResultsScreenshotPath;
	}

	/**
	 * This method returns the image file timestamp
	 * 
	 * @return
	 */
	public static String getImageTimeStamp() {
		return CalendarHelper.getCurrentTime().replace(":", "_").replace(".", "_");
	}

	/**
	 * This method is used to sort the last modified files in descending order in a
	 * given path
	 * 
	 * @param path
	 * @return @
	 */
	public static File[] sortFilesInDescendingOrder(String path) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);

		return files;
	}

	/**
	 * This method is used to sort the last modified files in ascending order in a
	 * given path
	 * 
	 * @param path
	 * @return @
	 */
	public static File[] sortFilesInAscendingOrder(String path) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);

		return files;
	}

	/**
	 * This method is used to copy images to MS Word document from a given path
	 * 
	 * @param imageFilePath
	 * @param outputDocumentPath @
	 */
	public static void copyImagesToWordDoc(String imageFilePath, String outputDocumentPath) {
		CustomXWPFDocument document = new CustomXWPFDocument();
		File[] files = sortFilesInAscendingOrder(imageFilePath);

		try {
			XWPFParagraph para = document.createParagraph();
			para.setAlignment(ParagraphAlignment.CENTER);

			if (files.length > 0) {
				for (int i = 0; i < files.length; i++) {
					File file = files[i];

					if (!(files[i].toString().contains(File.separator + ".DS_Store"))) {
						String blipId = para.getDocument().addPictureData(new FileInputStream(new File(file.getAbsolutePath())), Document.PICTURE_TYPE_PNG);
						document.createPicture(blipId, document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 350, 450);
					}
				}
				String lastModifiedImage = getLatestFile(imageFilePath).toString();
				String blipId = para.getDocument().addPictureData(new FileInputStream(new File(lastModifiedImage)), Document.PICTURE_TYPE_PNG);
				document.createPicture(blipId, document.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), 350, 450);
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
		}

		FileOutputStream outStream = null;

		try {
			outStream = new FileOutputStream(outputDocumentPath);
			document.write(outStream);
			outStream.close();
			document.close();
			Log.info("Images are copied into the output word document successfully!!");

		} catch (Exception e) {
			Log.info("Failed to copy images to word document");
			Log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to delete a directory from a given path
	 * 
	 * @param destinationFolderPath
	 * @return
	 */
	public static boolean deleteDirectory(String destinationFolderPath) {
		boolean result = false;
		File directory = new File(destinationFolderPath);

		File[] contents = directory.listFiles();
		try {
			if (contents != null) {
				for (int i = 0; i < contents.length; i++) {
					deleteDirectory(contents[i].toString());
				}
				if (directory.delete()) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.getMessage());
		}

		return result;
	}

	/**
	 * This method is used to delete a directory from a given path
	 * 
	 * @param directoryFilePath
	 * @return
	 * @throws IOException
	 */
	public static boolean deleteDir(String directoryFilePath) {
		boolean isDirectoryDeleted = false;
		
		try {
			File file = new File(directoryFilePath);
			File[] flist = null;

			if (file.isFile()) {
				return file.delete();
			}

			if (file.isDirectory()) {
				return file.delete();
			}

			flist = file.listFiles();
			if (flist != null && flist.length > 0) {
				for (File f : flist) {
					if (!deleteDir(f.toString())) {
						return isDirectoryDeleted;
					}
				}
			}

			return file.delete();
			
		} catch (Exception e) {
			Log4j.info("Failed to delete the directory");
			Log4j.info(e.getMessage());
			return isDirectoryDeleted;
		}
	}

	/**
	 * This method is used to delete a directory from a given path from command line
	 * @param directoryPath
	 * @return
	 * @
	 */
	public static boolean deleteDirFromCMDPrompt(String directoryPath) {
		boolean isFileDeleted = false;
		File file =  new File(directoryPath);
		
		try {
			if (isWindows()) {
				if (file.exists()) {
					String cmd = "RMDIR /Q/S " + "\"" + directoryPath + "\"";
					Log4j.info("The command to delete the directory '" + directoryPath + "' is: \n" + cmd);
					
					Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", cmd});
					waitFor(2);
					
					isFileDeleted = !(file.exists());
		        }
			} else if (isMAC()) {
				if (file.exists()) {
					ProcessBuilder builder = new ProcessBuilder("rm -rf " + directoryPath);
			        Process p = builder.start(); 
			        StringBuilder sb = new StringBuilder();
			        
			        p.waitFor(); 
			        BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
			        String line; 
			        while((line = reader.readLine()) != null) { 
			        	sb = sb.append(line).append("\n");
			        } 
			        isFileDeleted = (!file.exists());
				} else if (!file.exists()){
					isFileDeleted = (!file.exists());
		        }
			}
			
			if (isFileDeleted) {
				Log4j.info("The directory '" + directoryPath + "' is successfully deleted");
				
			} else {
				Log4j.info("Failed to delete the directory '" + directoryPath + "'");
			}
		} catch (Exception e) {
			Log4j.info("Failed to delete the directory '" + directoryPath + "' from command line");
			Log.info(e.getMessage());
		}
		
		return isFileDeleted;
	}

	/**
	 * This method is used to rename a file
	 * 
	 * @param oldFilePath
	 * @param newFilePath @
	 */
	public static void renameFile(String oldFilePath, String newFilePath) {
		File oldFile = new File(oldFilePath);
		File newFile = new File(newFilePath);

		try {
			if (oldFile.exists()) {
				oldFile.renameTo(newFile);
				oldFile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to move all the files in a given directory from source to
	 * destination folder
	 * 
	 * @param destinationFolderPath
	 * @return @
	 */
	public static boolean moveFilesWithDirectory(String destinationFolderPath) {
		boolean result = false;
		File destinationFolder = new File(destinationFolderPath);
		File[] listOfDir = destinationFolder.listFiles();

		try {
			if (!destinationFolder.exists()) {
				destinationFolder.mkdirs();
			}

			for (int i = 0; i < listOfDir.length; i++) {
				File sourceFolder = listOfDir[i];

				// Check weather source exists and it is folder.
				if (sourceFolder.exists() && sourceFolder.isDirectory()) {
					// Get list of the files and iterate over them
					File[] listOfFiles = sourceFolder.listFiles();

					/*
					 * if (listOfFiles != null) { for (File child : listOfFiles ) { // Move files to
					 * destination folder child.renameTo(new File(destinationFolder + File.separator
					 * + child.getName())); }
					 * 
					 * // Add if you want to delete the source folder sourceFolder.delete(); }
					 */
					for (File child : listOfFiles) {
						/*
						 * Path temp = Files.move(Paths.get(child.getAbsolutePath()),
						 * Paths.get(destinationFolderPath + File.separator + child.getName()));
						 * sourceFolder.delete(); if (temp != null) { result = true; }
						 */
					}
				} else {
					Log4j.info(sourceFolder + "  Folder does not exists");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.getMessage());
		}
		return result;
	}

	/**
	 * This method is used to move only the files without directories from source to
	 * destination folder
	 * 
	 * @param sourceFolderPath
	 * @param destinationFolderPath
	 * @return @
	 */
	public static boolean moveFilesWithoutDirectory(String sourceFolderPath, String destinationFolderPath) {
		boolean result = false;
		File destinationFolder = new File(destinationFolderPath);
		File sourceFolder = new File(sourceFolderPath);
		InputStream inStream = null;
		OutputStream outStream = null;

		try {
			if (!destinationFolder.exists()) {
				destinationFolder.mkdirs();
			}

			// Check weather source exists and it is folder.
			if (sourceFolder.exists() && sourceFolder.isDirectory()) {
				// Get list of the files and iterate over them
				File[] listOfFiles = sourceFolder.listFiles();

				if (listOfFiles != null) {
					/*
					 * for (File child : listOfFiles ) { // Move files to destination folder
					 * child.renameTo(new File(destinationFolder + "\\" + child.getName())); }
					 */
					String fileName;
					for (int i = 0; i < listOfFiles.length; i++) {
						fileName = listOfFiles[i].getName();
						File afile = new File(sourceFolderPath + fileName);
						File bfile = new File(destinationFolderPath + fileName);

						inStream = new FileInputStream(afile);
						outStream = new FileOutputStream(bfile);

						byte[] buffer = new byte[1024];

						int length;
						// copy the file content in bytes
						while ((length = inStream.read(buffer)) > 0) {
							outStream.write(buffer, 0, length);
						}

						inStream.close();
						outStream.close();

						// delete the original file
						afile.delete();
					}
					// Add if you want to delete the source folder
					sourceFolder.delete();
				}
				result = true;
			} else {
				Log.info(sourceFolder + "  Folder does not exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.getMessage());
		}
		return result;
	}

	/**
	 * This method is used to delete an empty directory in a given path
	 */
	public static void deleteEmptyDir() {
		final String FOLDER_LOCATION = System.getProperty("user.dir") + File.separator + "Results" + File.separator;
		boolean isFinished = false;
		do {
			isFinished = true;
			replaceText(FOLDER_LOCATION);
		} while (!isFinished);
	}

	/**
	 * This method is used to delete all the files in a given file location
	 * 
	 * @param fileLocation
	 */
	private static void replaceText(String fileLocation) {
		File folder = new File(fileLocation);
		File[] listofFiles = folder.listFiles();
		if (listofFiles.length == 0) {
			Log4j.info("Folder Name :: " + folder.getAbsolutePath() + " is deleted.");
			folder.delete();
			isFinished = false;
		} else {
			for (int j = 0; j < listofFiles.length; j++) {
				File file = listofFiles[j];
				if (file.isDirectory()) {
					replaceText(file.getAbsolutePath());
				}
			}
		}
	}

	/**
	 * This method is used to delete a file from a given folder
	 * 
	 * @param filePath
	 * @return @
	 */
	public static boolean deleteFileFromFolder(String filePath) {
		File file = new File(filePath);
		boolean isFileExists = false;

		try {
			if (file.exists()) {
				if (file.delete()) {
					Log.info("The file '" + file.toString() + "' is deleted successfully!!");
				} else {
					Log.info("The file '" + file.toString() + "' is not found to be deleted");
				}
			} else {
				Log.info("The file '" + file.toString() + "' is not found to be deleted");
			}
			isFileExists = file.exists();

		} catch (Exception e) {
			Log4j.info("Failed to delete the file '" + filePath + "' - " + e.getMessage());
			return isFileExists;
		}

		return isFileExists;
	}

	/**
	 * This method is used to move files from source to destination folder from
	 * command line
	 * 
	 * @param oldFilePath
	 * @param destFolderPath @
	 */
	public static void moveFilesfromOneFolderToAnotherFolderInCMD(String oldFilePath, String destFolderPath) {
		String osName = System.getProperty("os.name");

		try {
			if (osName.contains("Windows")) {
				/*
				 * ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "move " +
				 * oldFilePath + " " + destFolderPath); Process p = builder.start();
				 * p.waitFor();
				 */
				String[] command = { "cmd.exe", "/c", "move " + oldFilePath + " " + destFolderPath };
				Process p = Runtime.getRuntime().exec(command);
				StringBuilder sb = new StringBuilder();

				p.waitFor();
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line, st = null;
				while ((line = reader.readLine()) != null) {
					sb = sb.append(line).append("\n");
					st = sb.toString();
				}

				if (st.contains("file(s) moved.")) {
					Log.info("Files moved successfully!!");
				} else {
					Log.info("Failed to move files");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to copy the contents of a file from old file to a new
	 * file
	 * 
	 * @param oldFilePath
	 * @param newFilePath @
	 */
	public static void copyFileContentsToNewFile(String oldFilePath, String newFilePath) {
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader(oldFilePath);
			fw = new FileWriter(newFilePath);
			int c = fr.read();
			while (c != -1) {
				fw.write(c);
				c = fr.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(fr);
			close(fw);
		}
	}

	/**
	 * This method is used to close an open Stream
	 * 
	 * @param stream
	 */
	public static void close(Closeable stream) {
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			Log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to delete the ImageProcessing folder in the project
	 * directory from command line
	 */
	public static void deleteImageProcessingFolder() {
		try {
			String directoryToDelete = tempTestcaseImagesPath + "ImageProcessing";
			waitFor(3);

			if (deleteDirFromCMDPrompt(directoryToDelete)) {
				Log.info("The temporary directory '" + directoryToDelete + "' is successfully deleted after executing all the testcases");
			}
		} catch (Exception e) {
			Log4j.info("Failed to delete the ImageProcessing folder - " + e.getMessage());
		}
	}

	/**
	 * This method is used to convert MS Word to PDF document
	 * 
	 * @param docPath
	 */
	/*
	 * public static void convertWordDocToPDF(String docPath, String pdfPath) { try
	 * { FileInputStream doc = new FileInputStream(new File(docPath)); XWPFDocument
	 * document = new XWPFDocument(doc); String k = null; XWPFWordExtractor we = new
	 * XWPFWordExtractor(document); k = we.getText();
	 * 
	 * PdfOptions options = PdfOptions.create(); OutputStream out = new
	 * FileOutputStream(new File(pdfPath));
	 * PdfConverter.getInstance().convert(document, out, options); doc.close();
	 * out.close(); } catch (Exception e) { e.printStackTrace();
	 * Log.info(e.getMessage()); } }
	 */

	/**
	 * This method is used to convert MS Word to HTML document
	 * 
	 * @param docPath
	 */
	public static void convertWordDocToHTML(String docPath) {
		String osName = System.getProperty("os.name");
		File file = new File(docPath);
		try {
			if (osName.contains("Windows")) {
				if (file.exists()) {
					Process p = Runtime.getRuntime().exec(new String[] { "" + docPath });
					waitFor(2);
					StringBuilder sb = new StringBuilder();
					BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
					String line;
					while ((line = reader.readLine()) != null) {
						sb = sb.append(line).append("\n");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to copy the folder contents from source to destination
	 * folder
	 * 
	 * @param src
	 * @param dest
	 */
	public static void copyFolder(File src, File dest) {
		try {
			if (src.isDirectory()) {
				// if directory not exists, create it
				if (!dest.exists()) {
					dest.mkdir();
					Log4j.info("Directory copied from " + src + "  to " + dest);
				}

				// list all the directory contents
				String files[] = src.list();

				for (String file : files) {
					// construct the src and dest file structure
					File srcFile = new File(src, file);
					File destFile = new File(dest, file);
					// recursive copy
					copyFolder(srcFile, destFile);
				}
			} else {
				// if file, then copy it
				// Use bytes stream to support all file types
				InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dest);

				byte[] buffer = new byte[1024];

				int length;
				// copy the file content in bytes
				while ((length = in.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}

				in.close();
				out.close();
				Log4j.info("File copied from " + src + " to " + dest);
			}
		} catch (Exception e) {
			Log4j.info("Failed to copy folder");
			Log4j.info(e.getMessage());
		}
	}

	/**
	 * This method is used to copy folder contents from source to destionation
	 * folder path
	 * 
	 * @param srcFolderPath
	 * @param destFolderPath @
	 */
	public static void copyFolderContents(String srcFolderPath, String destFolderPath) {
		File srcFolder = new File(srcFolderPath);
		File destFolder = new File(destFolderPath);

		try {
			// make sure source exists
			if (!srcFolder.exists()) {
				Log4j.info("Directory does not exist.");
				// just exit
				System.exit(0);
			} else {
				copyFolder(srcFolder, destFolder);
				Log.info("Folder and its contents are successfully copied!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.getMessage());
		}
	}

	/**
	 * This method is used to remove a line in a file if found
	 * 
	 * @param file
	 * @param lineToRemove
	 */
	public static void removeLineFromFile(String file, String lineToRemove) {
		try {

			File inFile = new File(file);

			if (!inFile.isFile()) {
				Log4j.info("Parameter is not an existing file");
				return;
			}

			// Construct the new file that will later be renamed to the original filename.
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			String line = null;

			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = br.readLine()) != null) {

				if (!line.trim().equals(lineToRemove)) {

					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();

			// Delete the original file
			if (!inFile.delete()) {
				Log4j.info("Could not delete file");
				return;
			}

			// Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inFile))
				Log4j.info("Could not rename file");

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used to search for a string in a file and replace with a new
	 * string
	 * 
	 * @param file
	 * @param search
	 * @param replacement
	 */
	public static void replaceStringInFile(String file, String search, String replacement) {
		File inFile = new File(file);

		// file reading
		File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
		try {

			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			String line;

			while ((line = br.readLine()) != null) {
				if (!line.trim().contains(search)) {
					line.replaceAll(search, replacement);
					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();

			if (!inFile.delete()) {
				Log4j.info("Could not delete file");
				return;
			}

			// Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inFile))
				Log4j.info("Could not rename file");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(e.getMessage());
		}
	}

	/**
	 * This method reads the contents of a file and returns as a String
	 * 
	 * @param pathname
	 * @return
	 * @throws IOException
	 */
	public static String readFile(String pathname) {
		String fileData = null;
		File file = new File(pathname);

		try {
			Scanner scanner = new Scanner(file);
			StringBuilder fileContents = new StringBuilder((int) file.length());

			String lineSeparator = System.getProperty("line.separator");

			while (scanner.hasNextLine()) {
				fileContents.append(scanner.nextLine() + lineSeparator);
			}

			fileData = fileContents.toString();
			scanner.close();

		} catch (Exception e) {
			Log4j.info("Failed to read the contents of the file: '" + pathname + "' - " + e.getMessage());
		}

		return fileData;
	}

	/**
	 * This method returns the Class file locator path for a given page Class name
	 * 
	 * @param pageClassName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getClassLocatorPath(String pageClassName) {
		File root = new File(frameworkTestResourcesPath);

		try {
			boolean recursive = true;
			String executionFolderType = getExecutionDeviceType();
			if (!executionFolderType.equalsIgnoreCase("Desktop")) {
				executionFolderType = "mobile";
			} else {
				executionFolderType = "desktop";
			}

			Collection files = FileUtils.listFiles(root, null, recursive);

			for (Iterator iterator = files.iterator(); iterator.hasNext();) {
				File file = (File) iterator.next();
				String fileObsolutePath = file.getAbsolutePath();
//	            if (file.getName().contains(pageClassName + ".properties") && fileObsolutePath.contains(executionFolderType) && (fileObsolutePath.toLowerCase().contains(projectName.toLowerCase() + "testdata" ) || fileObsolutePath.toLowerCase().contains("automationframeworktestdata"))) {
//	            		return fileObsolutePath;
//	            }

				if (file.getName().contains(pageClassName + ".properties")
						&& fileObsolutePath.toLowerCase().contains("automationframeworktestdata")) {
					return fileObsolutePath;
				} else if (file.getName().contains(pageClassName + ".properties")
						&& fileObsolutePath.contains(executionFolderType)) {
					return fileObsolutePath;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method is used to generate Jenkins report folder to save the results
	 * file @
	 */
	public static void generateJenkinsReport() {
		try {
			File file = getLatestFile(System.getProperty("user.dir") + File.separator + "Results" + File.separator);
			String filePath = file.toString();
			File file2 = getHTMLFile(filePath);
			String oldFileName = file2.toString();
			String jenkinsReportPath = System.getProperty("user.dir") + File.separator + "JenkinsReport"
					+ File.separator;
			File jenkinsReportFolder = new File(jenkinsReportPath);

			if (!jenkinsReportFolder.exists()) {
				new File(jenkinsReportPath).mkdirs();
				Log4j.info("JenkinsReport folder created successfully!!");
				Log4j.info("Path to JenkinsReport folder: " + jenkinsReportPath);

			} else {
				Log4j.info("Failed to create JenkinsReport folder or the folder does not exist!!");
			}

			String newFilePath = System.getProperty("user.dir") + File.separator + "JenkinsReport" + File.separator
					+ "AutomationReport.html";
			copyFileContentsToNewFile(oldFileName, newFilePath);
			copyFolderContents(file.toString(),
					System.getProperty("user.dir") + File.separator + "JenkinsReport" + File.separator);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info(
					"JenkinsReport file not found. Failed to create JenkinsReport folder or the folder does not exist!!");
		}
	}

	/**
	 * This method is used to copy the failed testcases' screenshots to Jenkinks
	 * Report folder @
	 */
	public static void copyFailedTestsScreenshotsToJenkinsReport() {
		try {
			File file = getLatestFile(System.getProperty("user.dir") + File.separator + "Results" + File.separator);
			String filePath = file.toString();
			File file2 = getHTMLFile(filePath);
			String oldFileName = file2.toString();
			String newFilePath = System.getProperty("user.dir") + File.separator + "JenkinsReport" + File.separator
					+ "AutomationReport.html";
			copyFileContentsToNewFile(oldFileName, newFilePath);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to copy failed test screenshots to JenkinsReport folder!!");
		}
	}

	/**
	 * This method is used to replace the Jenkins desktop results folder name with
	 * appropriate Jenkins job name For ex. Desktop_CA_Results / Desktop_WOD_Results
	 * / Desktop_AA_Results
	 * 
	 * @param sourceName
	 * @return @
	 */
	public static String replaceJenkinsDesktopResultsFolderName(String sourceName) {
		String destPath = null;
		if (sourceName.toLowerCase().contains("cp_desktop_wod_daily")) {
			destPath = sourceName.replace("CP_Desktop_WOD_Daily", "Desktop_WOD_Results");
		} else if (sourceName.toLowerCase().contains("cp_desktop_ca_daily")) {
			destPath = sourceName.replace("CP_Desktop_CA_Daily", "Desktop_CA_Results");
		} else if (sourceName.toLowerCase().contains("cp_desktop_aa_daily")) {
			destPath = sourceName.replace("CP_Desktop_AA_Daily", "Desktop_AA_Results");
		}

		return destPath;
	}

	/**
	 * This method is used to check if a process is running in a Windows laptop
	 * 
	 * @param processName
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static boolean isProcessRunning(String processName) throws IOException, InterruptedException {
		try {
			StringBuilder sb = new StringBuilder();
			Process p = Runtime.getRuntime().exec(new String[] { listProcessBatFilePath });
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line, tasksList = null;
			while ((line = reader.readLine()) != null) {
				sb = sb.append(line).append("\n");
				tasksList = sb.toString();
			}
			Log4j.info("Task list contains java ? - " + tasksList.contains(processName));
			return tasksList.contains(processName);
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		}
		return false;
	}

	/**
	 * This method is used to convert an InputStream to a String
	 * 
	 * @param inputStream
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String toString(InputStream inputStream) {
		try {
			Scanner scanner = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
			String string = scanner.hasNext() ? scanner.next() : "";
			scanner.close();

			return string;
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		}
		return "";
	}

	/**
	 * This method is used to kill an active task process in a Windows laptop
	 * 
	 * @param processName
	 * @return @
	 */
	public static boolean killTaskProcess(String processName) {
		String line, taskKill = "";
		boolean result = false;
		StringBuilder sb = new StringBuilder();
	
		try {
			if (isProcessRunning(processName)) {
				Log4j.info("java.exe process is running");
				Process p = Runtime.getRuntime().exec(new String[] { killProcessBatFilePath, processName });
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = reader.readLine()) != null) {
					Log4j.info("before task kill process ");
					sb = sb.append(line).append("\n");
					Log4j.info("after task kill process ");
					taskKill = sb.toString();
					Log4j.info("EOW - task kill process end result - " + taskKill);
				}
				Log4j.info("Waiting for 1 sec ");
				waitFor(2);
			}
			Log4j.info("task kill process end result - " + taskKill + "-");
			result = taskKill.toUpperCase().contains("SUCCESS");
			if (result) {
				Log4j.info("Java Kill process successful");
			} else {
				Log4j.info("Java Kill process unsuccessful");
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		}
		return result;
	}

	/**
	 * This method is used to write data into a file - this method always overwrites
	 * data
	 * 
	 * @param filePath
	 * @param str
	 * @return @
	 */
	public static void writeDataToTextFile(String filePath, String text) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(filePath, "UTF-8");

			Log4j.info("Writing contents to the file '" + getFileNameWithExtensionFromFilePath(filePath) + "'");
			writer.println(text);
			
			Log4j.info("Closing the file '" + getFileNameWithExtensionFromFilePath(filePath) + "'");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		}
	}

	/**
	 * This method is used to append data into an existing file
	 * 
	 * @param filePath
	 * @param str
	 * @return @
	 */
	public static void appendStrToFile(String filePath, String str) {
		try {
			// Open given file in append mode.
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true));
			out.write(str);
			out.close();
		} catch (IOException e) {
			Log4j.info("Exception occured during appending data to file " + filePath + "\n" + e.getMessage());
		}
	}

	/**
	 * This method will create a new file if file does not exist in filepath and
	 * returns the file
	 * 
	 * @param filePath
	 * @return File
	 */
	public static File createNewFile(String filePath) {
		File memoryLogFile = new File(filePath);
		try {
			boolean isNewFileCreated = memoryLogFile.createNewFile();
			if (isNewFileCreated) {
				Log4j.info("File has been created successfully " + memoryLogFile.getAbsolutePath());
			} else {
				Log4j.info("File already present at the specified location " + memoryLogFile.getAbsolutePath());
			}
		} catch (IOException e) {
			Log4j.info("Exception occured during creating file " + filePath + "\n" + e.getMessage());
		}
		return memoryLogFile;
	}

	/**
	 * This method is used to clear the contents of a file
	 * 
	 * @param file @
	 */
	public static void clearFileContents(File file) {
		try {
			PrintWriter writer = new PrintWriter(file);

			Log4j.info("Clearing the contents of the file '" + file.getName() + "'");
			writer.print("");

			Log4j.info("Closing the file '" + file.getName() + "'");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		}
	}

	/**
	 * This method returns the filename with extension from file path
	 * 
	 * @param filePath
	 * @return @
	 */
	public static String getFileNameWithExtensionFromFilePath(String filePath) {
		String filename = "";
		
		try {
			if (filePath.contains("/")) {
				filename = filePath.substring(filePath.lastIndexOf("/") + 1);
			} else if (filePath.contains("\\")) {
				filename = filePath.substring(filePath.lastIndexOf("\\") + 1);
			}
			
			Log4j.info("File name with extension from file path is: " + filename);
			return filename;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the file name with extension from file path");
			Log4j.info(e.getMessage());
			return filename;
		}
	}

	/**
	 * This method is used to compare two files and display differences
	 * 
	 * @param file1
	 * @param file2 @
	 */
	public static void compareFileContentsAndDisplayDifferences(String file1, String file2) {
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		String sCurrentLine;
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> tmpList = new ArrayList<String>(list1);

		try {
			br1 = new BufferedReader(new FileReader(file1));
			br2 = new BufferedReader(new FileReader(file2));

			while ((sCurrentLine = br1.readLine()) != null) {
				list1.add(sCurrentLine);
			}
			while ((sCurrentLine = br2.readLine()) != null) {
				list2.add(sCurrentLine);
			}

			tmpList.removeAll(list2);
			System.out.println("Content from the file '" + getFileNameWithExtensionFromFilePath(file1)
					+ "' which is not there in the file '" + getFileNameWithExtensionFromFilePath(file2) + "'");

			for (int i = 0; i < tmpList.size(); i++) {
				System.out.println(tmpList.get(i)); // content from file1 which is not there in file2
			}

			System.out.println("Content from the file '" + getFileNameWithExtensionFromFilePath(file2)
					+ "' which is not there in the file '" + getFileNameWithExtensionFromFilePath(file1) + "'");

			tmpList = list2;
			tmpList.removeAll(list1);

			for (int i = 0; i < tmpList.size(); i++) {
				System.out.println(tmpList.get(i)); // content from file2 which is not there in file1
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong when trying to compare the files .....");
		}
	}

	/**
	 * This method returns the difference between two Strings
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String getStringDifferences(String str1, String str2) {
		if (str1 == null) {
			return str2;
		}
		if (str2 == null) {
			return str1;
		}
		int at = indexOfDifference(str1, str2);
		if (at == 0) {
			return "";
		}
		return str2.substring(at);
	}

	/**
	 * This method returns the character index of two given strings
	 * 
	 * @param cs1
	 * @param cs2
	 * @return
	 */
	public static int indexOfDifference(CharSequence cs1, CharSequence cs2) {
		if (cs1 == cs2) {
			return 0;
		}
		if (cs1 == null || cs2 == null) {
			return 0;
		}
		int i;
		for (i = 0; i < cs1.length() && i < cs2.length(); ++i) {
			if (cs1.charAt(i) != cs2.charAt(i)) {
				break;
			}
		}
		if (i < cs2.length() || i < cs1.length()) {
			return i;
		}
		return 0;
	}

	/**
	 * This method is used to create 'adbUninstallSettings.bat' file at Runtime
	 * which can be deleted on exit
	 * 
	 * @return
	 * @throws Exception @
	 */
	public static File createAdbUninstallSettingsBatFile() throws Exception {
		File adbUninstallSettingsBat = File.createTempFile("adbUninstallSettings", ".bat");
		try {
			String line1 = "set par1=%1";
			String line2 = "adb -s %par1% uninstall io.appium.settings";
			String lineSpace = "\n" + "\n";
			String line = line1 + lineSpace + line2;

			writeDataToTextFile(adbUninstallSettingsBat.getAbsolutePath(), line);

			return adbUninstallSettingsBat;
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong when creating 'adbUninstallSettings.bat' file");
			return adbUninstallSettingsBat;
		}
	}

	/**
	 * This method is used to create 'adbUninstallUnlock.bat' file at Runtime which
	 * can be deleted on exit
	 * 
	 * @return
	 * @throws Exception @
	 */
	public static File createAdbUninstallUnlockBatFile() throws Exception {
		File adbUninstallUnlockBat = File.createTempFile("adbUninstallUnlock", ".bat");
		try {
			String line1 = "set par1=%1";
			String line2 = "adb -s %par1% uninstall io.appium.unlock";
			String lineSpace = "\n" + "\n";
			String line = line1 + lineSpace + line2;

			writeDataToTextFile(adbUninstallUnlockBat.getAbsolutePath(), line);

			return adbUninstallUnlockBat;
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong when creating 'adbUninstallUnlock.bat' file");
			return adbUninstallUnlockBat;
		}
	}

	/**
	 * This method is used to create 'AddRegistry.bat' file at Runtime which can be
	 * deleted on exit
	 * 
	 * @return
	 * @throws Exception @
	 */
	public static File createAddRegistryBatFile() throws Exception {
		File addRegistryBat = File.createTempFile("AddRegistry", ".bat");
		try {
			String line1 = "set par1=%1";
			String line2 = "set par2=%2";
			String line3 = "Echo Yes | reg add HKLM" + File.separator + "SYSTEM" + File.separator + "CurrentControlSet"
					+ File.separator + "Control" + File.separator + "Class" + File.separator
					+ "{4d36e972-e325-11ce-bfc1-08002be10318}" + File.separator + "%par1% /v NetworkAddress /d %par2%";
			String lineSpace = "\n" + "\n";
			String line = line1 + lineSpace + line2 + lineSpace + line3;

			writeDataToTextFile(addRegistryBat.getAbsolutePath(), line);

			return addRegistryBat;
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong when creating 'AddRegistry.bat' file");
			return addRegistryBat;
		}
	}

	/**
	 * This method is used to create 'DeleteFolder.bat' file at Runtime which can be
	 * deleted on exit
	 * 
	 * @return
	 * @throws Exception @
	 */
	public static File createDeleteFolderBatFile() throws Exception {
		File deleteFolderBat = File.createTempFile("DeleteFolder", ".bat");
		try {
			String line1 = "set par1=%1";
			String line2 = "rd /s /q %par1%";
			String lineSpace = "\n" + "\n";
			String line = line1 + lineSpace + line2;

			writeDataToTextFile(deleteFolderBat.getAbsolutePath(), line);

			return deleteFolderBat;
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong when creating 'adbUninstallUnlock.bat' file");
			return deleteFolderBat;
		}
	}

	/**
	 * This method is used to create 'DeleteRegistry.bat' file at Runtime which can
	 * be deleted on exit
	 * 
	 * @return
	 * @throws Exception @
	 */
	public static File createDeleteRegistryBatFile() throws Exception {
		File deleteRegistryBat = File.createTempFile("DeleteRegistry", ".bat");
		try {
			String line1 = "set par1=%1";
			String line2 = "Echo Yes | reg delete HKLM" + File.separator + "SYSTEM" + File.separator
					+ "CurrentControlSet" + File.separator + "Control" + File.separator + "Class" + File.separator
					+ "{4d36e972-e325-11ce-bfc1-08002be10318}" + File.separator + "%par1% /v NetworkAddress";
			String lineSpace = "\n" + "\n";
			String line = line1 + lineSpace + line2;

			writeDataToTextFile(deleteRegistryBat.getAbsolutePath(), line);

			return deleteRegistryBat;
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong when creating 'DeleteRegistry.bat' file");
			return deleteRegistryBat;
		}
	}

	/**
	 * This method is used to create 'firmwareUpgrade.bat' file at Runtime which can
	 * be deleted on exit
	 * 
	 * @return
	 * @throws Exception @
	 */
	public static File createFirmwareUpgradeBatBatFile() throws Exception {
		File firmwareUpgradeBat = File.createTempFile("firmwareUpgrade", ".bat");
		try {
			String line1 = "set par1=%1";
			String line2 = "set par2=%2";
			String line3 = "set par3=%3";
			String line4 = "set par4=%4";
			String line5 = "set par4=%5";
			String line6 = "snmpset -v2c -c hDaFHJG7 %par1% .1.3.6.1.2.1.69.1.3.%par2%.0 %par3% %par4%";
			String line7 = "snmpset -v2c -c hDaFHJG7 %par1% .1.3.6.1.2.1.69.1.3.2.0 s \"%par5%\"";
			String line8 = "snmpset -v2c -c hDaFHJG7 %par1% .1.3.6.1.2.1.69.1.3.3.0 i 1";
			String lineSpace = "\n" + "\n";
			String line = line1 + lineSpace + line2 + lineSpace + line3 + lineSpace + line4 + lineSpace + line5
					+ lineSpace + line6 + lineSpace + line7 + lineSpace + line8;

			writeDataToTextFile(firmwareUpgradeBat.getAbsolutePath(), line);

			return firmwareUpgradeBat;
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong when creating 'firmwareUpgrade.bat' file");
			return firmwareUpgradeBat;
		}
	}

	/**
	 * This method is used to create 'killTaskProcesses.bat' file at Runtime which
	 * can be deleted on exit
	 * 
	 * @return
	 * @throws Exception @
	 */
	public static File createKillTaskProcessesBatFile() throws Exception {
		File killTaskProcessesBat = File.createTempFile("firmwareUpgrade", ".bat");
		try {
			String line1 = "cd c:" + File.separator + "Windows" + File.separator + "System32";
			String line2 = "set par1=%1";
			String line3 = "taskkill.exe /F /IM %par1%";
			String lineSpace = "\n" + "\n";
			String line = line1 + lineSpace + line2 + lineSpace + line3;

			writeDataToTextFile(killTaskProcessesBat.getAbsolutePath(), line);

			return killTaskProcessesBat;
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong when creating 'killTaskProcesses.bat' file");
			return killTaskProcessesBat;
		}
	}

	/**
	 * This method is used to create 'listTaskManagerProcesses.bat' file at Runtime
	 * which can be deleted on exit
	 * 
	 * @return
	 * @throws Exception @
	 */
	public static File createListTaskManagerProcessesBatFile() throws Exception {
		File listTaskManagerProcessesBat = File.createTempFile("listTaskManagerProcesses", ".bat");
		try {
			String line1 = "cd c:" + File.separator + "Windows" + File.separator + "System32";
			String line2 = "tasklist.exe | sort /R";
			String lineSpace = "\n" + "\n";
			String line = line1 + lineSpace + line2;

			writeDataToTextFile(listTaskManagerProcessesBat.getAbsolutePath(), line);

			return listTaskManagerProcessesBat;
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong when creating 'listTaskManagerProcesses.bat' file");
			return listTaskManagerProcessesBat;
		}
	}


	/**
	 * This method is used to get the downloads folder path
	 * 
	 * @return @
	 */
	public static String getCurrentUserName() {
		String username = null;

		try {
			if (isWindows()) {
				Process p = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", "echo %username%" });
				StringBuilder sb = new StringBuilder();

				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line, st = null;
				while ((line = reader.readLine()) != null) {
					sb = sb.append(line).append("\n");
					st = sb.toString();
				}
				username = st.trim();

			} else if (isMAC()) {
				StringBuilder sb = new StringBuilder();
				String line = "";
				String str = null;

				Runtime run = Runtime.getRuntime();
				Process pr = run.exec("whoami");
				pr.waitFor();
				BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

				while ((line = buf.readLine()) != null) {
					sb = sb.append(line).append("\n");
					str = sb.toString();
				}

				str = str.trim();
				username = str;
			}

			Log4j.info("The current username is: " + username);
			return username;

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the current logged in user credentials");
			return username;
		}
	}

	/**
	 * This method is used to check if a text exists in a File
	 * 
	 * @param filePath
	 * @param textToSearch
	 * @return @
	 */
	public static boolean isTextFoundInFile(String filePath, String textToSearch) {
		boolean result = false;

		try {
			File file = new File(filePath);
			Scanner scanner = new Scanner(file);
			int lineNum = 0;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				lineNum++;

				if (line.contains(textToSearch)) {
					result = line.contains(textToSearch);
					Log4j.info("The text '" + textToSearch + "' is found on line number " + lineNum + " in the file '" + filePath + "'");
				}
			}

			// Closing the scanner
			scanner.close();

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to check if the text exists in the file or not");
		}
		return result;
	}

	/**
	 * This method is used to check if a file exists in a File folder or any path
	 * 
	 * @param filePath/folder path
	 * @param filename        to search
	 * @return boolean @
	 */
	public static boolean isFileExistInAFolder(String folderPath, String fileName) {
		boolean fileFound = false;
		try {
			File dir = new File(folderPath);
			File[] directoryFiles = dir.listFiles();
			String[] fileNameArray = null;
			String filenameToCompare = null;
			String fileSeperator = null;
			if (isMAC()) {
				fileSeperator = "/";
			} else if (isWindows()) {
				fileSeperator = "\\\\";
			}

			for (int i = 0; i < directoryFiles.length; i++) {
				fileNameArray = directoryFiles[i].toString().split(fileSeperator);
				filenameToCompare = fileNameArray[fileNameArray.length - 1];
				fileFound = filenameToCompare.equalsIgnoreCase(fileName);
				if (fileFound) {
					Log4j.info("File - " + fileName + " found in directory - " + folderPath);
					break;
				}
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to check if the text exists in the file or not");
		}
		
		Log4j.info("Is the file '" + fileName + "' found in the directory '" + folderPath + "' : " + fileFound);
		return fileFound;
	}

	/**
	 * This method will set read and write permissions to a file and also sets it as
	 * an executable file.
	 * 
	 * @param filePath
	 * @return nothing @
	 */
	public static void setReadAndWriteAccessAndMakeItAnExecutableToAnyFileOnMac(String filepath) {
		try {
			if (isMAC()) {
				setReadAndWriteAccessToAnyFile(filepath);
				Log4j.info("Assigning the executable privileages to file " + filepath);
				Runtime.getRuntime().exec("chmod a+x * " + filepath);
			}

		} catch (Exception e) {
			Log4j.info("Inside setReadAndWriteAccessAndMakeItAnExecutableToAnyFile method " + e.getMessage());
		}
	}

	/**
	 * This method will set read and write permissions to a file
	 * 
	 * @param filePath
	 * @return nothing @
	 */
	public static void setReadAndWriteAccessToAnyFile(String filepath) {
		try {
			if (isMAC()) {
				Log4j.info("Assigning the read write privileages to file " + filepath);
				Runtime.getRuntime().exec("chmod 777 * " + filepath);
			}
		} catch (Exception e) {
			Log4j.info("Inside setReadAndWriteAccessToAnyFile method " + e.getMessage());
		}
	}

	/**
	 * This method is used to create a folder if not exists in a given path
	 * 
	 * @param folderPath
	 */
	public static void createFolderIfNotExist(String folderPath) {
		try {
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("_dd_MMM_yyyy");
			String currentDateTime = format.format(date);
			folderPath = folderPath + currentDateTime;
			File theDir = new File(folderPath);

			Log4j.info("Checking if the directory exists or not");
			if (!theDir.exists()) {
				Log4j.info("Creating the directory: " + theDir.getName());
				boolean result = false;

				theDir.mkdirs();
				result = theDir.exists();

				if (result) {
					Log4j.info("The directory '" + theDir.getName() + "' is created successfully");
				}
			} else if (theDir.exists()) {
				Log4j.info("The directory '" + theDir.getName() + "' already exists!!");
			}

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to create the folder");
		}
	}

	/**
	 * This method is used to create a folder if not exists in a given path with
	 * timestamp
	 * 
	 * @param folderPath
	 */
	public static void createFolderIfNotExistWithTimestamp(String folderPath) {
		try {
			String currentDateTime = CalendarHelper.getTimestampWithMonth();
			folderPath = folderPath + currentDateTime;
			File theDir = new File(folderPath);

			Log4j.info("Checking if the directory exists or not");
			if (!theDir.exists()) {
				Log4j.info("Creating the directory: " + theDir.getName());
				boolean result = false;

				theDir.mkdirs();
				result = theDir.exists();

				if (result) {
					Log4j.info("The directory '" + theDir.getName() + "' is created successfully");
				}
			} else if (theDir.exists()) {
				Log4j.info("The directory '" + theDir.getName() + "' already exists!!");
			}

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to create the folder");
		}
	}

	/**
	 * This method is used to create a folder if not exists in a given path with
	 * same folder name
	 * 
	 * @param folderPath
	 */
	public static void createFolderIfNotExistWithSameFolderName(String folderPath) {
		try {
			File theDir = new File(folderPath);

			Log4j.info("Checking if the directory exists or not");
			if (!theDir.exists()) {
				Log4j.info("Creating the directory: " + theDir.getName());
				boolean result = false;

				theDir.mkdirs();
				result = theDir.exists();

				if (result) {
					Log4j.info("The directory '" + theDir.getName() + "' is created successfully");
				}
			} else if (theDir.exists()) {
				Log4j.info("The directory '" + theDir.getName() + "' already exists!!");
			}

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to create the folder");
		}
	}

	/**
	 * This method is used to delete the first line from a file
	 * 
	 * @param filePath
	 */
	public static void removeFirstLineFromFile(String filePath) {
		try {
			Log4j.info("Removing the first line from the file '" + filePath + "'");

			File path = new File(filePath);
			Scanner scanner = new Scanner(path);
			ArrayList<String> coll = new ArrayList<String>();
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				coll.add(line);
			}

			scanner.close();

			FileWriter writer = new FileWriter(path);
			for (String line : coll) {
				writer.write(line);
			}

			writer.close();

		} catch (Exception e) {
			Log4j.info("Failed to delete the 1st line from the file '" + filePath + "'");
		}
	}

	/**
	 * This method is used to read the last line of a file
	 * 
	 * @param filePath
	 * @return
	 */
	public static String readLastLineFromFile(String filePath) {
		String lastLine = "";

		try {
			LineIterator lineIterator = FileUtils.lineIterator(new File(filePath), "UTF-8");

			while (lineIterator.hasNext()) {
				lastLine = lineIterator.nextLine();
			}

			return lastLine;

		} catch (Exception e) {
			Log4j.info("Failed to read the last line of the file '" + filePath + "'");
			return lastLine;
		}
	}

	/**
	 * This method is used to get the file path without file name from given
	 * complete filepath
	 * 
	 * @param completeFilePath
	 * @return
	 */
	public static String getFilePathWithoutFileName(String completeFilePath) {
		String filePath = "";

		try {
			File file = new File(completeFilePath);
			filePath = file.getParent();
			Log4j.info("File path without file name is: " + filePath);
			return filePath;

		} catch (Exception e) {
			Log4j.info("Failed to get the file path without filename - " + e.getMessage());
			return filePath;
		}
	}

	/**
	 * This method is used to search for a string in a file modify the contents of
	 * the file
	 * 
	 * @param filePath
	 * @param oldString
	 * @param newString
	 */
	public static void searchAndReplaceFileContent(String filePath, String oldString, String newString) {
		File fileToBeModified = new File(filePath);
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));

			// Reading all the lines of input text file into oldContent
			String line = reader.readLine();

			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			}

			// Replacing oldString with newString in the oldContent
			String newContent = oldContent.replaceAll(oldString, newString);

			// Rewriting the input text file with newContent
			writer = new FileWriter(fileToBeModified);

			writer.write(newContent);

		} catch (IOException e) {
			Log4j.info("Failed to modify the file contents");
			Log4j.info(e.getMessage());

		} finally {
			try {
				Log4j.info("Closing the resources");
				reader.close();
				writer.close();
			} catch (IOException e) {
				Log4j.info("Failed to close the resources");
				Log4j.info(e.getMessage());
			}
		}
	}
	
	/**
	 * This method is used to move a file from source directory to destination directory
	 */
	public static void moveSingleFileFromOneDirectoryToAnother(String sourceFilePath, String destFilePath) {
		try {
			String command = "";
			
			if (isWindows()) {
				command = "move /y " + sourceFilePath + " " + destFilePath;
				
			} else if (isMAC()) {
				command = "mv " + sourceFilePath + " " + destFilePath;
			}
			
			Log4j.info("The command to move file from source to destination folder is: " + command);
			CommandLineUtilsHelper.executeCmdAndGetResult(command);
			
		} catch (Exception e) {
			Log4j.info("Failed to move the file from source directory to destination directory");
			Log4j.info(e.getMessage());
		}
	}
}
