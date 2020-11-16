package practice.test_env;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBrowser {
    WebDriver driver;

    void selectExecutionEnvironment() throws MalformedURLException {
        String environment = System.getProperty("environment");
        System.out.println("Execution Environment: " + environment);
        String browser = System.getProperty("browser");
        URL gridUrl = new URL("http://localhost:4444/wd/hub");

        if (environment.equals("remote") && browser.equals("chrome")) {
            System.out.println("Execution browser: Chrome");
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new RemoteWebDriver(gridUrl, chromeOptions);
        } else if (environment.equals("remote") && browser.equals("firefox")) {
            System.out.println("Execution browser: Firefox");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new RemoteWebDriver(gridUrl, firefoxOptions);
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    @Test
    void executeTestInDocker() throws MalformedURLException {
        selectExecutionEnvironment();
        driver.get("https://www.google.com/");
        System.out.println("Browser Title: " + driver.getTitle());
        driver.quit();
    }
}
