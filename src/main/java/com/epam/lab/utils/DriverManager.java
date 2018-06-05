package com.epam.lab.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.lab.utils.ConfigProperties.getTestProperty;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        System.setProperty(getTestProperty("driverType"), getTestProperty("driverPath"));
        return new ChromeDriver();
    });

    private DriverManager() {
    }

    public static void load(String URL) {
        getDriver().get(URL);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void removeDriver() {
        driver.get().quit();
        driver.remove();
    }

    public static WebDriverWait newWait() {
        return new WebDriverWait(getDriver(), 15);
    }
}