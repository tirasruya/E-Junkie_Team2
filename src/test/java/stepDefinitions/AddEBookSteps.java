package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import utility.BaseDriver;

public class AddEBookSteps extends BaseDriver {

    HomePage homePage;
    CartPage cartPage;

    public AddEBookSteps(){
        driver = BaseDriver.getDriver();
        this.homePage = new HomePage(driver);
        this.cartPage = new CartPage(driver);
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
        cartPage.enterCartFrame();
        cartPage.verifyDemoEBookInput();
    }

    @Then("Click the Add Promo Code button")
    public void click_the_add_promo_code_button() {
        cartPage.clickAddPromoCodeBtn();
    }

    @Then("Input an invalid promo code")
    public void input_an_invalid_promo_code() {
        cartPage.enterNumberPromoCodeInput("1");
    }

    @Then("Click the Apply button")
    public void click_the_apply_button() {
        cartPage.clickPromoApplyBtn();
    }

    @Then("Verify the invalid message")
    public void verify_the_invalid_message() {
        cartPage.verifyInvalidMessage();
    }
}