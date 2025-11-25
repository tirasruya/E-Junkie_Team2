package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaymentPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "billing_name")
    private WebElement nameInput;

    @FindBy(id = "card_number")
    private WebElement cardNumberInput;

    @FindBy(id = "exp_date")
    private WebElement expDateInput;

    @FindBy(id = "cvc")
    private WebElement cvcInput;

    @FindBy(id = "pay_button")
    private WebElement payButton;

    @FindBy(css = ".error_message")
    private List<WebElement> errorMessages;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPaymentFieldsDisplayed() {
        verifyDisplayed(emailInput, "Email");
        verifyDisplayed(nameInput, "Name");
        verifyDisplayed(cardNumberInput, "Card Number");
        verifyDisplayed(expDateInput, "Expiration Date");
        verifyDisplayed(cvcInput, "CVC");
    }

    public void leaveAllFieldsEmpty() {
        emailInput.clear();
        nameInput.clear();
        cardNumberInput.clear();
        expDateInput.clear();
        cvcInput.clear();
    }

    public void clickPayButton() {
        clickElement(payButton);
    }

    public void verifyValidationErrors() {
    }
}