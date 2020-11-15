package automation_test.selenium_grid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestEnvironment;


public class SeleniumGrid_Firefox {
    WebDriver driver;

    @Test
    public void runInFirefox() {
        driver = TestEnvironment.selectTestExecutionEnvironment();
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
