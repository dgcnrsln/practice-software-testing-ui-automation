package com.practicesoftwaretesting.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;

public class DriverFactory {

    public static WebDriver createDriver(String browserName) {

        BrowserType browser = BrowserType.valueOf(
                browserName.trim().toUpperCase(Locale.ROOT)
        );

        switch (browser) {

            case CHROME -> {
                ChromeOptions options = new ChromeOptions();

                if (isCI()) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }

                WebDriver driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                return driver;
            }

            case EDGE -> {
                EdgeOptions options = new EdgeOptions();

                if (isCI()) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                }

                WebDriver driver = new EdgeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                return driver;
            }

            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private static boolean isCI() {
        return System.getenv("CI") != null;
    }
}
