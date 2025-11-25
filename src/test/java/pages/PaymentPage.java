package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage extends BasePage {

    @FindBy(css = "button.Payment-Button.CC")
    private WebElement CCPayBtn;

    @FindBy(css = "input[type=email]")
    private WebElement emailInput;

    @FindBy(css = "p.Billing-Email-Confirm.Inline > input[type=email]")
    private WebElement emailConfirmationInput;

    @FindBy(css = "p.Billing-Name.Inline.MarginRight > input[type=text]")
    private WebElement nameInput;

    @FindBy(css = "input[name='cardnumber']")
    private WebElement cardNumberInput;

    @FindBy(css = "input[name='exp-date']")
    private WebElement expDateInput;

    @FindBy(css = "input[name='cvc']")
    private WebElement cvcInput;

    @FindBy(css = ".Pay-Button")
    private WebElement payBtn;

    @FindBy(css = "#SnackBar > span")
    private WebElement errorMessages;

    @FindBy(xpath = "//div[2]/div/div/p/span")
    private WebElement confirmationMessage;

    @FindBy(id = "checkbox")
    private WebElement checkbox;


    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void clickCCPayButton() {
        clickElement(CCPayBtn);
    }

    public void verifyPaymentFieldsDisplayed() {

        wait.until(ExpectedConditions.visibilityOf(emailInput));
        wait.until(ExpectedConditions.visibilityOf(nameInput));

        WebElement stripeFrame = driver.findElement(By.cssSelector("iframe[name^='__privateStripeFrame']"));
        driver.switchTo().frame(stripeFrame);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(cardNumberInput));
        wait.until(ExpectedConditions.visibilityOf(expDateInput));
        wait.until(ExpectedConditions.visibilityOf(cvcInput));

        driver.switchTo().parentFrame();
    }

    public void clickPayButton() {
        clickElement(payBtn);
    }

    public void verifyValidationErrors() {
        verifyDisplayed(errorMessages, "Invalid Email Invalid Email Invalid Billing Name");
    }

    public void fillPaymentFormWithInvalidData(){
        sendKeysToElement(emailInput, "tester@example.com");
        sendKeysToElement(emailConfirmationInput, "tester@example.com");
        sendKeysToElement(nameInput, "Tester");

        WebElement stripeFrame = driver.findElement(By.cssSelector("iframe[name^='__privateStripeFrame']"));
        driver.switchTo().frame(stripeFrame);

        sendKeysToElement(cardNumberInput, "1111 1111 1111 1111");
        sendKeysToElement(expDateInput, "1130");
        sendKeysToElement(cvcInput, "1111");

        driver.switchTo().parentFrame();
    }

    public void fillPaymentFormWithValidData(){
        sendKeysToElement(emailInput, "tester@example.com");
        sendKeysToElement(emailConfirmationInput, "tester@example.com");
        sendKeysToElement(nameInput, "Tester");

        WebElement stripeFrame = driver.findElement(By.cssSelector("iframe[name^='__privateStripeFrame']"));
        driver.switchTo().frame(stripeFrame);

        sendKeysToElement(cardNumberInput, "4242 4242 4242 4242");
        sendKeysToElement(expDateInput, "1225");
        sendKeysToElement(cvcInput, "000");

        driver.switchTo().parentFrame();

        WebElement captchaFrame = driver.findElement(By.cssSelector("#h-captcha-ele > iframe"));
        driver.switchTo().frame(captchaFrame);

        clickElement(checkbox);

        threadWait(10);

        driver.switchTo().parentFrame();
    }

    public void verifyCardNumberErrorMessage(){
        verifyDisplayed(errorMessages, "Your card number is invalid.");
    }

    public void verifyConfirmationMessage(){
        driver.switchTo().defaultContent();
        verifyDisplayed(confirmationMessage, "your order is confirmed. Thank you!");
    }
}