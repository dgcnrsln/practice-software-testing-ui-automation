package com.practicesoftwaretesting.tests.smoke;

import com.practicesoftwaretesting.automation.config.ConfigReader;
import com.practicesoftwaretesting.tests.base.BaseTest;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void openSite() {
        driver.get(ConfigReader.get("baseUrl"));
        System.out.println(driver.getTitle());
    }
}
