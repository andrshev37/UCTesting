package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    private final WebDriver driver;

    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//*[@id='login_button_container']");

    // Constructor
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clearFields() {
        driver.findElement(usernameField).clear();
        driver.findElement(passwordField).clear();
        driver.findElement(usernameField).sendKeys("");
        driver.findElement(passwordField).sendKeys("");
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
