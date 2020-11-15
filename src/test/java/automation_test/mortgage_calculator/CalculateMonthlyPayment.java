package automation_test.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities.ReadConfigFiles;

import java.io.IOException;
import java.util.Properties;

public class CalculateMonthlyPayment {
    private static final Logger LOGGER = LogManager.getLogger(CalculateMonthlyPayment.class);
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("---------------Test Name: CalculateMonthlyPayment----------");

        ReadConfigFiles readConfigFiles = new ReadConfigFiles();
        Properties prop = readConfigFiles.getPropertyValues();
        String url = prop.getProperty("Url");


        LOGGER.info("The Browser URL is: " + url);
        ActOn.browser(driver).openBrowser(url);
    }

    @Test
    public void calculateRate() {
        new Home(driver)
                .typeHomePrice("300000")
                .typeDownPayment("60000")
                .clickDownPaymentInDollar()
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTermYears("30")
                .selectMonth("Nov")
                .selectYear("2020")
                .typePropertyTax("5000")
                .typePmi("0.5")
                .typeHomeOwnerInsurance("1000")
                .typeMonthlyHoa("100")
                .selectLoanType("Conventional")
                .selectBuyOrRefinance("Buy")
                .clickOnCalculateButton()
                .validateTotalMonthlyPayment("$1,611.85");
    }

    @AfterMethod
    public void closeBrowser() {
        LOGGER.info("--End Test case: CalculateMonthlyPayment--");
        ActOn.browser(driver).closeBrowser();
    }
}
