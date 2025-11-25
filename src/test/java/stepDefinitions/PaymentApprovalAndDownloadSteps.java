package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ConfirmationPage;
import pages.PaymentPage;
import utility.BaseDriver;

public class PaymentApprovalAndDownloadSteps extends BaseDriver {

    ConfirmationPage confirmationPage;

    public PaymentApprovalAndDownloadSteps() {
        driver = BaseDriver.getDriver();
        this.confirmationPage = new ConfirmationPage(driver);
    }

    @When("Verify EBook price")
    public void verifyEBookPrice() {
        confirmationPage.verifyEBookPrice();
    }

    @Then("Download EBook")
    public void downloadEBook() {
        confirmationPage.clickDownloadButton();
    }
}