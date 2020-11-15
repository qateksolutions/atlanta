package automation_test.mortgage_calculator_parameterized;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities.DataProviderClass;
import utilities.ReadConfigFiles;

import java.io.IOException;
import java.util.Properties;

public class CalculateRatesParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateRatesParameterized.class);
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

    @Test (dataProvider = "RealAprRates", dataProviderClass = DataProviderClass.class)
    public void calculateRealApr(String homePrice, String downPayment, String interestRate, String aprRate) {
       new Home(driver)
               .mouseHoverToRates()
               .clickOnRealApr()
               .waitForPageToLoad()
               .typeHomePrice(homePrice)
               .typeDownPayment(downPayment)
               .selectDownPaymentInDollar()
               .typeInterestRate(interestRate)
               .clickOnCalculateButton()
               .validateAprRate(aprRate);
    }

    @AfterMethod
    public void closeBrowser() {
        ActOn.browser(driver).closeBrowser();
    }
}
