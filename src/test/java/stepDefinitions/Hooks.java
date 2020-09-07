package stepDefinitions;

import baseClass.BaseSteps;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void Initialize() {
		System.out.println("============================");
		System.out.println("        Inicio Teste");
		System.out.println("============================\n");
		BaseSteps.OpenBrowser();
	}

	@After
	public void Finish() {
		BaseSteps.CloseBrowser();
		System.out.println("=======================");
		System.out.println("       Fim Teste");
		System.out.println("=======================\n");
	}
}
