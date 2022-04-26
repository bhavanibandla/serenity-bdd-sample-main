package com.enginegroup.webdrivermanager.localwebdriver;

import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomFirefoxDriver {
    public CustomFirefoxDriver() {
        this.setupClass();
    }
    public void setupClass() {
        FirefoxDriverManager.firefoxdriver().setup();
    }

    public WebDriver driverClass() {
        return new FirefoxDriver();
    }
}
