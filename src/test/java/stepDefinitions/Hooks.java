package stepDefinitions;

import baseClass.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import static baseClass.BaseSteps.screenshot;

public class Hooks {
    @Before
    public void BeforeAllScenario(Scenario _scenario) {
        BaseSteps.scenario = _scenario;
    }

    @After
    public void AfterAllScenario() {
        if (BaseSteps.scenario.isFailed()) {
            screenshot();
        }
    }
}
