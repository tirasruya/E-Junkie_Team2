package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.time.Instant;

public class EJunkiePage extends BasePage {

    @FindBy(css = "div[class='container'] > div > div > a > img")
    private WebElement eJunkieLogo;

    @FindBy(xpath = "//a[@class='blue_btn']")
    private WebElement howItWorksBtn;

    @FindBy(css = "button.ytp-play-button")
    private WebElement playBtn;

    @FindBy(xpath = "//button[@aria-label='close']")
    public WebElement closeBtn;

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
        WebElement videoFrame = driver.findElement(By.cssSelector("iframe[src*='youtube.com']"));

        String src = videoFrame.getAttribute("src");
        if(!src.contains("autoplay=1")) {
            src += src.contains("?") ? "&autoplay=1&mute=1" : "?autoplay=1&mute=1";
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].src = arguments[1];", videoFrame, src);

        Instant start = Instant.now();
        while(Duration.between(start, Instant.now()).getSeconds() < 10) {
        }

        clickElement(closeBtn);
    }
}