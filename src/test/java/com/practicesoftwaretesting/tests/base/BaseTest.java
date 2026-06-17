package com.practicesoftwaretesting.tests.base;

import com.practicesoftwaretesting.automation.config.ConfigReader;
import com.practicesoftwaretesting.automation.driver.DriverFactory;
import com.practicesoftwaretesting.automation.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        String browser = ConfigReader.get("browser");

        driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
