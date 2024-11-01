package com.cucumberbdd.automationFramework.Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cucumberbdd.automationFramework.base.Base;
import com.cucumberbdd.automationFramework.utilsHelper.FileUtilityHelper;

import cucumber.api.Scenario;

@SuppressWarnings("deprecation")
public class ExtentReportListener {
	public static ExtentReports extent = setUp();
	public static ExtentHtmlReporter report;
	public static ExtentTest scenario;
	public static String currentFeatureName = "";
	public static ExtentTest feature; // = createFeature()
	
	public static ExtentReports setUp() {
		String reportLocation = System.getProperty("user.dir") + "/Reports/Extent_Report_" + Base.timeStamp + ".html";
		System.out.println("extent reports folder location: " + reportLocation);
		System.err.println("extent reports folder location: " + reportLocation);
		report = new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Report location initialized . . .");
		report.start();

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "BCFerries");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		System.out.println("System Info. set in Extent Report");
		return extent;
	}

	public static String getFeatureName() {
		String featureName = "";

		try {
			String rawFeatureName = currentFeatureName;
			System.out.println("current feature name is: " + currentFeatureName);
			rawFeatureName = rawFeatureName.split(";")[0].replace("-", " ");
			int bindex = rawFeatureName.indexOf("/", rawFeatureName.indexOf("/") + 1);
			featureName = rawFeatureName.substring(bindex + 1, rawFeatureName.split(".feature")[0].length());

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
		}

		return featureName;
	}

	public static void testStepHandle(String teststatus, RemoteWebDriver driver, ExtentTest extenttest,
			Throwable throwable) {
		switch (teststatus) {
		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));
			extenttest.error(throwable.fillInStackTrace());

			try {
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (driver != null) {
				driver.quit();
			}
			break;

		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
			break;

		default:
			break;
		}
	}

	public static String captureScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = FileUtilityHelper.getTestcaseImagesPath() + File.separator + "pic" + "_"
				+ FileUtilityHelper.getImageTimeStamp() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

}