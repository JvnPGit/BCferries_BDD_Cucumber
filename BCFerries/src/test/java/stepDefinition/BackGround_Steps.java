package stepDefinition;

import java.util.HashMap;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.cucumberbdd.BCFerries_Web.FareSelectionPage_Web;
import com.cucumberbdd.BCFerries_Web.FareSelectionReviewPage_Web;
import com.cucumberbdd.BCFerries_Web.HomePage_Web;
import com.cucumberbdd.BCFerries_Web.PassengerSelectionPage_Web;
import com.cucumberbdd.BCFerries_Web.VehicleSelectionPage_Web;
import com.cucumberbdd.automationFramework.Listeners.ExtentReportListener;
import com.cucumberbdd.automationFramework.base.Base;
import com.cucumberbdd.automationFramework.utilsHelper.ActionEngine;
import com.cucumberbdd.automationFramework.utilsHelper.Browser;


import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BackGround_Steps extends ExtentReportListener {

	String featureName;
	String scenarioName;
	public static RemoteWebDriver driver;
	public ExtentTest logInfo = null;

	public HomePage_Web homePage;
	public FareSelectionPage_Web farePage;
	public FareSelectionReviewPage_Web fareReviewPage;
	public PassengerSelectionPage_Web passengersPage;
	public VehicleSelectionPage_Web vehiclePage;
	


	@Before
	public static String getScenarioName(Scenario scenario_name) {
		String scenarioName = "";

		try {
			System.err.println("Print Scenario name in Before Hook: BackGround_Steps " + scenario_name.getName());
			scenarioName = scenario_name.getName();
			currentFeatureName = scenario_name.getId().split(";")[0].replace("-", " ");
			createFeature(scenarioName);	
			scenario = feature.createNode(new GherkinKeyword("Scenario"), scenarioName);
			
		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
		}

		return scenarioName;
	}
	
	public static void createNewFeature() {
		try {
			feature = extent.createTest(new GherkinKeyword("Feature"), getFeatureName());
			
		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
		}
	}
	
	public static void createFeature(String scenarioName) {
		try {
			if (feature != null) {
				String currentFeatureName = (feature.getModel().getName().toString());
				
				HashMap<String, String> map = ActionEngine.getScenarioFeatureMapping();
				String expFeature = map.get(scenarioName);
						
				if (!(currentFeatureName.equalsIgnoreCase(expFeature))) {
					feature = null;
					createNewFeature();
				}
				
			} else {
				System.out.println("Creating a new feature as it is NULL initiatlly");
				createNewFeature();
			}
		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
		}
	}
	
	private void instaiateClasses() {
		homePage = new HomePage_Web(driver);
		
		
	}
	
	
	@Given("User launched browser")
	public void launchBrowser() {
		try { 
			driver = Base.instantiateDriver();
			
			instaiateClasses();
			Base.Log4j.info("Launched chrome browser");
			logInfo = ActionEngine.getExtentObj(scenario, "Given", "User launched browser");
			ActionEngine.reportStep(driver, logInfo, "Launched the chrome browser and entered url", "Failed to launch the Chrome browser and entered URL");

		} catch (Exception e) { 
			Base.Log4j.info("Exception launching browser");
		}
	}

	@When("User enters required URL")
	public void enterURL() {
		ExtentTest logInfo = null;

		try {
			Browser.launchURL(driver);
			logInfo = ActionEngine.getExtentObj(scenario, "When", "User enters required URL");
			ActionEngine.reportStep(driver, logInfo, "User enters required URL", "Failed to enter required URL");
			Thread.sleep(10000);
		} catch (Exception e) {
			Base.Log4j.info("Exception launching URL");
		}
	}
	
	
	/*@Given("User launched required URL")
	public void launchApp() {
		try { 
			System.out.println("Instatite Driver 1");
			driver = Base.instantiateDriver();
			if (driver != null) {
				System.out.println("Driver Instance Created URL Launch");
			}
			System.out.println("Instatite Driver 2");
			instaiateClasses();
			Base.Log4j.info("User launched required URL");
			logInfo = ActionEngine.getExtentObj(scenario, "Given", "User launched required URL");
			ActionEngine.reportStep(driver, logInfo, "User launched required URL", "Failed to launch required URL");
			Thread.sleep(2000);
		} catch (Exception e) { 
			Base.Log4j.info("Exception: User launched required URL");
		}
	}
	

	@Then("Verify if the User is on HomePage")
	public void isAppLoginSuccessful() {
		homePage.isHomePageDisplayed();
		logInfo = ActionEngine.getExtentObj(scenario, "Then", "Verify if the User is on HomePage");
		ActionEngine.reportStep(driver, logInfo, "User is on Home Page","Failed to navigate to Home Page");
	
	}*/
}
