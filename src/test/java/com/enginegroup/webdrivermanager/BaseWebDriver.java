package com.enginegroup.webdrivermanager;

import com.enginegroup.webdrivermanager.localwebdriver.CustomChromeDriver;
import com.enginegroup.webdrivermanager.localwebdriver.CustomEdgeDriver;
import com.enginegroup.webdrivermanager.localwebdriver.CustomFirefoxDriver;
import com.enginegroup.webdrivermanager.localwebdriver.CustomSafariDriver;
import com.enginegroup.webdrivermanager.remotewebdriver.RemoteLambdaTestDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseWebDriver implements DriverSource {
    public static WebDriver driver;
    public static CustomChromeDriver customChromeDriver = new CustomChromeDriver();
    public static CustomFirefoxDriver customFirefoxDriver = new CustomFirefoxDriver();
    public static CustomEdgeDriver customEdgeDriver = new CustomEdgeDriver();

    public static CustomSafariDriver customSafariDriver = new CustomSafariDriver();
    public static RemoteLambdaTestDriver ltRemoteDriver = new RemoteLambdaTestDriver();

    public WebDriver newDriver() {
        String browserName = System.getProperty("browser");
        System.out.println("Test Runs on local: " + browserName + " browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.out.println("Test Runs on local: " + browserName + " browser");
            driver = customChromeDriver.driverClass();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("Test Runs on local: " + browserName + " browser");
            driver = customFirefoxDriver.driverClass();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("Test Runs on local: " + browserName + " browser");
            driver = customEdgeDriver.driverClass();
        } else if (browserName.equalsIgnoreCase("safari")) {
            System.out.println("Test Runs on local: " + browserName + " browser");
            try {
                driver = customSafariDriver.driverClass();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Test Runs on lambdatest: " + browserName + " browser");
            driver = ltRemoteDriver.newDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
