package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasePage {

    @FindBy(xpath = "//div[2]/div/div/p/span")
    private WebElement confirmationMessage;

    @FindBy(css = "div.col-md-3.col-sm-3.col-xs-4.text-right > span")
    private WebElement eBookPrice;

    @FindBy(css = ".download_btn.top10")
    private WebElement downloadBtn;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void verifyConfirmationMessage(){
        driver.switchTo().defaultContent();
        verifyDisplayed(confirmationMessage, "your order is confirmed. Thank you!");
    }

    public void verifyEBookPrice () {
        verifyDisplayed(eBookPrice, "Qty(1) USD 0.50");
    }

    public void clickDownloadButton() {
        clickElement(downloadBtn);
    }
}