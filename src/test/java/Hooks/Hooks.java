package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utility.BaseDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    public static WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    @Before
    public void setup(Scenario scenario) {
        driver = BaseDriver.getDriver();
        LOGGER.info("Driver created for scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver == null) return;

        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String scenarioName = scenario.getName().replaceAll(" ", "_");

            String folderPath = System.getProperty("user.dir") + "/src/screenshots/";
            File folder = new File(folderPath);
            if (!folder.exists()) folder.mkdirs();

            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);

            File destFile = new File(folderPath + scenarioName + "_" + timestamp + ".png");
            try (FileOutputStream out = new FileOutputStream(destFile)) {
                out.write(screenshotBytes);
            }

            scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Screenshot alınamadı: " + e.getMessage());
        } finally {
            try {
                driver.quit();
            } catch (Exception e) {
                LOGGER.error("Driver quit hatası: " + e.getMessage());
            }
        }
    }
}