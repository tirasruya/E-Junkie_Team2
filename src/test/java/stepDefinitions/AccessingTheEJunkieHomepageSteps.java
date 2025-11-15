package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EJunkiePage;
import pages.HomePage;
import utility.BaseDriver;

public class AccessingTheEJunkieHomepageSteps extends BaseDriver {

    HomePage homePage;
    EJunkiePage eJunkiePage;

    public AccessingTheEJunkieHomepageSteps(){
        driver = BaseDriver.getDriver();
        this.homePage = new HomePage(driver);
        this.eJunkiePage = new EJunkiePage(driver);
    }

    @When("the user clicks the ECommerceByEJunkie link")
    public void userClicksECommerceLink() {
        homePage.clickECommerceByEJunkieText();
    }

    @When("the user clicks the E-Junkie logo on the new page")
    public void clickEJunkieLogo() {
        eJunkiePage.clickEJunkieLogo();
    }

    @Then("the user should be redirected to e-junkie.com")
    public void verifyEJunkieHomeURL() {
        eJunkiePage.verifyEJunkieHomeURL();
    }
}