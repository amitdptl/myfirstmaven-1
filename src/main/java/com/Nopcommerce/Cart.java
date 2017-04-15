package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

/**
 * Created by Lenovo on 13/04/2017.
 */
public class Cart extends Utils {

    public void fillingDetailAtCartAndClickContinue()
    {
        SoftAssert softAssert = new SoftAssert();

        //assert to check whether user is on Cart page
        softAssert.assertEquals(getText(By.cssSelector("h1")),"Shopping cart","You are not on Cart page");

        //selecting country
        selectText(By.id("CountryId"),"United States");

        //selecting states
        selectValue(By.xpath("//select[@id='StateProvinceId']"),"3");

        //click on agreement term and condition
        waitUntilElementToBeClickable(By.xpath("//div[@class='cart-footer']/div[2]/div[3]/input"),3);
        clickOnElement(By.xpath("//div[@class='cart-footer']/div[2]/div[3]/input"));

        //click on checkout
        clickOnElement(By.id("checkout"));

        softAssert.assertAll();
    }

    public double totalOfThreeCellPhonePriceAtCart()
    {
        double totalPriceAtShoppingCart = separatingCurrencySignFromPrice(By.xpath("//div/div[2]/div/table/tbody/tr[4]/td/span/strong"));
        return totalPriceAtShoppingCart;
    }
}
