package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//button[@class='view_product'])[2]")
    private WebElement demoEBookBtn;

    @FindBy(css = ".EJ-ShopLink.EJ-ShopLink")
    private WebElement eCommerceByEJunkieText;

    @FindBy(css = ".contact")
    private WebElement contactUsBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickDemoEBookBtn(){
        List<WebElement> boxes = driver.findElements(By.cssSelector("div.box"));
        for (WebElement box : boxes) {
            if (box.findElement(By.cssSelector("h4.title")).getText().equals("Demo eBook")) {
                box.findElement(By.cssSelector("button.view_product")).click();
                break;
            }
        }
    }

    public void clickECommerceByEJunkieText() {
        clickElement(eCommerceByEJunkieText);
    }

    public void clickContactUsBtn() {
        clickElement(contactUsBtn);
    }
}