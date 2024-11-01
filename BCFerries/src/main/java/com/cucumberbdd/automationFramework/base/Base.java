package com.cucumberbdd.automationFramework.base;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.driverUtils.AndroidADBUtilsHelper;
import com.cucumberbdd.automationFramework.driverUtils.PhysicalDeviceDetails;
import com.cucumberbdd.automationFramework.logUtils.LoggerHelper;
import com.cucumberbdd.automationFramework.reportsHelper.Accessories;
import com.cucumberbdd.automationFramework.utilsHelper.Browser;
import com.cucumberbdd.automationFramework.utilsHelper.ConfigMgr;
import com.cucumberbdd.automationFramework.utilsHelper.DeviceDetails;
import com.cucumberbdd.automationFramework.utilsHelper.ExcelUtils;
import com.cucumberbdd.automationFramework.utilsHelper.FileUtilityHelper;
import com.cucumberbdd.automationFramework.utilsHelper.PropertiesHelper;
import com.cucumberbdd.automationFramework.utilsHelper.ScreenshotUtilsHelper;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base  {
	public static LoggerHelper logHelper = new LoggerHelper();
	//public static ExtentReports extent;
	//public static ExtentTest logger;
	public static String timeStamp = Accessories.timeStamp().replace(" ", "_").replace(":", "_").replace(".", "_");
	public static String timeStampBeforeSuite = Accessories.timeStamp().replace(" ", "_").replace(":", "_").replace(".", "_");
	public static Logger Log4j = Logger.getLogger(Base.class.getName());
	
	public static Method method;
	public static String currentTestMethodName;
	public static boolean skipNextTestCase = false;
	public static int successCounter, failureCounter;
	public static double failCounter;
	public static double passCounter;
	
	public static final String frameworkDriversPath = System.getProperty("user.dir") + File.separator + "lib" + File.separator + "drivers" + File.separator;
	public static final String frameworkTestResourcesPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java";
	public static final String excelFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "EntryCodes.xlsx";
	public static String frameworkConfigPropertiesPath = frameworkTestResourcesPath + File.separator + "config.properties";
	
	public static String driverPath = getDriverPath();
//	public static RemoteWebDriver driver;
	public static WebDriver webDriver;
	public static DesiredCapabilities capabilities;
	public static AppiumDriverLocalService appiumService;
	public static String driverSessionId = "";
	public static io.appium.java_client.TouchAction touchAction = null;
	
	public static String sBrowserType = "";
	public static String sBrowser;
	
	public static String workingDir = System.getProperty("user.dir").replace(File.separator, "/");
	public static String[] uniqueBaseFolderNamesWithMethodsArray;
	public static String[] uniqueBaseFolderNamesWithExcludeMethodsArray;
	
	
	public static List<File> propertiesFilesList = PropertiesHelper.getPropertiesFilesList();
	

	public static String tempTestcaseImagesPath = System.getProperty("user.dir") + File.separator ;
	public static String screenshotPath = System.getProperty("user.dir") + File.separator + "Results" + File.separator;
	
	public static String executeType = null;
	public static String deviceType = getExecutionDeviceType();
	public static String browserName = getBrowserName();
	public static String environmentName = getEnvironmentName();
	public static String deviceName = getDeviceName();
	public static String testCaseName;
	public static String groupName = getCurrentlyExecutedGroupName();
	//public static String serviceUrl = "http://127.0.0.1:4723/wd/hub";
	public static String serviceUrl = "http://0.0.0.0:4723/wd/hub";
	
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	
	//public ScreenRecorder screenRecorder;
	public static String userId;
	public static String killProcessBatFilePath = System.getProperty("user.dir") + File.separator + "KillTaskProcesses.bat";
	public static String listProcessBatFilePath = System.getProperty("user.dir") + File.separator + "ListTaskManagerProcesses.bat";
	public static String adbUninstallSettingsBat = frameworkTestResourcesPath + "automationFrameworkTestData" + File.separator + "adbUninstallSettings.bat";
	
	public static String adbUninstallUnlockBat = frameworkTestResourcesPath + "automationFrameworkTestData" + File.separator + "adbUninstallUnlock.bat";
	
	public static String osName = DeviceDetails.getOSName();
	//public static String iOSPlatformVersion = AppiumiOSBase.getIOSPlatformVersionFromTerminal(deviceName);
	public static String iOSPlatformVersion = "13";
	public static String mobileMacId = null;
	public static String portalType = null;
	public static String currentBrowserName = "";
	public static String currentBrowserVersion = "";
	
	public static String apkFileName = getAPKFileName();
	public static String apkAppPath = frameworkTestResourcesPath + "automationFrameworkTestData" + File.separator + "apkFiles" + File.separator + apkFileName;   //to be added when app is ready, keep the app in project workspace
	
	public static int currentAndroidOSVersion = getCurrentAndroidDeviceOSVersion();
	public static boolean isSamsung = AndroidADBUtilsHelper.isSamsung();
	public static boolean isGoogle = AndroidADBUtilsHelper.isGoogle();
	
	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}
	
	/**
	 * This method is used to perform all before suite operations related to initializing the Extent report 
	 * @
	 */
//	@BeforeSuite (alwaysRun = true)
	public static void beforeSuiteActivity()  {
		try {
			initiateLog4jConfigurator();
			Log4j.info("Beginning of @BeforeSuite Activities ");
			
			/*if (deviceType.equalsIgnoreCase("Android")) {
				AndroidADBUtilsHelper.setAndroidScreenInPortraitMode();
			}
			
			Log4j.info("Deleting the ImageProcessing folder");
			deleteImageProcessingFolder();
			
			Log4j.info("Generating the initial ExtentReport .html file");
			//generateInitialExtentReport();*/
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong in BeforeSuite activities!!");
		}
	}
	
	/**
	 * This method is used to instantiate the WebDriver based on the device type 
	 * @
	 */
	public static RemoteWebDriver instantiateDriver() {
		RemoteWebDriver driver = null;
		
		try {
			String browserName = ConfigMgr.getProperty("BrowserName");
			System.out.println("Device Type" + deviceType);
			driver = Browser.getDriver(deviceType, browserName);
			
		} catch (Exception e) {
			Log4j.info("Failed to instantiate the Driver - " + e.getMessage());
		}
		
		return driver;
	}
	
	/**
	 * This method returns the name of the Browser on which the tests need to be performed
	 * For ex. Chrome / Safari etc
	 * @return
	 */
	public static String getBrowserName() {
		try {
			if (deviceType.contains("iOS")) {
				Log4j.info("Setting browser name to 'Safari' on '" + deviceType + "' device");
	            return "Safari";
	            
	        } else if (deviceType.equalsIgnoreCase("Android") | (deviceType.equalsIgnoreCase("Desktop"))) {
	        	Log4j.info("Setting browser name to 'Chrome' on '" + deviceType + "' device");
	            return "Chrome";
	        } 	
			
			return "Chrome";
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the Browser Name");
			return "Chrome";
		}
	}
	
	/**
	 * This method returns the config.properties file path based on the project type
	 * @return
	 */
	public static String getConfigFilePath() {
		Properties prop = new Properties();
		
		try {
			
			File file = new File(frameworkConfigPropertiesPath);
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			
			String projectName = prop.getProperty("Project_Name");
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the Config file path!!");
		}
		return "";
	}
	
	/**
	 * This method returns the current execution device type
	 * For ex. Dektop (Windows/Macbook) / Android / iOS
	 * @return
	 */
	public static String getExecutionDeviceType() {
		try {
			if (System.getProperty("deviceType") != null) {
				String deviceType = System.getProperty("deviceType");
				executeType = "maven";
				if (deviceType.contains("iOS")) {
					return "iOS";
				} else if (deviceType.contains("Android")) {
					return "Android";
				} else if (deviceType.contains("Desktop")) {
					return "Desktop";
				} 
			} else {
				executeType = "local";
				return ConfigMgr.getProperty("DeviceType");
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the execution device type!!");
			return "";
		}
		
		return "";
	}
	
	/**
	 * This method is used to get the driver path
	 * @return
	 */
	public static String getDriverPath() {
		String driverFilePath = "";
		
		try {
			String currentOS = System.getProperty("os.name");
			
			if (currentOS.contains("Windows")) {
				driverFilePath = frameworkDriversPath + "chromedriver.exe";
				System.out.println();
				System.setProperty("webdriver.chrome.driver", driverFilePath);
			
			} else if (currentOS.contains("Mac")) {
				driverFilePath = frameworkDriversPath + "chromedriver";
				System.setProperty("webdriver.chrome.driver", driverFilePath);
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			System.out.println("Failed to get driver path " + e.getMessage());
		}
		
		return driverFilePath;
	}
	
	/**
	 * This method returns the current environment name where tests are executed
	 * @return
	 */
	public static String getEnvironmentName() {
		try {
			if (System.getProperty("environment") != null) {
				return System.getProperty("environment");
			} else {
				return PropertiesHelper.getConfigPropertiesKeyValue("Environment");
			}			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the environment name!!");
			return "";
		}
	}
	
	/**
	 * This method returns the current device name on which the tests are executed
	 * @return
	 */
	public static String getDeviceName() {
		try {
			if (System.getProperty("deviceName") != null) {
				return System.getProperty("deviceName");
			} else if (deviceType.equalsIgnoreCase("Desktop")) {
				return PhysicalDeviceDetails.getDesktopDeviceName();
			}
			return PropertiesHelper.getConfigPropertiesKeyValue("DeviceName");	
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the execution device name!!");
			return "";
		}
	}
	
	/**
	 * This method is used to stop/end the screen recording process
	 * @throws Exception 
	 * @
	 */
	/*public void stopRecording() throws Exception  {
		logHelper.info("Started Screen STOP");
		this.screenRecorder.stop();
	}*/
	
	/**
	 * This method is used to create the initial test case report in the project Results folder
	 * @param method
	 * @
	 */
	public static void createTestCaseInReport(Method method) {
		testCaseName = method.getName().toString();
		Log4j.info("Current executing test method is: " + testCaseName);
		//logger = extent.startTest(method.getName());
	}
	
	/**
	 * This method is used to generate the initial execution Extent report in the project Results folder
	 * @
	 */
	public static void generateInitialExtentReport()  {
		try {
		//	extent = new ExtentReports (createNewHTMLReport(), true);
				addSystemInfoToExtentReportSummaryPage();
			
	   //     extent.loadConfig(new File(System.getProperty("user.dir") + File.separator + "extent-config.xml"));
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to generate the initial extent report!!");
		}
	}
	
	/**
	 * This method adds the system info to report file
	 * @return nothing
	 */
	public static void addSystemInfoToExtentReportSummaryPage()  {
		/*	extent
	        .addSystemInfo("Environment", environmentName)
	        .addSystemInfo("System's OS Version", "tempOSVersion") 
	        .addSystemInfo("Device Type", deviceType)
	        .addSystemInfo("Device Name", deviceName)
	        .addSystemInfo("Client Device MAC Address", "tempMAC"); */
	}
	
	/**
	 * This method initiates the Log4j configuration 
	 */
	public static void initiateLog4jConfigurator() {
		DOMConfigurator.configure("log4j.xml");
	}

	/**
	 * This method returns the project Results file path
	 * @return
	 */
	public static String filePath() {
		try {
			String strDirectoy = "ResultFile";
			String screenshotPath = System.getProperty("user.dir") + File.separator + "Results" + File.separator;
			new File(screenshotPath + strDirectoy + "_" + timeStamp).mkdirs();
			return screenshotPath + strDirectoy + "_" + timeStamp + File.separator;
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the File path!!");
			return "";
		}
	}
	
	/**
	 * This method is used to create a new HTML report at the beginning of the execution
	 * @return
	 * @
	 */
	public static String createNewHTMLReport()  {
		try {
			File file = new File(Base.filePath() + "Results_" + Base.timeStampBeforeSuite + ".html");// "Results.html"
			file.createNewFile();
			return file.toString();
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to create a new HTML!!");
			return "";
		}
	}
	
	/**
	 * This method is used to validate a condition and report PASS / FAIL
	 * @param condition
	 * @param strStepName
	 * @param stepDescription
	 * @param customMessage
	 * @
	 */
	public static void validateValue(boolean condition, String strStepName, String stepDescription, String customMessage)  {
		try {
			if (condition) {
				logHelper.info(strStepName + " Validation success - reported as pass");
			} else {
				logHelper.info(strStepName + " Validation failure - reported as fail");
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
	}
	
	/**
	 * This method is used to capture screenshots during the execution
	 * @
	 */
	public static void takeScreenshots() {
		try {
		//	BrowserHelper.waitForPageLoad(10);
			
			if (!deviceType.equalsIgnoreCase("Desktop")) {
				ScreenshotUtilsHelper.captureScreenshot();
			
			} else if (deviceType.equalsIgnoreCase("Desktop")) {
				ScreenshotUtilsHelper.captureDesktopScreenshot(FileUtilityHelper.getTestcaseImagesPath() + File.separator + "pic" + "_" + FileUtilityHelper.getImageTimeStamp() +".png");
			}
			waitFor(1);
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to capture screenshots!!");
		}
	}
	
	/**
	 * This method is used to delete the ImageProcessing folder in the project directory
	 * @
	 */
	public static void deleteImageProcessingFolder()  {
		try {
			String directory = "ImageProcessing";
			File file = new File (tempTestcaseImagesPath + directory + File.separator);
			
			if (isWindows()) {
				if(file.exists()){
					FileUtilityHelper.deleteDirFromCMDPrompt(tempTestcaseImagesPath + directory + File.separator);
				}
			} else if (isMAC()) {
				if (file.exists()) {
					Runtime.getRuntime().exec("rm -R " + file.getAbsolutePath());
				}
				
			} else if (file.exists()) {
				FileUtilityHelper.deleteDir(tempTestcaseImagesPath + directory + File.separator);
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to delete image processing folder!!");
		}
	}
	
	/**
	 * This method is used to delete the FailedTestsScreenshots folder in the project directory
	 * @
	 */
	public static void deleteFailedTestsScreenshotsFolder()  {
		try {
			String directory = "FailedTestsScreenshots";
			String failedTestCaseScreenshotPath = System.getProperty("user.dir") + File.separator + "FailedTestsScreenshots" + File.separator;
			File file = new File(failedTestCaseScreenshotPath);
			
			if (isWindows()) {
				if(file.exists()){
					FileUtilityHelper.deleteDirFromCMDPrompt(failedTestCaseScreenshotPath);
				}
			} else if (isMAC()) {
				if (file.exists()) {
					Runtime.getRuntime().exec("rm -R " + file.getAbsolutePath());
				}
				
			} else if (file.exists()) {
				FileUtilityHelper.deleteDir(failedTestCaseScreenshotPath + directory + File.separator);
			}
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to delete failed tests screenshots folder!!");
		}
	}
	
	/**
	 * This method is used to purge all the files oder than 30 days in the project directory
	 */
	public static void purgeOldFiles() {
		FileUtilityHelper.deleteFilesOlderThan30Days();
	}
	
	/**
	 * This method resets test results counters after each test case execution result logged in the report
	 */
	public static void resetTCResultCounter() {
		successCounter = 0; 
		failureCounter = 0;
	}
	
	/**
	 * This method sets test case failure counter to zero
	 * @return
	 */
	public static boolean getTestCaseFinalStatus() {
  		return failureCounter == 0;
  	}
	
	/**
	 * This method is used to start the Appium Server
	 */
	public static void startAppiumServer() {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	
	/**
	 * This method is used to stop the Appium Server
	 */
	public static void stopAppiumServer() {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.stop();
	}

	/**
	 * This method is used to get the total test cases executed PASS count
	 * @return
	 */
	public static double getPassPercent() {
		double passPercent = (passCounter/(passCounter + failCounter) * 100);
		return (double) Math.round(passPercent * 100) / 100;
	}
	
	/**
	 * This method is used to get the total test cases executed FAIL count
	 * @return
	 */
	public static double getFailPercent() {
		double passPercent = (failCounter/(passCounter + failCounter) * 100);
		return (double) Math.round(passPercent * 100) / 100;
	}
	
	/**
	 * This method returns the current device MAC address where tests are executed
	 * @return
	 * @
	 */
	public static String getDeviceMACAddress()  {
		String deviceMACAddress = null; 
		
		try {
			if (deviceType.equalsIgnoreCase("Desktop")) {
				deviceMACAddress = "00:00:00:00:00";//DesktopConnectWiFi.getCurrentMACAddress();
				deviceMACAddress = deviceMACAddress.toLowerCase().replace("-", ":");
			} else if (!deviceType.equalsIgnoreCase("Desktop")) {
				deviceMACAddress = mobileMacId;
				deviceMACAddress = deviceMACAddress.toLowerCase().replace("-", ":");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			Log4j.info(e.getMessage());
		}
		
		return deviceMACAddress;
	}
	
	/**
	 * This method determines whether the current device where the tests are executed is a Windows machine or not
	 * @return
	 * @
	 */
	public static boolean isWindows() {
		boolean result = false;
		
		try {
			osName = DeviceDetails.getOSName();
			result = osName.toLowerCase().contains("windows");
			return result;
			
		} catch (Exception e) {
			Log4j.info("Failed to check if device is Windows machine or not " + e.getMessage());
			return result;
		}
	}
	
	/**
	 * This method determines whether the current device where the tests are executed is a Macbook machine or not
	 * @return
	 * @
	 */
	public static boolean isMAC()  {
		boolean result = false;
		
		try {
			osName = DeviceDetails.getOSName();
			result = osName.toLowerCase().contains("mac");
			return result;
			
		} catch (Exception e) {
			Log4j.info("Failed to check if device is MacBook machine or not " + e.getMessage());
			return result;
		}
	}
	
	/**
	 * This method is used to wait for a given amount of time in seconds
	 * @param waitTimeInSeconds
	 * @throws InterruptedException
	 */
	public static void waitFor(int waitTimeInSeconds) {
		try {
			Thread.sleep(waitTimeInSeconds * 1000);
			
		} catch (InterruptedException e) {
			Log4j.info("Failed to wait for '" + waitTimeInSeconds + "' seconds");
			Log4j.info(e.getMessage());
		}
	}
	
	/**
	 * This method is used to wait for a given amount of time in minutes
	 * @param waitTimeInSeconds
	 * @throws InterruptedException
	 */
	public static void waitForWithWaitTimeInMin(int waitTimeInMinutes) {
		try  {
			for (int waitCounter = 0; waitCounter < waitTimeInMinutes; waitCounter++) {
				Log4j.info("Waiting for: " + (waitCounter + 1) + " minute(s).");
				waitFor(60);
			}
			Log4j.info("End of waiting for '" + waitTimeInMinutes + "' minutes");
		} catch (Exception e) {
			Log4j.info("Failed to wait for '" + waitTimeInMinutes + "' minutes");
			Log4j.info(e.getMessage());
		}
	}
	
	/**
	 * This method is used to get group name thats currenlty being executed from Jenkins
	 * @return
	 * @
	 */
	public static String getCurrentlyExecutedGroupName() {
		try {
			if (System.getProperty("groupName") != null) {
				return System.getProperty("groupName");
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			
		}
		return null;
	}
	
	/**
	 * This method is used to get the APK file name
	 * @return
	 */
	public static String getAPKFileName() {
		try {
			if (System.getProperty("apkFileName") != null) {
				return System.getProperty("apkFileName");
			
			} else {
				return PropertiesHelper.getConfigPropertiesKeyValue("apkFileName");
			}
		} catch (Exception e) {
			  Log4j.info(e.getMessage());
			  Log4j.info("Something went wrong when updating afterMethodActivitiesForOIOO");
			  return "";
		} 
	}
	
	/**
	 * This method returns the currently used Android device O.S. version
	 * @return
	 */
	public static int getCurrentAndroidDeviceOSVersion() {
		int androidCurrentOSVersion = 0;
		
		try {
			if (deviceType.equalsIgnoreCase("Android")) {
				androidCurrentOSVersion = Integer.parseInt(AndroidADBUtilsHelper.getAndroidDeviceOSVersion());
				Log4j.info(deviceName + " current O.S. version is: " + androidCurrentOSVersion);
			}
						
			return androidCurrentOSVersion;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the Android O.S. version - " + e.getMessage());
			return androidCurrentOSVersion;
		}
	}
	
	/**
	 * This method is used to perform all after suite operations after executing test case suite (i.e test methods)
	 * @param method
	 */
	//@AfterSuite (alwaysRun = true)
	public void endReport()  {
		try {
			Log4j.info("Beginning of @AfterSuite");
			
	    //    extent.flush();
	    //    extent.close();
	        
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Something went wrong in end report activities!!");
		}
    }
	
	/**
	 * This method is used to check if the Android driver is Native or not
	 * @return
	 * @
	 */
	public static String isAndroidDriverNative()  {
		try {
			return ConfigMgr.getProperty("isNative");
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to check if Android driver is native or not!!");
			return "";
		}
	}
	
	public static String getUnusedEntryCodeFromExcel() {
		String cellValue = "";
		
		try {
			int totalRowCount;
			String colValue = "";
			totalRowCount = ExcelUtils.getTotalRowCount("Credentials", excelFilePath);
			System.out.println(totalRowCount);
			
			Row row;
			
			for (int rowIndex = 1; rowIndex <= totalRowCount; rowIndex++ ) {
				row = ExcelUtils.getSpecificRowData("Credentials", excelFilePath, rowIndex, 3);
				colValue = ExcelUtils.getCellValue(row, 3);
				
				if (colValue.equalsIgnoreCase("")) {
					int rowNum = rowIndex;
					row = ExcelUtils.getSpecificRowData("Credentials", excelFilePath, (rowNum), 2);
					cellValue = ExcelUtils.getCellValue(row, 2);
					break;
				}
			}
			
			System.out.println(cellValue);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		
		return cellValue;
	}
	
	
	public static void scrolltoview(By Locator, RemoteWebDriver driver) {
		/*WebElement element1 = driver.findElement(Locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);*/
		
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}
	}
	
	public static void setEntryCodeUsedStatus() {
		try {
			int totalRowCount;
			String colValue = "";
			totalRowCount = ExcelUtils.getTotalRowCount("Credentials", excelFilePath);
			String entryCode = getUnusedEntryCodeFromExcel();
			
			Row row;
			int rowNum = 0;
			
			for (int rowIndex = 1; rowIndex <= totalRowCount; rowIndex++ ) {
				row = ExcelUtils.getSpecificRowData("Credentials", excelFilePath, rowIndex, 3);
				colValue = ExcelUtils.getCellValue(row, 3);
				String cellValue = ExcelUtils.getCellValue(row, 2);

				if ((colValue.equalsIgnoreCase("")) && (entryCode.equalsIgnoreCase(cellValue))) {
					rowNum = rowIndex;
					ExcelUtils.setCellData(excelFilePath, "Used", rowNum, 3, "Credentials");
					break;
				}
			}

		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
	}
}
