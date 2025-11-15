package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EJunkiePage extends BasePage {

    @FindBy(css = "div.column.is-2-desktop.is-4-tablet.is-4-mobile > a > img")
    private WebElement eJunkieLogo;

    @FindBy(css = "div.columns.is-multiline.is-mobile.is-centered > div > div > a.blue_btn")
    private WebElement howItWorksBtn;

    public EJunkiePage(WebDriver driver) {
        super(driver);
    }

    public void clickEJunkieLogo() {
        clickElement(eJunkieLogo);
    }

    public void verifyEJunkieHomeURL() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.e-junkie.com/",
                "URL is not redirected to the E-Junkie homepage!");
    }

    public void clickHowItWorksBtn() {
        clickElement(howItWorksBtn);
    }

    public void verifyURL() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.e-junkie.com/", "URL does not match expected");
    }

    public void playVideoAndCloseAfter() {
    }
}