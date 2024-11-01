package com.cucumberbdd.automationFramework.utilsHelper;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.cucumberbdd.automationFramework.Listeners.ExtentReportListener;
import com.cucumberbdd.automationFramework.base.Base;

//import stepDefinition.BackGround_Steps_Android;



public class ActionEngine extends Base {
	
	//RemoteWebDriver driver = BackGround_Steps_Android.driver;

	public static void highlightElement(WebElement element, RemoteWebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
	}
	
	public static void clickElement(RemoteWebDriver driver, By by) {
		try {
			WebElement webElement = driver.findElement(by);
			
			if (webElement.isDisplayed()) {
				System.out.println("Higlighling the web element");
				highlightElement(webElement, driver);
				webElement.click();
				waitFor(2);
				
			} else {
				System.out.println("Element not displayed to click");
			}
			
		} catch (Exception e) {
			System.out.println("Exception when clicking on the element " + e.getMessage());
		}
	}
	
	public static void clearTextBoxContent(RemoteWebDriver driver, By by) {
		try {
			WebElement webElement = driver.findElement(by);
			System.out.println("Clearing the contents of the textbox");
			webElement.click();
			Thread.sleep(1000);
			webElement.clear();
			waitFor(2);
			
		} catch (Exception e) {
			System.out.println("Exception when clearing the contents of the textbox " + e.getMessage());
		}
	}

	public static void setTextBoxContent(RemoteWebDriver driver, By by, String text) {
		try {
			WebElement webElement = driver.findElement(by);
			
			if (webElement.isDisplayed()) {
				System.out.println("Entering text the textbox");
				webElement.click();
				webElement.sendKeys(text);
				waitFor(2);
				
			} else {
				System.out.println("Textbox is not displayed to enter text");
			}
			
		} catch (Exception e) {
			System.out.println("Exception when entering text in the textbox " + e.getMessage());
		}
	}
	
	public static void reportStep(RemoteWebDriver driver, ExtentTest logInfo, String passMsg, String failMsg) {
		try {
			if (logInfo.getStatus().toString().toLowerCase().equals("pass")) {
				logInfo.pass(passMsg);
				logInfo.addScreenCaptureFromPath(ExtentReportListener.captureScreenShot(driver));
				
			} else if (logInfo.getStatus().toString().toLowerCase().equals("fail")) {
				logInfo.pass(failMsg);
				logInfo.addScreenCaptureFromPath(ExtentReportListener.captureScreenShot(driver));
			}
			
		} catch (Exception e) {
			ExtentReportListener.testStepHandle("FAIL", driver,logInfo, e);
		}
	}
	public static void reportFailStep(RemoteWebDriver driver, ExtentTest logInfo, String passMsg, String failMsg) {
		try {
			if (logInfo.getStatus().toString().toLowerCase().equals("pass")) {
				logInfo.pass(passMsg);
				logInfo.addScreenCaptureFromPath(ExtentReportListener.captureScreenShot(driver));
				
			} else if (logInfo.getStatus().toString().toLowerCase().equals("fail")) {
				logInfo.pass(failMsg);
				logInfo.addScreenCaptureFromPath(ExtentReportListener.captureScreenShot(driver));
			}
			
		} catch (Exception e) {
			ExtentReportListener.testStepHandle("FAIL", driver,logInfo, e);
		}
	}
	public static ExtentTest defineScenario(ExtentTest feature, String scenarioName) {
		ExtentTest scenario = null;
		
		try {
			scenario = feature.createNode(new GherkinKeyword("Scenario"), scenarioName);

		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		return scenario;
	}
	
	public static void createFeatureTest(ExtentReports extent) {
		try {
			ExtentReportListener.feature = extent.createTest(new GherkinKeyword("Feature"), "AZLotteryFeature");
			
		} catch (ClassNotFoundException e) {
			Log4j.info(e.getMessage());
		}
	}
	
	public static ExtentTest getExtentObj(ExtentTest scenario,String gKeyword,String loginfoValue) {
		ExtentTest logInfo = null;
		try {
			logInfo= scenario.createNode(new GherkinKeyword(gKeyword), loginfoValue);
		} catch (ClassNotFoundException e) {
			Log4j.info(e.getMessage());
		}	
		
		return logInfo; 
	}
	public static ExtentTest getExtentObj(ExtentTest scenario,String loginfoValue) {
		ExtentTest logInfo = null;
		try {
			logInfo= scenario.createNode( loginfoValue);
		} catch (Exception  e) {
			Log4j.info(e.getMessage());
		}	
		
		return logInfo; 
	}
	
	public static HashMap<String, String> getScenarioFeatureMapping() {
		HashMap<String, String> expMap = new HashMap<String, String>();
		
		try {
			expMap.put("Core Booking Flow (One-Way Guest)", "UAT");
			expMap.put("Core Booking Flow (Return trip / Guest)", "UAT");
			expMap.put("Core Booking Flow (One-Way Log in to check out)", "UAT");
			expMap.put("Verify that the redeem activities performed are reflected in points history", "Feature2_Authenticated");
			expMap.put("Verify that Unauthenticated players are able to view the login page", "Feature1_Unauthenticated");
			expMap.put("Verify that unauthenticated players are able to navigate when clicked on each menu option", "Feature1_Unauthenticated");
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
		}
		
		return expMap;
	}
}
