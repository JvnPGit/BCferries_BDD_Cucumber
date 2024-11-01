package com.cucumberbdd.automationFramework.utilsHelper;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.base.Base;

public class DriverFactory extends Base {

	public static RemoteWebDriver getDriver(String browser) {
		RemoteWebDriver driver = null;
		
		try {
			System.out.println("Browser is: " + browser);
			if (browser.equalsIgnoreCase("Chrome")) {
				System.out.println("Driver path is: " + driverPath);
				System.setProperty("webdriver.chrome.driver", driverPath);
				System.setProperty("webdriver.chrome.silentOutput", "true");
				ChromeOptions options = new ChromeOptions();
			//	options.addArguments("--headless",  "--window-size=1920,1200","--ignore-certificate-errors");
				//options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--disable-application-cache");
				options.addArguments("--disable-notifications");
				//options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobar");
				options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
				options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
				options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
				options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
				options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
				options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
				options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				//options.addArguments("--headless");
				
			//	String downloadFilepath = System.getProperty("user.dir")+ "\\FileDownloadFolder";
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
			//	chromePrefs.put("download.default_directory", filePath);
				chromePrefs.put("plugins.always_open_pdf_externally", true);
				options.setExperimentalOption("prefs", chromePrefs);
				driver = new ChromeDriver(options);
				
			} else if (browser.equalsIgnoreCase("ie")) {
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability("ie.enableFullPageScreenshot", false);
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
				caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
				caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				caps.setCapability("ignoreProtectedModeSettings", true);
				caps.setJavascriptEnabled(true);
				driver = new InternetExplorerDriver(caps);

			} else if (browser.equalsIgnoreCase("firefox")) {
				System.out.println("getting in");
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
				System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
				FirefoxProfile ffprofile = new FirefoxProfile();
				//ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
				ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
				ffprofile.setPreference("browser.helperApps.neverAsk.openFile","text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
				ffprofile.setPreference("browser.download.folderList", 2);
				ffprofile.setPreference("browser.download.manager.showWhenStarting", false);
				//ffprofile.setPreference("browser.download.dir", filePath);
				ffprofile.setPreference("plugin.scan.plid.all",false);
				ffprofile.setPreference("plugin.scan.Acrobat","99.0");
				ffprofile.setPreference("pdfjs.disabled",true);
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference("browser.download.useDownloadDir", true);
				options.setProfile(ffprofile);
				DesiredCapabilities dc = DesiredCapabilities.firefox();
				dc.setCapability("marionette", true);
				dc.setJavascriptEnabled(true);
				dc.merge((Capabilities) options);
				driver = new FirefoxDriver(dc);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
				System.out.println("Entered");
			}
			try {
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		} catch (Exception e) {
			Log4j.info ("Driver instantiation exception");
			System.out.println("Driver instantiation exception");
		}
		
		return driver;
	}
	
	public static void close(RemoteWebDriver driver ){
		driver.close();
	}
	public static void quit(RemoteWebDriver driver ){
		driver.quit();
	}

}
