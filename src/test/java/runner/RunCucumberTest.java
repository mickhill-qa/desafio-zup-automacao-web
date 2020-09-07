package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",	// Path: features = "classpath:features"
		glue = "stepDefinitions",					// Path: Steps
		monochrome = true,							// Cores no Terminal default: false
		snippets = SnippetType.CAMELCASE,			// METHODOS do Steps em CAMELCASE
		strict = true,								// Considerar steps indefinidos erros ou nao, default: false
		dryRun = false,								// Validar Steps sem executar o teste
		plugin = {									// Plugins Cucumber para possivel integracao com Jenkins
			"pretty",
			"html:target/cucumber-reports/reports-html",
			"json:target/cucumber-reports/report.json",
			"junit:target/cucumber-reports/report.xml"
		},
		
		tags = {
			"@Desafio_Zup_-_Automacao_Web"
		}
)

public class RunCucumberTest {
}
