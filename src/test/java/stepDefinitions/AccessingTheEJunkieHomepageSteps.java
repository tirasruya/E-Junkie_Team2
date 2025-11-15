package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utility.BaseDriver;

public class AccessingTheEJunkieHomepageSteps extends BaseDriver {

    HomePage homePage;

    public AccessingTheEJunkieHomepageSteps(){
        this.homePage = new HomePage(BaseDriver.getDriver());
    }

    @When("the user clicks the {string} link")
    public void userClicksECommerceLink(String linkName) {
        homePage.clickECommerceByEJunkieText();
    }

    @When("the user clicks the E-Junkie logo on the new page")
    public void clickEJunkieLogo() {
        homePage.clickEJunkieLogo();
    }

    @Then("the user should be redirected to {string}")
    public void verifyRedirectedURL(String expectedUrl) {
        homePage.verifyEJunkieHomeURL();
    }

}
