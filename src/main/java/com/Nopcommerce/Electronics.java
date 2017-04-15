package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by Lenovo on 14/04/2017.
 */
public class Electronics extends Utils{

    public void clickOnCellPhoneLeftSideMenuElectronicsPage()
    {
        //click on Cell-phone from left side list menu
        clickOnElement(By.xpath("//div/div/div[2]/ul/li[2]/ul/li[2]/a"));
    }
}
