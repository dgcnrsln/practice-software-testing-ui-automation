package com.practicesoftwaretesting.automation.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis =
                    new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Config file not found");
        }
    }

    public static String get(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }
}
