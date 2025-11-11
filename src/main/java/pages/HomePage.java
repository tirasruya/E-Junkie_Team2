package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//button[@class='view_product'])[2]")
    private WebElement demoEBookBtn;

    @FindBy(css = "div.Col2.Product-Desc > h5")
    private WebElement demoEBookInput;

    @FindBy(className = "Apply-Button Show-Promo-Code-Button")
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

    public void verifyDemoEBookInput(){
        verifyDisplayed(demoEBookInput,"Demo eBook");
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
