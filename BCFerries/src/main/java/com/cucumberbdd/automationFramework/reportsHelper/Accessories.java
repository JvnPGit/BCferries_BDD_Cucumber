package com.cucumberbdd.automationFramework.reportsHelper;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Accessories {

	/**
	 * This method returns the Date
	 * @return
	 */
	public static String dateStamp() {
		DateFormat dateFormat = new SimpleDateFormat();
		Date date = new Date();
		return dateFormat.format(date).substring(0,7);
	}
	
	/**
	 * This method returns the timestamp
	 * @return
	 */
	public static String timeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime()).toString();
	}
	
	/**
	 * This method returns environmental details:
	 * OS Name
	 * OS Version
	 * OS Architecture 
	 * @return
	 */
	public static String osEnvironment() {
		return "Current suit exicuted on : "+System.getProperty("os.name")
				+"/version : "+System.getProperty("os.version")
				+"/Architecture : "+System.getProperty("os.arch");
	}
	
	/**
	 * This method returns the host name of the Windows laptop
	 * @return
	 * @throws UnknownHostException
	 */
	public static String getHostName() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();
		return hostname;
	}
	
	/*public static void calculateTestCaseStartTime() {			
		HtmlReporters.iTestStartTime = System.currentTimeMillis();
	}
	
	*//***
	 * 		This method is supposed to be used in the @AfterMethod to calculate the total test case execution time 
	 * to show in Reports by taking the start time from the calculateTestCaseStartTime method.
	 *//*
	public static void calculateTestCaseExecutionTime(){
		HtmlReporters.iTestEndTime = System.currentTimeMillis();
		HtmlReporters.iTestExecutionTime=(HtmlReporters.iTestEndTime-HtmlReporters.iTestStartTime)/1000;
		HtmlReporters.list.add((HtmlReporters.iTestExecutionTime)/1000.0);
	}

	*//***
	 * 		This method is supposed to be used in the @BeforeSuite in-order trigger the Suite Start Time
	 * which inturn used to calculate the Total Suite execution time to show in Reports.
	 *//*
	public static void calculateSuiteStartTime() {
		HtmlReporters.iSuiteStartTime = System.currentTimeMillis();
	}

	*//***
	 * 		This method is supposed to be used in the @AfterMethod to calculate the total suite execution time
	 * to show in Reports by taking the suite start time from the calculateSuiteStartTime method.
	 *//*
	public static void calculateSuiteExecutionTime() {
		HtmlReporters.iSuiteEndTime = System.currentTimeMillis();
		HtmlReporters.iSuiteExecutionTime = (HtmlReporters.iSuiteEndTime-HtmlReporters.iSuiteStartTime)/1000.000;
	}
	
	public static void calculateStepStartTime() {
		HtmlReporters.iStepStartTime = System.currentTimeMillis();
	}
	
	public static void calculateStepExecutionTime() {
		HtmlReporters.iStepEndTime = System.currentTimeMillis(); 
		HtmlReporters.iStepExecutionTime = (HtmlReporters.iStepEndTime-HtmlReporters.iStepStartTime)/1000;
		if (HtmlReporters.iStepExecutionTime==0) {
			HtmlReporters.iStepExecutionTime = 1;
		}
	}*/
}
