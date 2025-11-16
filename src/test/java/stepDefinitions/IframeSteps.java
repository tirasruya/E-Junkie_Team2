package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class IframeSteps extends BaseDriver {

    @When("The user switches to the frame whose iframe ID is {string}")
    public void switchToIframeById(String cssOrId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait until the frame is ready and switch to it automatically
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(cssOrId)));
    }

    @Then("The {string} element inside the iframe is clicked.")
    public void clickInsideIframe(String cssSelector) {
        WebElement el = driver.findElement(By.cssSelector(cssSelector));
        el.click();
    }

    @And("Return to the home page")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}