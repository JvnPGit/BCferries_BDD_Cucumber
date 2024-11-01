package com.cucumberbdd.automationFramework.logUtils;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;

import com.cucumberbdd.automationFramework.base.Base;
import com.cucumberbdd.automationFramework.utilsHelper.ExcelUtils;

public class LoggerHelper extends Base {
	private static Logger Log4j = Logger.getLogger(LoggerHelper.class.getName());
	public static String failedTestCaseName;

	/**
	 * This method is used to add an info message the the results file
	 * @param message
	 */
	public void info(String message) {
		try {
			if (!message.contains("unknown server-side error") || !message.contains("waiting for title to contain")
					|| !message.contains("AndroidDriverCapabilities [{")
					|| !message.contains("java.lang.NullPointerException") || message != null) {
			//	logger.log(LogStatus.INFO, message);
			}
			Log4j.info(message);
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			System.out.println("Null pointer exception: " + e.getMessage());
			Log4j.info("Failed to print the info message in the report - as the message is: " + message);
		}
	}
	
	/**
	 * This method is used to add an info message with red colored log in report.
	 * @param message
	 */
	public void redLog(String message) {
		try {
			logHelper.info("<a style=\"color:red;\">" + message + " </a>");
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			System.out.println("Null pointer exception: " + e.getMessage());
			Log4j.info("Failed to print the info message in the report - as the message is: " + message);
		}
	}
	
	/**
	 * This method is used to add an info message with red colored log in report with a prefix string in black.
	 * @param message
	 */
	public void redLog(String message, String prefixString) {
		try {
			logHelper.info(prefixString + "<a style=\"color:red;\">" + message + " </a>");
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			System.out.println("Null pointer exception: " + e.getMessage());
			Log4j.info("Failed to print the info message in the report - as the message is: " + message);
		}
	}
	
	/**
	 * This method is used to add an info message with green colored log in report.
	 * @param message
	 */
	public void greenLog(String message) {
		try {
			logHelper.info("<a style=\"color:green;\">" + message + " </a>");
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			System.out.println("Null pointer exception: " + e.getMessage());
			Log4j.info("Failed to print the info message in the report - as the message is: " + message);
		}
	}
	
	/**
	 * This method is used to add an info message with green colored log in report with a prefix string in black.
	 * @param message
	 */
	public void greenLog(String message, String prefixString) {
		try {
			logHelper.info(prefixString + "<a style=\"color:green;\">" + message + " </a>");
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			System.out.println("Null pointer exception: " + e.getMessage());
			Log4j.info("Failed to print the info message in the report - as the message is: " + message);
		}
	}
	
	/**
	 * This method is used to add an info message with green colored log in report.
	 * @param message
	 */
	public void orangeLog(String message) {
		try {
			logHelper.info("<a style=\"color:orange;\">" + message + " </a>");
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			System.out.println("Null pointer exception: " + e.getMessage());
			Log4j.info("Failed to print the info message in the report - as the message is: " + message);
		}
	}
	
	/**
	 * This method is used to add an info message with green colored log in report with a prefix string in black.
	 * @param message
	 */
	public void orangeLog(String message, String prefixString) {
		try {
			logHelper.info(prefixString + "<a style=\"color:orange;\">" + message + " </a>");
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			System.out.println("Null pointer exception: " + e.getMessage());
			Log4j.info("Failed to print the info message in the report - as the message is: " + message);
		}
	}

	/**
	 * This method is used to capture screenshot and add it in the Extent Report
	 */
	public void addScreenShotInReport(String imageFilePath) {
		try {
	//		logger.log(LogStatus.INFO, logger.addScreenCapture(ScreenshotUtilsHelper.captureMobileScreenshotAndGetFileName(driver, imageFilePath)));
			
		} catch (Exception e) {
			Log4j.info("Failed to capture screenshot and add it in the Extent Report");
			Log4j.info(e.getMessage());
		}
	}
	
	public static void main (String[] args) {
		initiateLog4jConfigurator();
		instantiateDriver();
		
	}
	
	
}
