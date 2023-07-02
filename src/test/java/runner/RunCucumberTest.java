package runner;

import baseClass.BaseSteps;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.rajatthareja.reportbuilder.ReportBuilder;
import com.rajatthareja.reportbuilder.Color;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",	            // Path: features = "classpath:features"
        glue = "stepDefinitions",					            // Path: Steps
        monochrome = false,							            // Cores no Terminal default: false
        snippets = CucumberOptions.SnippetType.UNDERSCORE,		// METHODOS do Steps em CAMELCASE
        dryRun = false,								            // Validar Steps sem executar o teste
        plugin = {									            // Plugins Cucumber para possivel integracao com Jenkins
                "pretty",
                "html:target/cucumber/index.html",
                "junit:target/cucumber/index.xml",
                "json:target/cucumber/index.json"
        }
        //,tags = { "@tagScenario" }

        /**
         * Executar testes no termial
         *
         *	$ mvn test
         *	$ mvn test -Dcucumber.options="--tags @tagScenario"
         *
         *	$ mvn clean
         *	$ mvn clean test
         * */
)

public class RunCucumberTest {
    @BeforeClass
    public static void BeforeAllTest() throws Throwable {
        BaseSteps.OpenBrowser();
    }

    @AfterClass
    public static void AfterAllTest() throws Throwable {
        BaseSteps.CloseBrowser();

        // Report-Builder
        List<Object> cucumberJsonReports = new ArrayList<>();
        ReportBuilder reportBuilder = new ReportBuilder();
        String dataReport = (new SimpleDateFormat("MMM dd, yyyy (EEE) | HH:mm:ss zzz")).format(new Date());

        cucumberJsonReports.add(new File("target/cucumber/index.json"));
        reportBuilder.setReportDirectory("target/report-builder/");
        reportBuilder.setReportFileName("index");
        reportBuilder.setReportColor(Color.CYAN); // http://materializecss.com/color.html
        reportBuilder.setReportTitle("desafio_zup_automacao_web");
        reportBuilder.setAdditionalInfo("Date", dataReport);
        reportBuilder.setAdditionalInfo("Environment", "N/A");
        reportBuilder.setAdditionalInfo("Browser", "N/A");
        reportBuilder.setAdditionalInfo("Url", "N/A");
        reportBuilder.setAdditionalInfo("Runtime", "N/A");
        reportBuilder.build(cucumberJsonReports);
    }
}
