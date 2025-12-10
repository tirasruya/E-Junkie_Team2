package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver;

    public static WebDriver getDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        chromeOptions.addArguments("--window-size=1920,1080");

        if (driver == null) {
            driver = new ChromeDriver();
            driver.get("https://shopdemo.fatfreeshop.com/?");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void threadWait(int second) {
        try {
            Thread.sleep(second*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tearDown() {
        driver.quit();
    }
}
