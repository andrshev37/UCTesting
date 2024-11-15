package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class UCTest {
    private static final Logger logger = LoggerFactory.getLogger(UCTest.class);
    private static final WebDriver driver = WebDriverSingleton.getDriver("edge");
    private static Login loginPage;
    private static Dashboard dashboardPage;

    @BeforeAll
    public static void setup() {

        loginPage = new Login(driver);
        dashboardPage = new Dashboard(driver);
    }
    @BeforeEach
    public void site() {
        driver.get("https://www.saucedemo.com/");
    }
    @AfterAll
    public static void shutdown() {
        driver.quit();
    }

    @Test
    public void UC1Test() {
        logger.info("Starting UC1");

        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clearFields();

        loginPage.clickLogin();
        String errorMessage = loginPage.getErrorMessage();
        MatcherAssert.assertThat("UC1: Error message should match 'Username is required'",
                errorMessage, Matchers.containsString("Username is required"));
        logger.info("UC1 completed.");
    }

    @Test
    public void UC2Test() {
        logger.info("Starting UC2");
        loginPage.clearFields();
        loginPage.enterUsername("1");
        loginPage.enterPassword("");
        loginPage.clickLogin();
        String errorMessage = loginPage.getErrorMessage();
        MatcherAssert.assertThat("UC2: Error message should match 'Password is required'",
                errorMessage, Matchers.containsString("Password is required"));
        logger.info("UC2 completed.");
    }

    @Test
    public void UC3Test() {
        logger.info("Starting UC3");
        loginPage.clearFields();
        loginPage.enterUsername("performance_glitch_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        String dashboardTitle = dashboardPage.getDashboardTitle();
        MatcherAssert.assertThat("UC3: Dashboard title should match 'Swag Labs'",
                dashboardTitle, Matchers.containsString("Swag Labs"));
        logger.info("UC3 completed.");
    }
}
