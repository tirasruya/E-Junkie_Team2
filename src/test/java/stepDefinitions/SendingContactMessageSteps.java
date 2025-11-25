package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactPage;
import pages.EJunkiePage;
import pages.HomePage;
import utility.BaseDriver;

public class SendingContactMessageSteps extends BaseDriver {

    HomePage homePage;
    ContactPage contactPage;

    public SendingContactMessageSteps(){
        driver = BaseDriver.getDriver();
        this.homePage = new HomePage(driver);
        this.contactPage = new ContactPage(driver);
    }

    @Given("Navigate to the homepage")
    public void navigate_to_the_homepage() {

    }

    @When("Click on the Contact Us button")
    public void click_on_the_button() {
        homePage.clickContactUsBtn();
    }

    @When("Fill in the contact form with:")
    public void fill_in_the_contact_form_with(DataTable dataTable) {
        contactPage.fillContactForm(dataTable);
    }

    @When("Click the Send Message button")
    public void click_the_button() {
        contactPage.clickSendMessageBtn();
    }

    @Then("Verify the warning Recaptcha Mismatch")
    public void verify_the_warning() {
        contactPage.verifyRecaptchaAlert();
    }
}