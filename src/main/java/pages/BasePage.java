package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickElement(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
            LOGGER.debug("Element clicked");
        } catch (Exception e1) {
            try {
                new Actions(driver)
                        .moveToElement(element)
                        .click()
                        .perform();
                LOGGER.debug("Element clicked with Actions");
            } catch (Exception e2){
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                    LOGGER.debug("Element clicked with Javascript");
                } catch (Exception e3) {
                    throw new RuntimeException("All click methods failed");
                }
            }
        }
    }

    public void sendKeysToElement(final WebElement element, final String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            element.clear();
            element.sendKeys(text);
            LOGGER.debug("Text sent to element");
        } catch (Exception e1) {
            try {
                new Actions(driver)
                        .moveToElement(element)
                        .click()
                        .sendKeys(text)
                        .build()
                        .perform();
                LOGGER.debug("Text sent to element with Actions");
            } catch (Exception e2) {
                try {
                    ((JavascriptExecutor) driver)
                            .executeScript("arguments[0].value = arguments[1];", element, text);
                    LOGGER.debug("Text sent to element with Javascript");
                } catch (Exception e3) {
                    throw new RuntimeException("All sendKeys operations failed");
                }
            }
        }
    }

    public void verifyDisplayed(final WebElement element, final String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed(), "Element is not displayed.");
        Assert.assertEquals(element.getText().trim(), expectedText, "Text does not match!");
    }

    public void selectDropdown(final WebElement element, final String selectionType, final String selectionValue) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            Select dropdown = new Select(element);
            switch (selectionType.toLowerCase()) {
                case "visibletext":
                    dropdown.selectByVisibleText(selectionValue);
                    break;
                case "value":
                    dropdown.selectByValue(selectionValue);
                    break;
                case "index":
                    dropdown.selectByIndex(Integer.parseInt(selectionValue));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid selection type: " + selectionType);
            }
            LOGGER.debug("Dropdown selected by " + selectionType + ": " + selectionValue);
        } catch (Exception e1) {
            try {
                new Actions(driver)
                        .moveToElement(element)
                        .click()
                        .perform();
                Select dropdown = new Select(element);
                switch (selectionType.toLowerCase()) {
                    case "visibletext":
                        dropdown.selectByVisibleText(selectionValue);
                        break;
                    case "value":
                        dropdown.selectByValue(selectionValue);
                        break;
                    case "index":
                        dropdown.selectByIndex(Integer.parseInt(selectionValue));
                        break;
                }
                LOGGER.debug("Dropdown selected with Actions by " + selectionType + ": " + selectionValue);
            } catch (Exception e2) {
                try {
                    String script = "var select = arguments[0];"
                            + "var type = arguments[2];"
                            + "var val = arguments[1];"
                            + "if(type === 'visibletext'){"
                            + "for(var i=0;i<select.options.length;i++){"
                            + "if(select.options[i].text===val){select.selectedIndex=i; select.dispatchEvent(new Event('change'));}}"
                            + "}else if(type==='value'){"
                            + "select.value=val; select.dispatchEvent(new Event('change'));"
                            + "}else if(type==='index'){"
                            + "select.selectedIndex=parseInt(val); select.dispatchEvent(new Event('change'));"
                            + "}";
                    ((JavascriptExecutor) driver).executeScript(script, element, selectionValue, selectionType.toLowerCase());
                    LOGGER.debug("Dropdown selected with Javascript by " + selectionType + ": " + selectionValue);
                } catch (Exception e3) {
                    throw new RuntimeException("All dropdown selection methods failed");
                }
            }
        }
    }
}