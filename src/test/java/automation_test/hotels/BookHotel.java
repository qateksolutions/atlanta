package automation_test.hotels;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookHotel {
    private static final By DestinationName = By.id("qf-0q-destination");
    private static final By CheckIn = By.id("qf-0q-localised-check-in");
    private static final By CheckOut = By.id("qf-0q-localised-check-out");
    private static final By AdultNumber = By.id("qf-0q-room-0-adults");
    private static final By SearchButton = By.xpath("//*[@id='hds-marquee']//button[text()='Search']");
    private static final By WhereToHeader = By.xpath("//*[@id='hds-marquee']//h1[contains(text(),'Where to')]");

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.hotels.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void reserveHotel() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        ActOn.element(driver, DestinationName).setValue("Orlando");
        ActOn.element(driver, WhereToHeader).click();
        ActOn.element(driver, CheckIn).setValue("11/08/20");
        ActOn.element(driver, CheckOut).setValue("11/09/20");
        ActOn.element(driver, AdultNumber).selectValue("1");
        ActOn.element(driver, SearchButton).click();
    }


}
