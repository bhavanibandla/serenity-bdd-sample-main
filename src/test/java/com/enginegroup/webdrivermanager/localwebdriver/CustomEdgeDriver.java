package com.enginegroup.webdrivermanager.localwebdriver;

import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CustomEdgeDriver {
    public CustomEdgeDriver() {
        this.setupClass();
    }

    public void setupClass() {
        EdgeDriverManager.edgedriver().setup();
    }

    public WebDriver driverClass() {
        return new EdgeDriver();
    }
}
