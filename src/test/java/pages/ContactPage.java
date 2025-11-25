package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class ContactPage extends BasePage {

    @FindBy(id = "sender_name")
    private WebElement nameInput;

    @FindBy(id = "sender_email")
    private WebElement emailInput;

    @FindBy(id = "sender_subject")
    private WebElement subjectInput;

    @FindBy(id = "sender_message")
    private WebElement messageInput;

    @FindBy(id = "send_message_button")
    private WebElement sendMessageBtn;

    @FindBy(xpath = "//*[contains(text(),'Recaptcha')]")
    private WebElement warningMessage;


    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(DataTable dataTable) {

        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

        sendKeysToElement(nameInput, data.get("name"));
        sendKeysToElement(emailInput, data.get("email"));
        sendKeysToElement(subjectInput, data.get("subject"));
        sendKeysToElement(messageInput, data.get("message"));
    }

    public void clickSendMessageBtn() {
        clickElement(sendMessageBtn);
    }

    public void verifyRecaptchaAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        if (!alertText.equals("Recaptcha didn't match")) {
            throw new AssertionError("Expected alert text: \"Recaptcha didn't match\", but got: \"" + alertText + "\"");
        }

        alert.accept();
    }
}
