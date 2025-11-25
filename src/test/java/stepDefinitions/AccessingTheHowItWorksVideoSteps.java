package stepDefinitions;

import io.cucumber.java.en.*;
import pages.EJunkiePage;
import utility.BaseDriver;

public class AccessingTheHowItWorksVideoSteps extends BaseDriver {

    EJunkiePage eJunkiePage;

    public AccessingTheHowItWorksVideoSteps(){
        driver = BaseDriver.getDriver();
        this.eJunkiePage = new EJunkiePage(driver);
    }

    @Given("the user is on the E-Junkie homepage")
    public void userIsOnEJunkieHomepage() {
        BaseDriver.getDriver().get("https://www.e-junkie.com/");
    }

    @When("the user clicks the How It Works button")
    public void userClicksButton() {
            eJunkiePage.clickHowItWorksBtn();
    }

    @Then("the URL should be e-junkie.com")
    public void verifyURL() {
        eJunkiePage.verifyURL();
    }

    @Then("the YouTube video should start playing")
    public void playVideo(){
        eJunkiePage.playVideoAndCloseAfter();
    }

    @Then("the video window should close after 10 seconds")
    public void closeVideo() {
        eJunkiePage.playVideoAndCloseAfter();
    }
}