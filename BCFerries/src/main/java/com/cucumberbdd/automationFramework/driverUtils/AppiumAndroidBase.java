package com.cucumberbdd.automationFramework.driverUtils;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumberbdd.automationFramework.base.Base;
import com.cucumberbdd.automationFramework.utilsHelper.BrowserHelper;
import com.cucumberbdd.automationFramework.utilsHelper.ConfigMgr;
import com.cucumberbdd.automationFramework.utilsHelper.ScreenshotUtilsHelper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumAndroidBase extends Base {
	
	
	public static final String AUTOMATE_USERNAME = ConfigMgr.getProperty("username");
	public static final String AUTOMATE_ACCESS_KEY = ConfigMgr.getProperty("accesskey");
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	/**
	 * This method is used to instantiate an Remote Weddriver and launch a browser on the Browserstack device pool.
	 * @return
	 
	 */
	@SuppressWarnings("rawtypes")
	public static RemoteWebDriver createBrowserstackDriver(String browserName) {
		RemoteWebDriver driver = null;
		Log4j.info("Remote WebDriver capability instantiation");
		
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browserName", "Android");
	    caps.setCapability("device", "Samsung Galaxy S20 Plus");
	    caps.setCapability("realMobile", "true");
	    caps.setCapability("os_version", "10.0");
	    //caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
	    //caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
	   
	    try {
	    	
	    	//URL url = new URL(serviceUrl);
	    	driver = new RemoteWebDriver(new URL(URL), caps);
	    	driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driverSessionId = driver.getSessionId().toString();
			currentBrowserVersion = driver.getCapabilities().getVersion();
	        currentBrowserName = driver.getCapabilities().getBrowserName();
			new WebDriverWait(driver, 10);
			Log4j.info("Remote WebDriver is instantiated");
	    	
	    } catch (Exception e) {
			Log4j.info("Error performing Appium test: " + e.getMessage());
			takeScreenshots();
		} 
		return driver;
	}
	
	
	/**
	 * This method is used to instantiate an Appium driver and launch a browser on the client device
	 * @return
	 
	 */
	@SuppressWarnings("rawtypes")
	public static RemoteWebDriver createAppiumDriver(String browserName) {
		RemoteWebDriver driver = null;
		Log4j.info("JP Log - Android Driver capability instantiation");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", deviceType);
		capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		//capabilities.setCapability("platformVersion", "8");
		capabilities.setCapability("deviceName", "Pixel_4_XL_API_30");
		//capabilities.setCapability("udid", PhysicalDeviceDetails.getUdid(PhysicalDeviceDetails.deviceName));
		capabilities.setCapability("newCommandTimeout", 360);
		
		try {
		//	if (AppiumServerUtils.isAppiumServerStarted()) {
				URL url = new URL(serviceUrl);
				driver = new AndroidDriver(url, capabilities);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driverSessionId = driver.getSessionId().toString();
				currentBrowserVersion = driver.getCapabilities().getVersion();
		        currentBrowserName = driver.getCapabilities().getBrowserName();
				new WebDriverWait(driver, 10);
				Log4j.info("Android Driver just instantiated");
				//BrowserHelper.openBrowser(driver);
				
//			} else {
//				Log4j.info("Please make sure that Appium server is running on the desktop");
//			} 
			
		} catch (Exception e) {
			Log4j.info("Error performing Appium test: " + e.getMessage());
			takeScreenshots();
		} 
		return driver;
	}
	
	/**
	 * This method creates an android driver for a specific device on a node with specific IP
	 * @param deviceName
	 * @param nodeIP
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static RemoteWebDriver createAndroidAppiumDriverByDeviceName(String deviceName, String browserName) {
		RemoteWebDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("platformVersion", "8");
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("udid", PhysicalDeviceDetails.getUdid(deviceName));
		capabilities.setCapability("newCommandTimeout", 360);
		
		try {
		//	if (AppiumServerUtils.isAppiumServerStarted()) {
				URL url = new URL(serviceUrl);
				driver = new AndroidDriver(url, capabilities);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driverSessionId = driver.getSessionId().toString();
				currentBrowserVersion = driver.getCapabilities().getVersion();
		        currentBrowserName = driver.getCapabilities().getBrowserName();
				new WebDriverWait(driver, 10);
				BrowserHelper.openBrowser(driver);
		
//			} else {
//				Log4j.info("Please make sure that Appium server is running on the desktop");
//			}
		} catch (Exception e) {
			Log4j.info("Error performing Appium test: " + e.getMessage());
			takeScreenshots();
		} 
		return driver;
	}
	
	/**
	 * This method is used to instantiate a Native Android Appium RemoteWebDriver and launch a specific app
	 * @return
	 
	 */
	@SuppressWarnings("rawtypes")
	public static RemoteWebDriver createNativeAndroidAppiumDriver() {
		RemoteWebDriver driver = null;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("app", apkAppPath); //this will install .apk file on Android mobile
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Samsung Galaxy Tab");
		//capabilities.setCapability("udid", PhysicalDeviceDetails.getUdid(PhysicalDeviceDetails.deviceName));
		/*capabilities.setCapability("appPackage", "com.azlottery.playonappuat");
		capabilities.setCapability("appActivity", "com.azlottery.playonappuat.MainActivity");
		capabilities.setCapability("fullReset","false");
		capabilities.setCapability("noReset","true");*/
		capabilities.setCapability(MobileCapabilityType.UDID, "3300b1b12843627d");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.azlottery.playonappuat");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
		//capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"30");
			
		try {
//			if (AppiumServerUtils.isAppiumServerStarted()) {
				URL url = new URL(serviceUrl);
				driver = new RemoteWebDriver(url, capabilities);
				if (driver != null) {
					System.out.println("Driver Instance Created");
				}
				
				//touchAction = new TouchAction((AndroidDriver) driver);
				new WebDriverWait(driver, 10);
			
//			} else {
//				Log4j.info("Please make sure that Appium server is running on the desktop");
//			}
			
		} catch (Exception e) {
			Log4j.info("Error performing Appium test: " + e.getMessage());
			takeScreenshots();
		} 
		return driver;
	}
}