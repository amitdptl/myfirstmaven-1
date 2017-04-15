package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

/**
 * Created by Lenovo on 08/04/2017.
 */
public class Clothing extends Utils {


    public void apparelClothingAddingTwoItemInComparision()  {

        SoftAssert softAssert = new SoftAssert();

        //sorting price Low to high
        selectText(By.id("products-orderby"), "Price: High to Low");

        //verify sorting price High to Low
        softAssert.assertTrue(descendingOrderOrHighToLow(By.xpath("//div[@class='item-grid']//span")),
                "Product is not sorted Hight to Low");

        //Display 3 item per page
        selectText(By.id("products-pagesize"),"3");

        //click on list view
        clickOnElement(By.cssSelector("a.viewmode-icon.list"));

        //verifying product is in list view page
        softAssert.assertTrue(driver.getCurrentUrl().contains("list"));

        //sorting price Low to high
        selectText(By.id("products-orderby"), "Price: Low to High");

        //verify product is in Low to high price order
        softAssert.assertTrue(ascendingOrLowToHigh(By.xpath("//div[@class='item-grid']//span")),"Product is not sorted Price : Low to High");

        //taking print screen after sorting "Price: Low to High"
        printScreen("C:\\Users\\Lenovo\\Desktop\\photos");

        //adding "custom T-Shirt" to comparing list
        clickOnElement(By.xpath("//div/div[.//a[contains(text(),'Custom T-Shirt')]]/div/div[2]/div[3]/div[2]/input[2]"));

        //close green notification bar which displayed when click on custom T-shirt comparision
        waitUntilElementToBePresent(By.className("close"),2);
        clickOnElement(By.className("close"));

        driver.navigate().refresh();
        //adding "Oversized Women T-shirt.
        clickOnElement(By.xpath("//div/div[.//a[contains(text(),'Oversized Women T-Shirt')]]/div/div[2]/div[3]/div[2]/input[2]"));

        //taking print screen after adding in comparision "over sized Women T-shirt" with green notification
        //sleep(3);
        waitUntilElementToBeClickable(By.className("close"),2);
        printScreen("C:\\Users\\Lenovo\\Desktop\\photos");

        //click on "The product has been added to your product comparison"
        clickOnElement(By.xpath("//p/a"));

        //assertion the product name in the compare basket making sure it is same which we have added
        verifyByGetText(By.xpath("//div/table/tbody/tr[3]/td[2]/a"),"Oversized Women T-Shirt","Oversized Women T-Shirt is not in comparision list");

        //assertion the second product name in the compare basket making sure it is same which we have added
        verifyByGetText(By.xpath("//div/table/tbody/tr[3]/td[3]/a"),"Custom T-Shirt","Custom T-Shirt is not in comparision list");

        //clearing the compare product list
        Utils.clickOnElement(By.className("clear-list"));

        softAssert.assertAll();
    }
}
