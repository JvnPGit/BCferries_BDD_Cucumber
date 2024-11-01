package com.cucumberbdd.automationFramework.utilsHelper;

import com.cucumberbdd.automationFramework.base.Base;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Base {

	@Before(order = 1)
	public void beforeScenario() {
		System.out.println("This will run before the every Scenario");
	}

	@Before(order = 0)
	public void beforeScenarioStart() {
		System.out.println("-----------------Start of Scenario-----------------");
	}

	@After(order = 0)
	public void afterScenarioFinish() {
		System.out.println("-----------------End of Scenario-----------------");
	}

	@After(order = 1)
	public void afterScenario() {
		System.out.println("This will run after the every Scenario");
	}
}
