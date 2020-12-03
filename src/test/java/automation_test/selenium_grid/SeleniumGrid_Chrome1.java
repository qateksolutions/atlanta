package automation_test.selenium_grid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;

public class SeleniumGrid_Chrome1 {
    WebDriver driver;

    @Test
    public void runInChrome1() {
        driver = TestEnvironment.selectTestExecutionEnvironment();
        driver.get("https://www.mortgagecalculator.org/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
