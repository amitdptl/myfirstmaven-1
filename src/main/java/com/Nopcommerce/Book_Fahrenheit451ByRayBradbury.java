package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

/**
 * Created by Lenovo on 11/04/2017.
 */
public class Book_Fahrenheit451ByRayBradbury extends Utils {

    public void fahrenheit451ByRayBradburyBookAddToWishListAndChangeQuantity()
    {

        SoftAssert softAssert = new SoftAssert();

//        driver.navigate().refresh();

        //adding "Fahrenheit 451 by Ray Bradbury" book in wish list
        clickOnElement(By.id("add-to-wishlist-button-37"));

        //verifying message from top bar to expected vs actual wish list message and close the message
        softAssert.assertEquals(getText(By.className("content")),"The product has been added to your wishlist","your product is not added to wish list");

        //close the notification green bar after adding product in wish list
        driver.findElement(By.className("close")).click();

        refreshWebPage();

        //changing quantity of the product
        typeTextWithClearing(By.id("addtocart_37_EnteredQuantity"),"4");

        //adding "Fahrenheit 451 by Ray Bradbury" book in the cart
        clickOnElement(By.xpath("//input[@id='add-to-cart-button-37']"));

        //click on "shopping cart" from top bar green message
        clickOnElement(By.linkText("shopping cart"));

        softAssert.assertAll();
    }
}
