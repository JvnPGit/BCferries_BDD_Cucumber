package com.cucumberbdd.automationFramework.reportsHelper;

import com.cucumberbdd.automationFramework.base.Base;

public class ReportUtils extends Base {

	public static void generateJVMReport() {
		/* File reportOutputDirectory = new File("/target/site/cucumber-reports-advanced");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/cucumber.json");

		String buildNumber = "1";
		String projectName = "SampleBDD";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc for details
		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		// do not make scenario failed when step has status SKIPPED
		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Branch", "release/1.0");

		// optionally add metadata presented on main page via properties file
		/*
		 * List<String> classificationFiles = new ArrayList<>();
		 * classificationFiles.add("properties-1.properties");
		 * classificationFiles.add("properties-2.properties");
		 * configuration.addClassificationFiles(classificationFiles);
		 */

		// optionally specify qualifiers for each of the report json files
	/*	configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
		configuration.setQualifier("cucumber-report-1", "First report");
		configuration.setQualifier("cucumber-report-2", "Second report");

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
		// and here validate 'result' to decide what to do if report has failed */
	}
	
}
