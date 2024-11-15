package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
    private final WebDriver driver;

    // Locator
    private final By dashboardTitle = By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div");

    // Constructor
    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public String getDashboardTitle() {
        return driver.findElement(dashboardTitle).getText();
    }
}
