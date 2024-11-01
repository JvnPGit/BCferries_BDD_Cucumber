package com.cucumberbdd.automationFramework.utilsHelper;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.base.Base;
import com.cucumberbdd.automationFramework.driverUtils.AppiumAndroidBase;

public class Browser extends Base {

	/**
	 * This method is used to initiate a driver based on the device type
	 * @param driverType
	 
	 */
	public static RemoteWebDriver getDriver(String driverType, String browserName) {
		RemoteWebDriver driver = null;
		try {
			browserName = getBrowserName();
			
			if (driverType.equalsIgnoreCase("iOS")) {
			//	AppiumiOSBase.createIOSAppiumStudioDriver();
				
			} else if (driverType.equalsIgnoreCase("Browserstack")) {
				driver = AppiumAndroidBase.createBrowserstackDriver(browserName);

			} else if (driverType.equalsIgnoreCase("Android")&& isAndroidDriverNative().equalsIgnoreCase("no")) {
				driver = AppiumAndroidBase.createAppiumDriver(browserName);

			} else if (driverType.equalsIgnoreCase("Desktop")) {
				driver = DriverFactory.getDriver(browserName);
			
			} else if (driverType.equalsIgnoreCase("Android") && isAndroidDriverNative().equalsIgnoreCase("yes")) {
				driver = AppiumAndroidBase.createNativeAndroidAppiumDriver();
			} 
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to instantiate a driver");
		}
		
		return driver;
	}
	
	/**
	 * This method is used to open a web browser and launch a random public URL
	 * @param appURL
	 * @return
	 
	 */
	/* public static RemoteWebDriver openBrowser(String appURL) {
		try {
	     //   driver = getBrowser(DeviceDetails.getOSName());
	      //  driver.manage().deleteAllCookies();
	     //   launchURL(appURL);
	        logHelper.info("'" + browserName + "' browser launched successfully!! ");
	        
	        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
			driverSessionId = driver.getSessionId().toString();
			
			//Capture browser version and name
			currentBrowserVersion = driver.getCapabilities().getVersion();
	        currentBrowserName = driver.getCapabilities().getBrowserName();
	        
	        return driver;
	        
		} catch (Exception e) {
			Log4j.info("Exception in lanunching browser " + e.getMessage());
			Log4j.info("Closing the existing browser, as it went to exception");
			System.out.println("Came into open browser exception");
			driver.close();
			return driver;
		}
	} */
	
	/**
	 * This method is used to open a web browser only
	 * @param appURL
	 * @return
	 
	 */
	/* public static RemoteWebDriver getBrowser(String currentOS) {
		//DesiredCapabilities capabilities;
		int implicitWaitTime = 30;

		try {
			if (browserName.equalsIgnoreCase("Firefox")) {
//				if (currentOS.contains("Windows")) {
//					System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + File.separator
//							+ "lib" + File.separator + "drivers" + File.separator + "geckodriver.exe");
//				} else if (currentOS.contains("Mac")) {
//					System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + File.separator
//							+ "lib" + File.separator + "drivers" + File.separator + "geckodriver");
//				}
//				capabilities = DesiredCapabilities.firefox();
//				capabilities.setCapability("marionette", true);
//				webDriver = new FirefoxDriver(capabilities);
//				webDriver.manage().window().maximize();

			} else if (browserName.equalsIgnoreCase("ie")) {
				File file = new File("Drivers" + File.separator + "IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				webDriver = new InternetExplorerDriver();
				webDriver.manage().window().maximize();
				webDriver.manage().timeouts().implicitlyWait(implicitWaitTime * 2, TimeUnit.SECONDS);
			
			} else if (browserName.equalsIgnoreCase("Chrome")) {
				String driverFilePath = null;
				
				if (currentOS.contains("Windows")) {
					driverFilePath = frameworkDriversPath + "chromedriver.exe";
					System.setProperty("webdriver.chrome.driver", driverFilePath);
				
				} else if (currentOS.contains("Mac")) {
					driverFilePath = frameworkDriversPath + "chromedriver";
					System.setProperty("webdriver.chrome.driver", driverFilePath);
				}
				
				Log4j.info("chromedriver path is: " + driverFilePath);
				FileUtilityHelper.setReadAndWriteAccessAndMakeItAnExecutableToAnyFileOnMac(driverFilePath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--test-type");
				options.addArguments("--start-maximized");
				options.addArguments("--disable-extensions");
				options.addArguments("disable-infobars");
				webDriver = new ChromeDriver(options);
			}
			webDriver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
			return (RemoteWebDriver) webDriver;
			
		} catch (Exception e) {
			Log4j.info("Catch exception instantiating a browser " + e.getMessage());
			return driver;
		}
	} */
	
	/**
	 * This method is used to launch a specific  URL
	 * @param appURL
	 * @return
	 
	 */
	 public static String launchURL(RemoteWebDriver driver) {
		try {
			/*
			 * Log4j.info("Current timestamp before launching the application: " +
			 * CalendarHelper.getDateFormat()); driver.get(appURL);
			 * Log4j.info("Current timestamp after launching the application: " +
			 * CalendarHelper.getDateFormat());
			 * 
			 * Log4j.info("The current window title is: " + driver.getTitle().toString());
			 * Log4j.info("The current URL is: " + driver.getCurrentUrl());
			 */
			
			Log4j.info("Waiting for 1 seconds to launch the URL");
			waitFor(1);
			Log4j.info("Enter the URL '" + ConfigMgr.getProperty("URL") + "'");
			
			driver.get(ConfigMgr.getProperty("URL"));
			waitFor(2);
			
		} catch (Exception e) {
			Log4j.info("Catch exception instantiating a browser " + e.getMessage());
		}
		
		return driver.getCurrentUrl();
	} 
	
	/**
	 * This method is used to check if a RemoteWebDriver already exists or not
	 * @param driver
	 * @return
	 */
	public static boolean isDriverExist(RemoteWebDriver driver) {
        try {
            driver.getTitle();
            return true;
        } catch (Exception e) {
        	Log4j.info("RemoteWebDriver is not yet instantiated!");
            return false;
        }
	}
	
	/**
	 * This method is used to get the chromedriver path from framework
	 * @return
	 */
	public static String getChromeDriverPath() {
		String chromedriverPath = "";
		
		try {
			if (isWindows()) {
				chromedriverPath = frameworkDriversPath + "chromedriver.exe";
			
			} else if (isMAC()) {
				chromedriverPath = frameworkDriversPath + "chromedriver";
			}
			
			Log4j.info("The chromedriver path from framework is: " + chromedriverPath);
			return chromedriverPath;
			
		} catch (Exception e) {
			Log4j.info("Failed to get the chromedriver path from framework");
			Log4j.info(e.getMessage());
			return chromedriverPath;
		}
	}
}
