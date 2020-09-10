package stepDefinitions;

import baseClass.BaseSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void Initialize(Scenario _scenario) throws Throwable {
		BaseSteps.OpenBrowser();
		BaseSteps.scenario = _scenario;
	}

	@After
	public void Finish() throws Throwable {
		if (BaseSteps.scenario.isFailed())
			BaseSteps.screenShotNow();
		BaseSteps.CloseBrowser();
	}
}
