package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getDriver(String browser) {
        if (driver == null) {

            switch (browser.toLowerCase()) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":

                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}
