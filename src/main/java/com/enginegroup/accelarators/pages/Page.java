package com.enginegroup.accelarators.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Page extends PageObject {

    public static String baseUrl = "https://www.saucedemo.com";

    public String getCurrentPageUrl() {
        String currentPageUrl = getDriver().getCurrentUrl();
        System.out.println("Current Page URL: " + currentPageUrl);
        return currentPageUrl;
    }

    public List<WebElementFacade> getItemsList() {
        return findAll(WebpageElements.productsCss);
    }

    public void assertCurrentPageUrl(String propertyKey) {
        String expectedUrl = baseUrl + "/" + propertyKey;
        Assert.assertEquals(expectedUrl, this.getCurrentPageUrl());
    }

    public void waitUntilElementIsClickable(String locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
        JavascriptExecutor ex = (JavascriptExecutor) getDriver();
        ex.executeScript("arguments[0].click()", element);
    }
}
