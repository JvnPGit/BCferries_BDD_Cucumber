package com.cucumberbdd.automationFramework.driverUtils;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumberbdd.automationFramework.base.Base;
import com.cucumberbdd.automationFramework.utilsHelper.CommandLineUtilsHelper;
import com.cucumberbdd.automationFramework.utilsHelper.StringUtilsHelper;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumiOSBase extends Base {
	
	public static DesiredCapabilities dc = new DesiredCapabilities();
	public static String wifiIPOnIOSDevice = null;
	
	/**
	 * This method is used to instantiate an Appium iOS driver
	 * @return
	 
	 */
	@SuppressWarnings("rawtypes")
	public static RemoteWebDriver createAppiumDriver(RemoteWebDriver driver) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, iOSPlatformVersion);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability(MobileCapabilityType.UDID, "auto");
		capabilities.setCapability("startIWDP", true);
		capabilities.setCapability("webkitResponseTimeout", 120);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");

		try {
			PhysicalDeviceDetails.getUdid(PhysicalDeviceDetails.deviceName);//to get the udid for reporting
			URL url = new URL(serviceUrl);
			driver = new IOSDriver(url, capabilities);
			driver.manage().deleteAllCookies();
			driverSessionId = driver.getSessionId().toString();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			currentBrowserVersion = driver.getCapabilities().getVersion();
	        currentBrowserName = driver.getCapabilities().getBrowserName();
			new WebDriverWait(driver, 10);
		} catch (Exception e) {
			Log4j.info("Error performing Appium test: " + e.getMessage());
			takeScreenshots();
		}
		return driver;
	}
	
	/**
	 * This method is used to instantiate an iOS Settings driver to navigate till the Settings page on an iOS device
	 * @return
	 
	 */
	@SuppressWarnings("rawtypes")
	public static RemoteWebDriver createIOSSettingsDriver(RemoteWebDriver driver)  {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, iOSPlatformVersion);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability(MobileCapabilityType.UDID, "auto");
		capabilities.setCapability("bundleId", "com.apple.Preferences");
		capabilities.setCapability("startIWDP", true);
		capabilities.setCapability("webkitResponseTimeout", 120);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");

		try {
			PhysicalDeviceDetails.getUdid(PhysicalDeviceDetails.deviceName);//to get the udid for reporting
			URL url = new URL(serviceUrl);
			driver = new IOSDriver(url, capabilities);
			touchAction = new TouchAction((IOSDriver) driver);
			driverSessionId = driver.getSessionId().toString();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			new WebDriverWait(driver, 10);
		} catch (Exception e) {
			Log4j.info("Error performing Appium test: " + e.getMessage());
			takeScreenshots();
		}
		return driver;
	}
	
	/**
	 * This method is used to get the iOS device current software version
	 * @param deviceName
	 * @return
	 */
	public static String getIOSPlatformVersionFromTerminal(String deviceName) {
		String softwareVersion = null;
		
		try {
			String output = CommandLineUtilsHelper.executeCmdAndGetResult("instruments -s devices | grep " + deviceName);
			softwareVersion = output.substring(StringUtilsHelper.getFirstOccurenceOfACharacter(output, "(") + 1, StringUtilsHelper.getFirstOccurenceOfACharacter(output, ")"));
			return softwareVersion.trim();
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the iOS device current software version!!");
			return softwareVersion;
		}
	}
	
}