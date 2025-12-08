package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})
@CucumberOptions(
        features = {"src/test/resources/features/addEBook.feature",},
        glue = {"stepDefinitions", "Hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)

public class AddEBookRunner extends AbstractTestNGCucumberTests {

}
