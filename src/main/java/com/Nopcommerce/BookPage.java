package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by Lenovo on 08/04/2017.
 */
public class BookPage extends Utils{

    public void bookClickOnFahrenheit451ByRayBradbury()
    {

        //assert to check we are on book page,
        assertByGetText(By.cssSelector("h1"),"Books","You are not on Book page");

        //click on book Fahrenheit 451 By Ray Bradbury under book page
        clickOnElement(By.xpath("//div/div[.//a[contains(text(),'Fahrenheit 451 by Ray Bradbury')]]/div/div[2]/h2/a"));

    }
}
