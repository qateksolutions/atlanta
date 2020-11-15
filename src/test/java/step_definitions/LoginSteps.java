package step_definitions;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import command_providers.ActOn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private static final By FullName = By.id("name");
    private static final By Password = By.id("password");
    private static final By Login = By.id("login");
    private static final By Logout = By.id("logout");
    private static final By InvalidPassword = By.xpath("//*[@id='pageLogin']/form//div[text()='Password is invalid']");
    private static Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    WebDriver driver;

    // Precondition
    @Given("^a user is on the login page$")
    public void navigateToLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://example.testproject.io/web/");
        LOGGER.info("User is in the Login Page");
    }

    // Main Action
    @When("^user enters username and password$")
    public void enterUserCredentials() {
        ActOn.element(driver, FullName).setValue("Rifat");
        ActOn.element(driver, Password).setValue("12345");
        LOGGER.info("User has entered credentials");
    }

    // Main Action
    @When("^user enters \"(.+?)\" and \"(.+?)\"$")
    public void enterUserCredentials(String username, String password) {
        ActOn.element(driver, FullName).setValue(username);
        ActOn.element(driver, Password).setValue(password);
        LOGGER.info("User has entered credentials");
    }

    // Additional Action
    @And("^click on login button$")
    public void clickOnLogin() {
        ActOn.element(driver, Login).click();
        LOGGER.info("User clicked on Login button");
    }

    // Assertion
    @Then("^user is navigated to home page$")
    public void validateUserIsLoggedInSuccessfully() {
        boolean logoutDisplayed = driver.findElement(Logout).isDisplayed();
        Assert.assertTrue("Logout button is not displayed", logoutDisplayed);
        LOGGER.info("User is in Home Page");
        ActOn.browser(driver).closeBrowser();
    }

    @Then("^user is failed to login$")
    public void validateUserIsFailedToLogin() {
        boolean invalidPassword = driver.findElement(InvalidPassword).isDisplayed();
        Assert.assertTrue("Invalid Password is not displayed", invalidPassword);
        LOGGER.info("User is still in login page");
        ActOn.browser(driver).closeBrowser();
    }
}
