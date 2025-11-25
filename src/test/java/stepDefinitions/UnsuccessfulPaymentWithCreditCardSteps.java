package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.PaymentPage;
import utility.BaseDriver;

public class UnsuccessfulPaymentWithCreditCardSteps extends BaseDriver {

    HomePage homePage;
    PaymentPage paymentPage;

    public UnsuccessfulPaymentWithCreditCardSteps() {
        driver = BaseDriver.getDriver();
        this.homePage = new HomePage(driver);
        this.paymentPage = new PaymentPage(driver);
    }

    @When("Fill in the mandatory payment fields with valid data except for Card Number")
    public void fillPaymentFields() {
        paymentPage.fillPaymentFormWithInvalidData();
    }

    @And("Click the Payment button")
    public void clickPayButton(){
        paymentPage.clickPayButton();
    }

    @Then("Verify the error message Your card number is invalid")
    public void verifyErrorMessage() {
        paymentPage.verifyCardNumberErrorMessage();
    }
}