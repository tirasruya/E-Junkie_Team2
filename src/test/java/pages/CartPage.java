package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utility.BaseDriver;

public class CartPage extends BasePage {

    @FindBy(css = "span.Cart-Items-Nos")
    private WebElement demoEBookQuantity;

    @FindBy(css = ".Apply-Button.Show-Promo-Code-Button")
    private WebElement addPromoCodeBtn;

    @FindBy(className = "Promo-Code-Value")
    private WebElement numberPromoCodeInput;

    @FindBy(className = "Promo-Apply")
    private WebElement promoApplyBtn;

    @FindBy(xpath = "//div[@id='SnackBar']//span[contains(text(), 'Invalid promo code')]\n")
    private WebElement invalidMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    Actions actionDriver = new Actions(BaseDriver.getDriver());

    public void enterCartFrame(){
        WebElement cartFrame = driver.findElement(By.cssSelector("iframe.EJIframeV3"));
        driver.switchTo().frame(cartFrame);
    }

    public void verifyDemoEBookInput(){
        verifyDisplayed(demoEBookQuantity, "1");
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
}
