package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by Lenovo on 15/04/2017.
 */
public class Apparel extends Utils {

    public void clickOnClothingFromLeftSideMenu()
    {
        //click on Clothing from left side menu
        clickOnElement(By.xpath("//ul[@class='list']/li[3]/ul//li[2]/a"));
    }

}
