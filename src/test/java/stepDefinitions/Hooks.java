package stepDefinitions;

import baseClass.BaseSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void Initialize() {
		BaseSteps.OpenBrowser();
	}

	@After
	public void Finish(Scenario scenario) {
		if (!scenario.isFailed()) {
			BaseSteps.CloseBrowser();
		}
		else {
			/** 
			 * Proximas Versao:
			 * 	Implementar ScreenShot para Erros...
			 * 	Depois fecha o Navegado.
			 * */
		}
	}
}
