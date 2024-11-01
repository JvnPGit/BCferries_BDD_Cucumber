package com.cucumberbdd.automationFramework.utilsHelper;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumberbdd.automationFramework.base.Base;

public class BrowserHelper extends Base {
	public static String currentClassName = MethodHandles.lookup().lookupClass().getSimpleName();
	
	/**
	 * This method is used to instantiate a web browser
	 * For ex. Chrome/Firefox/Internet Explorer/Safari
	 * @return
	 */
	public static String getBrowser() {
		String browser = null;
		try {
			browser = browserName;
			logHelper.info("Browser selected: " + browser);
			
			switch (browser) {
			case "Chrome":
				logHelper.info("Chrome browser is instantiated!");
				break;
			case "IE":
				break;
			case "Firefox":
				logHelper.info("Firefox browser is instantiated!");
				break;
			default:
				logHelper.info("Firefox browser is instantiated by default!");
				break;
			}
			 
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to set the Browser");
		}
		return browser;
	}
	
	/**
	 * This method returns a random URL to browse after launching a web browser
	 * @return
	 * @
	 */
	public static String getRandomURL()  {
		String url = null;
		try {
			url = StringUtilsHelper.getRandomPublicURL();
			Log4j.info("Public URL launched is: '" + url + "'");
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get a random URL string");
		}

		return url;
	}

	/**
	 * This method returns the current URL from the web browser as String
	 * @return
	 * @
	 */
	 public static String getCurrentURL(RemoteWebDriver driver) {
		String currentURL = null;
		try {
			currentURL = driver.getCurrentUrl();
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the current URL from browser");
		}
		return currentURL;
	} 

	/**
	 * This method is used to wait until the web page loads
	 * @param time
	 */
	 public static void waitForPageLoad(int time, RemoteWebDriver driver) {
		try {
			new WebDriverWait(driver, time); //provide time in seconds
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
	} 

	/**
	 * This method is used to wait until a WebElement is displayed on a web page
	 * @param element
	 * @param time
	 */
	public static void waitUntilElementIsVisible(WebElement element, RemoteWebDriver driver) {
	//	element = (new WebDriverWait(driver, time)).until(ExpectedConditions.visibilityOf(element));
	//	waitForCondition().until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait until a WebElement is displayed on a web page
	 * @param element
	 * @param time
	 */
	public static void waitUntilAllElementsAreVisible(List<WebElement> elementList) {
	//	waitForCondition().until(ExpectedConditions.visibilityOfAllElements(elementList));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	/* public static Wait<WebDriver> waitForCondition() {
		return (new FluentWait(driver))
				.withTimeout(40000L, TimeUnit.MILLISECONDS)
				.pollingEvery(250L, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class, NoSuchFrameException.class);
	} */

	/**
	 * This method is used to open a new tab on a web browser
	 * @
	 */
	public static void openNewTab()  {
		try {
			int vkControl = KeyEvent.VK_CONTROL;
			Robot robot = new Robot();
			robot.keyPress(vkControl);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(vkControl);
			robot.keyRelease(KeyEvent.VK_T);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to open a new tab using Robot");
		}
	}
	
	/**
	 * This method is used to shift focus to a frame on a web page
	 * @param value
	 */
	public static void switchToFrame(String value, RemoteWebDriver driver) {
		driver.switchTo().frame(value);
	}
	
	/**
	 * This method is used to shift focus back to default content on a Web page
	 */
	public static void switchToDefaultContent(RemoteWebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to open a new web browser
	 * @
	 */
	public static void openBrowser(RemoteWebDriver driver) {
		try {
			driver.get(getRandomURL());
		} catch (Exception e) {
			Log4j.info("Failed to open a browser - " + e.getMessage());
		}
	}

	
	/**
	 * This method is used to switch focus back to the base window
	 * @
	 */
	public static void switchFocusToBaseWindow(RemoteWebDriver driver)  {
		try {
			String base;
			Set<String> winHandles;
			base = driver.getWindowHandle();
			winHandles = driver.getWindowHandles();
			
			for (String window : winHandles) {
				if (!window.equalsIgnoreCase(base)) {
					driver.switchTo().window(window);
				}
			}			
		} catch(Exception e) {
			Log4j.info(e.getMessage());
		}
	}
	
	/**
	 * This method is used to switch focus to parent window 
	 * @
	 */
	public static void switchFocusToParentWindow(String parent, RemoteWebDriver driver)  {
		try {
			parent = driver.getWindowHandle();
			Log4j.info("Switching focus to parent window");
			driver.switchTo().window(parent);
		} catch(Exception e) {
			Log4j.info(e.getMessage());
		}
	} 
	
	/**
	 * This method is used to check if an alert window is displayed on a web browser or not
	 * @return
	 */
	public static boolean isBrowserWindowAlertPresent(RemoteWebDriver driver) { 
	    try { 
	        driver.switchTo().alert(); 
	        return true; 
	    }
	    catch (Exception e) {
	    	Log4j.info("There is no alert popup window displayed on the browser");
	        return false; 
	    }
	}
	
	/**
	 * This method is used to enter text in an alert window on a web browser or not
	 * @return
	 */
	public static void enterTextInBrowserWindowAlert(String text, RemoteWebDriver driver) { 
	    try { 
	    	driver.switchTo().alert().sendKeys(text); 
	    }
	    catch (Exception e) {
	    	Log4j.info("Failed to enter text in alert popup window on the browser");
	    }
	}
}
