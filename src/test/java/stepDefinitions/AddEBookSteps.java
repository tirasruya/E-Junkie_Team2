package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utility.BaseDriver;

public class AddEBookSteps extends BaseDriver {

    HomePage homePage;

    public AddEBookSteps(){
        this.homePage = new HomePage(BaseDriver.getDriver());
    }

    @When("Navigate the homepage")
    public void navigate_the_homepage() {
        System.out.println("Navigated to homepage successfully.");
    }

    @Then("Find the Add to Cart button and click it")
    public void find_the_add_to_cart_button_and_click_it() {
        homePage.clickDemoEBookBtn();
    }

    @Then("Verify E Book added")
    public void verify_e_book_added() {
        homePage.enterCartFrame();
        homePage.verifyDemoEBookInput();
    }

    @Then("Click the Add Promo Code button")
    public void click_the_add_promo_code_button() {
        homePage.clickAddPromoCodeBtn();
    }

    @Then("Input an invalid promo code")
    public void input_an_invalid_promo_code() {
        homePage.enterNumberPromoCodeInput("1");
    }

    @Then("Click the Apply button")
    public void click_the_apply_button() {
        homePage.clickPromoApplyBtn();
    }

    @Then("Verify the invalid message")
    public void verify_the_invalid_message() {
        homePage.verifyInvalidMessage();
    }
}