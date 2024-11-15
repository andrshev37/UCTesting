package org.example.steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.Login;
import org.example.Dashboard;
import org.example.WebDriverSingleton;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps {
    private static WebDriver driver;
    private Login login;
    private Dashboard dashboard;
    private Logger logger;

    @Given("I open login page {string} in {string} browser or firefox")
    public void iOpenPage(String page, String browser) {
        driver = WebDriverSingleton.getDriver(browser);
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        logger = LoggerFactory.getLogger(LoginSteps.class);
        driver.get(page);
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        logger.info("Starting scenario");
        login.clearFields();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();
        logger.info("Scenario completed");
    }

    @Then("I see an error message {string}")
    public void iSeeAnErrorMessage(String expectedMessage) {
        logger.info("Error message is here?");
        String actualMessage = login.getErrorMessage();
        MatcherAssert.assertThat("Error message mismatch!", actualMessage, Matchers.containsString(expectedMessage));
    }

    @Then("I see the dashboard title {string}")
    public void iSeeTheDashboardTitle(String expectedTitle) {
        logger.info("Dashboard title is correct?");
        String actualTitle = dashboard.getDashboardTitle();
        MatcherAssert.assertThat("Dashboard title mismatch!", actualTitle, Matchers.containsString(expectedTitle));
    }
    @AfterAll
    public static void iCloseBrowser() {
        driver.quit();
    }
}
