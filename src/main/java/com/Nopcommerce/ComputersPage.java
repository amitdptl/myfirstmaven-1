package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by Lenovo on 14/04/2017.
 */
public class ComputersPage extends Utils{

    public void clickOnNotebooks()
    {
        //click on Notebooks under computer page
        clickOnElement(By.xpath("//img[@alt='Picture for category Notebooks']"));
        //verify user should navigate to Notebooks page
        assertByGetText(By.cssSelector("h1"),"Notebooks","User is not navigated to Notebooks Page");
    }
}
