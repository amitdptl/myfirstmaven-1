package com.Nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lenovo on 14/04/2017.
 */
public class Rough {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.nopcommerce.com/notebooks");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     // new Select(driver.findElement(By.xpath("//select[@id='customerCurrency']"))).selectByVisibleText("Euro");

        List<WebElement> productsNames_WebElement = driver.findElements(By.xpath("//div[@class='item-grid']//span"));
        List<String> product_Price = new ArrayList<String>();
        for (WebElement e :productsNames_WebElement) {
            String s = e.getText();
            product_Price.add(s);
        }

        String a2="€";
        for (String  e: product_Price){
            StringBuilder currencySymbol = new StringBuilder();
            for (char a : e.toCharArray()) {
                if(a=='€' || a=='$')
                {
                    currencySymbol.append(a);
                }
            }
            String a1 = currencySymbol.toString();
            System.out.println(a1);
            if(a1.equalsIgnoreCase("$"))
            {
                a2="$";
            }
        }
        Assert.assertTrue(a2.equals("€"));

        //_________________________________________________________________________________________________________________
//
//        //16/04/17
//        List<WebElement> productsNames_WebElement = driver.findElements(By.xpath("//div[@class='item-grid']//span"));
//
//        List<String> product_Price = new ArrayList<String>();
//        List<String> truefalse = new ArrayList<String>();
//
//        for (WebElement e :productsNames_WebElement) {
//            String s = e.getText();
//            // System.out.println(s);
//            product_Price.add(s);
//             System.out.println(product_Price);
//        }
//
//        String a2="",a3="€";
//        for (String  e: product_Price){
//            StringBuilder firstPhoneValue = new StringBuilder();
//            StringBuilder currencySymbol = new StringBuilder();
//            for (char a : e.toCharArray()) {
//                if (Character.isDigit(a) || a == '.' || Character.isLetter(a) || a==',') {
//                    firstPhoneValue.append(a);
//                } else {
//                    currencySymbol.append(a);
//                }
//            }
//            String a1 = currencySymbol.toString();
//            if(a1.equalsIgnoreCase(" €"))
//            {a1="$";}
//
////            System.out.println(a1);
//            if(a1.equalsIgnoreCase("€") || a1.equalsIgnoreCase(" €"))
//            {
//
//                a2="€";
//              // truefalse.add(a2);
//
//            }else {
//                a3="$";
//             //  truefalse.add(a3);
//            }
//        }
//
////        if(a2.equalsIgnoreCase("true") && a3.equalsIgnoreCase("true"))
////        {
////            System.out.println("pass");
////        }else {
////            System.out.println("failed");
////        }
//
////        System.out.println(a3);
////        System.out.println(truefalse);
//        Assert.assertTrue(a3.equals("€"));
//       // Assert.assertTrue(truefalse.containsAll("true"));
//
////____________________________________________________________________________________________________________________


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