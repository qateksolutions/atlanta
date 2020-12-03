package automation_test.selenium_grid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;


public class SeleniumGrid_Chrome2 {
    WebDriver driver;

    @Test
    public void runInChrome2() {
        driver = TestEnvironment.selectTestExecutionEnvironment();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
