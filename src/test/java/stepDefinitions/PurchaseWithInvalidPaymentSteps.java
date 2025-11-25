package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.PaymentPage;
import utility.BaseDriver;

public class PurchaseWithInvalidPaymentSteps extends BaseDriver {

    HomePage homePage;
    PaymentPage paymentPage;

    public PurchaseWithInvalidPaymentSteps(HomePage homePage) {
        driver = BaseDriver.getDriver();
        this.homePage = new HomePage(driver);
        this.paymentPage = new PaymentPage(driver);
    }

    @When("Click on Pay with Bank Card option on the cart page")
    public void clickPayWithCard() {
        paymentPage.clickPayButton();
    }

    @Then("The payment page should display fields for:")
    public void paymentPageDisplayFields(DataTable dataTable) {
        paymentPage.verifyPaymentFieldsDisplayed();
    }

    @When("Leave all payment fields empty")
    public void leavePaymentFieldsEmpty() {
        paymentPage.leaveAllFieldsEmpty();
    }

    @And("Click the Pay button")
    public void clickThePayButton() {
        paymentPage.clickPayButton();
    }

    @Then("Verify validation errors for:")
    public void verifyErrors(DataTable dataTable) {

    }
}
