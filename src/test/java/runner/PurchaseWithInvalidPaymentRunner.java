package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/purchaseWithInvalidPayment.feature"},
        glue = {"stepDefinitions", "Hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html"}
)

public class PurchaseWithInvalidPaymentRunner extends AbstractTestNGCucumberTests {
}
