package com.enginegroup.accelarators.pages;

import net.thucydides.core.pages.PageObject;

import static com.enginegroup.accelarators.pages.LoginPage.page;

public class LogoutPage extends PageObject {

    public void clickBurgerMenuAndVerifyLogoutLink() {
        element(WebpageElements.burgerMenuXpath).waitUntilClickable();
//        element(WebpageElements.burgerMenuXpath).click();
        page.waitUntilElementIsClickable("#react-burger-menu-btn");
        waitForElement();
//        element(WebpageElements.logoutXpath).waitUntilClickable();
    }

    public void clickLogoutLink() {
//        element(WebpageElements.logoutXpath).click();
        page.waitUntilElementIsClickable("#logout_sidebar_link");
        page.assertCurrentPageUrl("");
    }
}
