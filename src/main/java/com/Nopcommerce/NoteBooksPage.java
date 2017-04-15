package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Lenovo on 14/04/2017.
 */
public class NoteBooksPage extends Utils {

    public void sortNotebooksPageProductAtoZ()
    {
        productSortBy("Name: A to Z");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='products-orderby']/option[2]")).isSelected(),"Position A to Z is not selected");

    }

    public void displayNoOfProductOnPage()
    {
        displayNoOfItemPerPage(3);
    }
}
