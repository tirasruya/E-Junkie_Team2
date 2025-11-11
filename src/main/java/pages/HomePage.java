package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//button[@class='view_product'])[2]")
    private WebElement demoEBookBtn;

    @FindBy(css = "iframe.EJIframeV3")
    private WebElement cartFrame;

    @FindBy(css = "iframe[src*='fatfreecartpro.com/ecom/gv3.php")
    private WebElement demoEBookQuantity;

    @FindBy(xpath = "//button[text()='Add Promo Code']")
    private WebElement addPromoCodeBtn;

    @FindBy(className = "Promo-Code-Value")
    private WebElement numberPromoCodeInput;

    @FindBy(className = "Promo-Apply")
    private WebElement promoApplyBtn;

    @FindBy(xpath = "//*[@id='SnackBar']/span/text()")
    private WebElement invalidMessage;

    public void clickDemoEBookBtn(){
        clickElement(demoEBookBtn);
    }

    public void enterCartFrame(){
        driver.switchTo().frame(cartFrame);
    }

    public void verifyDemoEBookInput(){
        verifyDisplayed(demoEBookQuantity,"1");
    }

    public void clickAddPromoCodeBtn(){
        clickElement(addPromoCodeBtn);
    }

    public void enterNumberPromoCodeInput(String number){
        sendKeysToElement(numberPromoCodeInput,number);
    }

    public void clickPromoApplyBtn(){
        clickElement(promoApplyBtn);
    }

    public void verifyInvalidMessage(){
        verifyDisplayed(invalidMessage,"Invalid promo code");
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
