package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.PaymentPage;
import utility.BaseDriver;

public class PurchaseWithInvalidPaymentSteps extends BaseDriver {

    HomePage homePage;
    PaymentPage paymentPage;

    public PurchaseWithInvalidPaymentSteps() {
        driver = BaseDriver.getDriver();
        this.homePage = new HomePage(driver);
        this.paymentPage = new PaymentPage(driver);
    }

    @When("Click on Pay with Bank Card option on the cart page")
    public void clickPayWithCard() {
        paymentPage.clickCCPayButton();
    }

    @Then("The payment page should display fields for: Email, Name, Card Number, Expiration Date, CVC")
    public void paymentPageDisplayFields() {
        paymentPage.verifyPaymentFieldsDisplayed();
    }

    @And("Click the Pay button")
    public void clickThePayButton() {
        paymentPage.clickPayButton();
    }

    @Then("Verify validation errors for: Invalid Email, Invalid Billing Name")
    public void verifyErrors() {
        paymentPage.verifyValidationErrors();
    }
}