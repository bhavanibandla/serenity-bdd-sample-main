package com.enginegroup.accelarators.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import static com.enginegroup.accelarators.pages.LoginPage.page;

public class ProductsPage extends PageObject {

    public static String inventoryUrl = "inventory.html";

    public void verifyProductsPagePostLogin() {
        waitForElement();
        $(WebpageElements.pageTextToVerify).waitUntilVisible();
        page.assertCurrentPageUrl(inventoryUrl);
    }

    public void randomlyClicksAddToCartButtonToAddAProductToCart() {
        $(WebpageElements.productsCss).waitUntilVisible();
        for (WebElement element : page.getItemsList()) {
            waitFor(element).isClickable();
            String btnText = element.getText();
            System.out.println("Element text: " + btnText);
            if (!btnText.equalsIgnoreCase("REMOVE")) {
                page.waitUntilElementIsClickable("div.inventory_item_description div.pricebar button");
            }
            String cartText = $(WebpageElements.cartContainerXpath).getText();
            if (cartText != null) {
                System.out.println("Cart Count Number: " + cartText);
                int currentItemCount = Integer.parseInt(cartText);
                if (currentItemCount >= 1) {
                    break;
                } else {
                    System.out.println("No items in the cart!");
                }
            }
        }
        page.assertCurrentPageUrl(inventoryUrl);
    }
}
