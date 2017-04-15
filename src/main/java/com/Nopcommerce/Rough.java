package com.Nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lenovo on 14/04/2017.
 */
public class Rough {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.nopcommerce.com/clothing?viewmode=grid");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        Assert.assertTrue(driver.getCurrentUrl().contains("grid"),"you page viewMode is not in list");


//        driver.findElement(By.id("addtocart_37_EnteredQuantity")).clear();
//        driver.findElement(By.id("addtocart_37_EnteredQuantity")).sendKeys("4");

        //adding "Fahrenheit 451 by Ray Bradbury" book in the cart

        //  sleep(5);
//        Utils.waitUntilElementToBeClickable(By.xpath("//input[@id='add-to-cart-button-37']"),10);
     //   driver.findElement(By.xpath("//input[@id='add-to-cart-button-37']")).click();
//
//        //click on "shopping cart" from top bar green message
//        clickOnElement(By.linkText("shopping cart"));


       // List<WebElement> products_Webelement = new LinkedList<WebElement>();


       // List<WebElement> productsNames_WebElement = driver.findElements(By.xpath("//div[@class='item-grid']/div/div/div[2]/h2"));

       // int a = productsNames_WebElement.size();
        //System.out.println(productsNames_WebElement.size());

//        List<String> product_names = new ArrayList<String>();
//
//        for (WebElement e :productsNames_WebElement) {
//            String s = e.getText();
//           // System.out.println(s);
//            product_names.add(s);
//           // System.out.println(product_names);
//        }
//        System.out.println(product_names.);

//        boolean isSorted = (Ordering.natural().isOrdered(product_names));
//         System.out.println(isSorted);
//       // Assert.assertTrue(isSorted,"not sorted");

    }

}

//        for (WebElement e : products_Webelement) {
//
//            System.out.println(e.getText());
//
//        }

//        for (int i = 0; i < productsNames_WebElement.size(); i++) {
//
//            String s= productsNames_WebElement.get(i).getText();
//            product_names.add(s);
//        }