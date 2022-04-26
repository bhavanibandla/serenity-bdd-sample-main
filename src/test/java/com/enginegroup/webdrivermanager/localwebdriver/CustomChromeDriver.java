package com.enginegroup.webdrivermanager.localwebdriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomChromeDriver {
    public CustomChromeDriver() {
        this.setupClass();
    }
    public void setupClass() {
        ChromeDriverManager.chromedriver().setup();
    }

    public WebDriver driverClass() {
        return new ChromeDriver();
    }
}
