package org.example;
//package org.junit.jupiter.api;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class UCTest {
    private static final Logger logger = LoggerFactory.getLogger(UCTest.class);
    private static final WebDriver driver = WebDriverSingleton.getDriver();


    @BeforeAll
    public static void setup() {
        driver.get("https://www.saucedemo.com/");

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
    final WebElement usernameField = driver.findElement(By.id("user-name"));
    final WebElement passwordField = driver.findElement(By.id("password"));
    final WebElement loginButton = driver.findElement(By.id("login-button"));
    public void clearCredentials() {

        usernameField.clear();
        passwordField.clear();
    }
    public void enterCredentials(String username, String password) {

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }
    public String getErrorMessage() {
        //WebElement errorMessage = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]"));
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='login_button_container']"));

        return errorMessage.getText();
    }

    private String getDashboardText() {
        WebElement dashboard = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div"));
        return dashboard.getText();
    }

    @Test
    public void UC1Test(){
        //setup();
        logger.info("Starting UC1");
        enterCredentials("1", "1" );
        clearCredentials();
        loginButton.click();
        String errorMessage = getErrorMessage();
        MatcherAssert.assertThat("UC1: Error message should match 'Username is required'",
                errorMessage, Matchers.containsString("Username is required"));
        logger.info("UC1 completed.");
    }
    @Test
    public void UC2Test() {
        //setup();
        logger.info("Starting UC2");
        clearCredentials();
        enterCredentials("1", "");
        loginButton.click();
        String errorMessage = getErrorMessage();
        MatcherAssert.assertThat("UC2: Error message should match 'Password is required'",
                errorMessage, Matchers.containsString("Password is required"));
        logger.info("UC2 completed.");
    }

    @Test
    public void UC3Test() {
        logger.info("Starting UC3");
        clearCredentials();
        enterCredentials("performance_glitch_user", "secret_sauce");
        loginButton.click();
        String dashboardText = getDashboardText();
        MatcherAssert.assertThat("UC3: Dashboard title should match 'Swag Labs'",
                dashboardText, Matchers.containsString("Swag Labs"));
        logger.info("UC3 completed.");
    }
}
