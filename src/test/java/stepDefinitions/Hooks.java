package stepDefinitions;

import baseClass.BaseSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void Initialize(Scenario scenario) throws Throwable {
		BaseSteps.OpenBrowser();
	}

	@After
	public void Finish(Scenario scenario) throws Throwable {
		if (scenario.isFailed()) {
			/** 
			 * Proximas Versao:
			 * 	Implementar ScreenShot para Erros...
			 * 	Depois fecha o Navegado.
			 * */
		}
		BaseSteps.CloseBrowser();
	}
}
