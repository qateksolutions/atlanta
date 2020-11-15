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
import utilities.ReadConfigFiles;
import utilities.SqlConnector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CalculateMonthlyPaymentParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateMonthlyPaymentParameterized.class);
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
        ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
        try {
            while (rs.next()) {
                new Home(driver)
                        .typeHomePrice(rs.getString("homevalue"))
                        .typeDownPayment(rs.getString("downpayment"))
                        .clickDownPaymentInDollar()
                        .typeLoanAmount(rs.getString("loanamount"))
                        .typeInterestRate(rs.getString("interestrate"))
                        .typeLoanTermYears(rs.getString("loanterm"))
                        .selectMonth(rs.getString("startdatemonth"))
                        .selectYear(rs.getString("startdateyear"))
                        .typePropertyTax(rs.getString("propertytax"))
                        .typePmi(rs.getString("pmi"))
                        .typeHomeOwnerInsurance(rs.getString("homeownerinsurance"))
                        .typeMonthlyHoa(rs.getString("monthlyhoa"))
                        .selectLoanType(rs.getString("loantype"))
                        .selectBuyOrRefinance(rs.getString("buyorrefi"))
                        .clickOnCalculateButton()
                        .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @AfterMethod
    public void closeBrowser() {
        LOGGER.info("--End Test case: CalculateMonthlyPayment--");
        ActOn.browser(driver).closeBrowser();
    }
}
