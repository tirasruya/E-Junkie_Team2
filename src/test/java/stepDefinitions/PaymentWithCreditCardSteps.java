package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ConfirmationPage;
import pages.PaymentPage;
import utility.BaseDriver;

public class PaymentWithCreditCardSteps extends BaseDriver {

    PaymentPage paymentPage;
    ConfirmationPage confirmationPage;

    public PaymentWithCreditCardSteps() {
        driver = BaseDriver.getDriver();
        this.paymentPage = new PaymentPage(driver);
        this.confirmationPage = new ConfirmationPage(driver);
    }

    @When("Fill in the mandatory payment fields with valid data")
    public void fillPaymentFieldsWithValidData() {
        paymentPage.fillPaymentFormWithValidData();
    }

    @And("Click the Payment button with valid data")
    public void clickPaymentButton() {
        paymentPage.clickPayButton();
    }

    @Then("Verify the confirmation message")
    public void verify_the_confirmation_message() {
        confirmationPage.verifyConfirmationMessage();
    }
}
