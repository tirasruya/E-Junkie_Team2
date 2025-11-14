package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }
    Actions actionDriver = new Actions(BaseDriver.getDriver());

    @FindBy(xpath = "(//button[@class='view_product'])[2]")
    private WebElement demoEBookBtn;

    @FindBy(css = "iframe.EJIframeV3")
    private WebElement cartFrame;

    @FindBy(css = "iframe[src*='fatfreecartpro.com/ecom/gv3.php']")
    private WebElement demoEBookQuantity;

    @FindBy(xpath = "//button[text()='Add Promo Code']")
    private WebElement addPromoCodeBtn;

    @FindBy(className = "Promo-Code-Value")
    private WebElement numberPromoCodeInput;

    @FindBy(className = "Promo-Apply")
    private WebElement promoApplyBtn;

    @FindBy(xpath = "//div[@id='SnackBar']//span[contains(text(), 'Invalid promo code')]\n")
    private WebElement invalidMessage;

    public void clickDemoEBookBtn(){
        List<WebElement> boxes = driver.findElements(By.cssSelector("div.box"));
        for (WebElement box : boxes) {
            if (box.findElement(By.cssSelector("h4.title")).getText().equals("Demo eBook")) {
                box.findElement(By.cssSelector("button.view_product")).click();
                break;
            }
        }
    }

    public void enterCartFrame(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.EJIframeV3")));
        driver.switchTo().frame(cartFrame);
    }

    public void verifyDemoEBookInput(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='Apply-Button Show-Promo-Code-Button']")));
        WebElement clickablebitch = driver.findElement(By.cssSelector("button[class='Apply-Button Show-Promo-Code-Button']"));
        actionDriver.moveToElement(clickablebitch).click().build().perform();
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
