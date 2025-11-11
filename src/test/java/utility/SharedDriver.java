package utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class SharedDriver {
        private static WebDriver driver;

        // Tüm testlerde aynı driver'ı döndürür
        public static WebDriver getDriver() {
            if (driver == null) {
                // ChromeDriver’ı başlat
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            return driver;
        }

        // Test bitince tarayıcıyı kapatmak için
        public static void quitDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
    }
