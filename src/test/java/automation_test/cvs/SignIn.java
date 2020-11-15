package automation_test.cvs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignIn {
    private final By CreateAccount = By.linkText("Create an Account");
    private final By ClosePopup = By.linkText(" No, thanks ");
    private final By EmailOffer = By.xpath("//*[@id='email-offers']");

    WebDriver driver;


    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.cvs.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void createAccount() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(CreateAccount).click();

        System.out.println(java.time.LocalTime.now());
        boolean checkPopUp = driver.findElements(ClosePopup).size() > 0;
        if (checkPopUp) {
            driver.findElement(ClosePopup).click();
        }
        System.out.println(java.time.LocalTime.now());

        WebElement webElement = driver.findElement(EmailOffer);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }
}
