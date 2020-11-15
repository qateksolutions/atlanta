package automation_test.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import page_objects.Home;
import utilities.ReadConfigFiles;

import java.io.IOException;
import java.util.Properties;

public class CalculateRates {
    private static final Logger LOGGER = LogManager.getLogger(CalculateRates.class);
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        ReadConfigFiles readConfigFiles = new ReadConfigFiles();
        Properties prop = readConfigFiles.getPropertyValues();
        String url = prop.getProperty("Url");


        LOGGER.info("The Browser URL is: " + url);
        ActOn.browser(driver).openBrowser(url);
    }

    @Test
    public void calculateRealApr() {
       new Home(driver)
               .mouseHoverToRates()
               .clickOnRealApr()
               .waitForPageToLoad()
               .typeHomePrice("200000")
               .typeDownPayment("15000")
               .selectDownPaymentInDollar()
               .typeInterestRate("3")
               .clickOnCalculateButton()
               .validateAprRate("3.130%");
    }

    @AfterMethod
    public void closeBrowser() {
        ActOn.browser(driver).closeBrowser();
    }
}
