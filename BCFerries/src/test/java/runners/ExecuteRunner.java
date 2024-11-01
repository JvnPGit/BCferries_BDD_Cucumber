package runners;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.cucumberbdd.automationFramework.Listeners.ExtentReportListener;
import com.cucumberbdd.automationFramework.base.Base;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)

@CucumberOptions (
        features = {"./Features/"},
        glue = "stepDefinition",
        dryRun = false,
        tags = "@Regression1",
        monochrome = true
        )

public class ExecuteRunner extends ExtentReportListener {

	public static ExtentTest runnerScenario = null;
	
	//"pretty", "html:test-output",
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		Base.initiateLog4jConfigurator();
	}

	@Test(dataProvider = "features")
	public void feature(PickleEventWrapper eventwrapper, CucumberFeatureWrapper cucumberFeature) throws Throwable {
		// testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
	}

	@DataProvider // (parallel=true)
	public Object[][] features() {
		// return testNGCucumberRunner.provideFeatures();
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
		extent.flush();
	}
	
}
