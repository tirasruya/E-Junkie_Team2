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

    @When("kullanıcı iframe id'si {string} olan frame'e geçer")
    public void switchToIframeById(String cssOrId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // frame hazır olana kadar bekle ve otomatik switch et
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(cssOrId)));
    }

    @Then("iframe içindeki {string} elementi tıklanır")
    public void clickInsideIframe(String cssSelector) {
        WebElement el = driver.findElement(By.cssSelector(cssSelector));
        el.click();
    }

    @And("ana sayfaya geri dönülür")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
