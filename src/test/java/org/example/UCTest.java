package org.example;

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

    private static final WebElement usernameField = driver.findElement(By.id(Config.usernameField));
    private static final WebElement passwordField = driver.findElement(By.id(Config.passwordField));

    public void clearUsername() {
        usernameField.clear();
        passwordField.clear();
    }
    public void clearPassword() {
        usernameField.clear();
        passwordField.clear();
    }
    public void navigateToLoginPage() {
        driver.get(Config.SITE);
    }
    public void enterCredentials(String username, String password) {

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    public String getErrorMessage() {
        //WebElement errorMessage = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]"));
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]"));

        return errorMessage.getText();
    }

    private String getDashboardText() {
        WebElement dashboard = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div"));
        return dashboard.getText();
    }
    public void UC(String errMsgTask, String errMsgShould, String UCn){
        clickLoginButton();
        String errorMessage = getErrorMessage();

        try {
            MatcherAssert.assertThat(errMsgTask, errorMessage, Matchers.containsString(errMsgShould));
            logger.info(UCn , "{} completed.");
        } catch (AssertionError e) {
            logger.error("{} failed: {}", UCn , e.getMessage());
        }
    }
    public void UC3(String errMsgTask, String errMsgShould){
        clickLoginButton();
        String dashboardText = getDashboardText();
        try {
            MatcherAssert.assertThat(errMsgTask,
                    dashboardText, Matchers.containsString(errMsgShould));
            logger.info("UC3 completed.");
        } catch (AssertionError e) {
            logger.error("UC3 failed: {}" , e.getMessage());
        }
    }
    public void executeTest(String username, String password, String errMsgTask, String errMsgShould, String UCn) {
        logger.info("Starting {}" , UCn);
        navigateToLoginPage();

        enterCredentials(username, password);
        switch (UCn){
            case "UC1": clearUsername();
            case "UC2": clearPassword();UC(errMsgTask,errMsgShould,UCn);
            case "UC3": UC3(errMsgTask,errMsgShould);
        }
    }
}
