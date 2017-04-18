package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Lenovo on 08/04/2017.
 */
public class HomePage extends Utils {

    public void changeCurrencyToEuro()
    {

        selectText(By.xpath("//select[@id='customerCurrency']"),"Euro");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='customerCurrency']/option[2]")).isSelected(),"yes");
    }

    public void clickOnRegistration()
    {
        //click on register button on home page from top right corner.
        clickOnElement(By.xpath("//div[@class='header']/div/div[2]/div/ul/li/a"));
        //verify if user is navigate to registering page
        Assert.assertEquals(getText(By.xpath("//form/div/div[2]/div[1]/div[1]/strong")),"Your Personal Details","You are not on registering page");
    }

    public void clickOnLogIn()
    {
        //click on Login button from homepage
        clickOnElement(By.linkText("Log in"));
       assertByGetText(By.xpath("//div/div/div/div[1]/h1"),"Welcome, Please Sign In!", "You are not on Login page");
    }

    public void goToShoppingCartFromTopRightCorner()
    {
        //go to shopping cart from Home page top right corner.
        mouseHover(By.cssSelector("span.cart-label"));
        clickOnElement(By.cssSelector("input.button-1.cart-button"));
        //verify is user navigate to shopping cart page
        assertByGetText(By.className("page-title"),"Shopping cart","User is not navigated to Shopping cart");
    }

    public void logOut()

    {
        clickOnElement(By.className("ico-logout"));
    }

    public void clickOnApparel()
    {
        //click on Apparel
        clickOnElement(By.xpath("//a[@href='/apparel']"));
        verifyByGetText(By.xpath("//div[2]/div/div[1]/h1"),"Apparel","You may be not on Apparel page");
    }

    public void clickVirtualGiftCard$25AddingToCart()
    {
        //click on add to cart under $25 virtual gift card on Home page
        clickOnElement(By.xpath("//div[@class='item-grid']/div[4]/div/div[2]/div[3]/div[2]/input"));
    }

    public void clickOnBookDepartment()
    {
        //click on Book Home page menu
        clickOnElement(By.xpath("//a[@href='/books']"));
    }

    public void clickOnComputerDepartment()
    {
        //click on computers from home page top menu bar
        clickOnElement(By.linkText("Computers"));
        //checking whether user is navigated to computers page?
        assertByGetText(By.xpath("//div/div[1]/h1"),"Computers","User is not navigate to Computers page");
    }

    public void clickOnElectronics()
    {
        //click on Electronic  in Home page from top menu bar
        clickOnElement(By.xpath("//a[@href='/electronics']"));
        //verify that User is navigated to Electronics page
        assertByGetText(By.cssSelector("h1"),"Electronics","User is not navigated to Electronics page");
    }

    public void clickOnJewelry()
    {
        //click on Jewelry  in Home page from top menu bar
        clickOnElement(By.xpath("//a[@href='/jewelry']"));
        //verify that User is navigated to Electronics page
        assertByGetText(By.cssSelector("h1"),"Jewelry","User is not navigated to Jewelry page");

    }
}
