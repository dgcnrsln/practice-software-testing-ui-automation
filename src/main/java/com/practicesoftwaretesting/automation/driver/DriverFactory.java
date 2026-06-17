package com.practicesoftwaretesting.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browserName) {

        BrowserType browser = BrowserType.valueOf(browserName.toUpperCase());

        switch (browser) {

            case CHROME:
                return new ChromeDriver();

            case FIREFOX:
                return new FirefoxDriver();

            case EDGE:
                return new EdgeDriver();

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }
}
