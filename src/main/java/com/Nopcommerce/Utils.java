package com.Nopcommerce;
import com.google.common.collect.Ordering;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Lenovo on 08/04/2017.
 */
public class Utils extends BasePage {

    //send/type any data after clearing field/box
    public static void typeTextWithClearing(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //send/type any data without clearing field/box
    public static void typeTextWithoutClearing(By by, String text) {
        driver.findElement(by).sendKeys();
    }

    //click on any element
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //method to sleep the process any any point in web page
    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //drop down selection by visible text
    public static void selectText(By by, String text) {
        new Select(driver.findElement(by)).selectByVisibleText(text); //nameless Select object
    }

    //drop down selection by value
    public static void selectValue(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    //drop down selection by index number
    public static void selectIndex(By by, int indexNumber) {
        new Select(driver.findElement(by)).deselectByIndex(indexNumber);
    }

    //close browser after running test
    public static void closeBrowser() {
        driver.close();
    }

    //close browser after running test
    public static void quiteBrowser() {
        driver.quit();
    }

    //explicit wait method wait until presence of element located
    public static void waitUntilElementToBePresent(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //explicit wait method wait until element to be clickable
    public static void waitUntilElementToBeClickable(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //explicit wait method wait until element visibility located
    public static void wait(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //explicit wait method wait until element get selected
    public static void waitUntilElementToBeSelected(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    //explicit wait method wait until located element will be invisible
    public static void waitUntilInvisibilityofElementLocated(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //explicit wait method, wait until located text will be invisible
    public static void waitUntilTextGetInvisible(By by, int seconds, String text) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(by, text));
    }

    //get text from any locator
    public static String getText(By by) {
        String text = driver.findElement(by).getText();
        return text;
    }

    //get text by attribute
    public static String getTextByAttribute(By by, String attributeName) {
        String text = driver.findElement(by).getAttribute(attributeName);
        return text;
    }

    //drop down selection by attribute if "select" class is not available
    public static void dropDownSelectionByAttribute(By by, String attribute, String dropDownText) {
        List<WebElement> size_menu = driver.findElements(by);

        for (WebElement element : size_menu) {
            String innerText = element.getAttribute(attribute);
            if (innerText.contentEquals(dropDownText)) {
                element.click();
                break;
            }
        }
    }

    //date stamp
    public static String dateStamp() {
        DateFormat dateFormat = new SimpleDateFormat("ddmmhhss");
        Date date = new Date();
        String a = dateFormat.format(date);
        return a;
    }

    //browser print screen / screen shot
    public static void printWebPage(String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + "\\photo" + dateStamp() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //print screen
    public static void printScreen(String photoFilePath) {
        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenShot, "JPG", new File(photoFilePath + "\\photo" + dateStamp() + ".jpg"));
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //random number
    public static int randomNumbers(int numberRange) {
        Random random = new Random();
        int number = random.nextInt(numberRange);
        return number;
    }

    //mouse hover on any element
    public static void mouseHover(By by) {
        Actions action = new Actions(driver);
        WebElement mouse = driver.findElement(by);
        action.moveToElement(mouse).build().perform();
    }

    //assertion by getting text from web location
    public static void assertByGetText(By by, String expectedText, String errorMessage) {
        Assert.assertEquals(getText(by),expectedText,errorMessage);
    }

    //assertion by getting attribute value from web location
    public static void assertByGetTextByAttribute( By by,String attributeName,String expectedText, String errorMessage) {
        Assert.assertEquals(getTextByAttribute(by, attributeName), expectedText,errorMessage);
    }

    //assertion by string variables
    public static void assertByStringVariable(String actualText, String expectedText, String errorMessage) {
        Assert.assertEquals(actualText, expectedText, errorMessage);
    }

    //Reusable boolean method for verifying if element is present
    public static boolean isElementPresent(By by)
    {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //Reusable method for waiting for Element to be present
    public static void waitUntilElementToBePresent(By by)
    {
        int counter =0;
        while (counter <= 10)
        {
            try{
                if(driver.findElement(by).isDisplayed()){
                    counter++;
                    System.out.println("Waiting for a Second......");
                    sleep(1);
                }else {
                    return;
                }
            }catch (Exception e){
                return;
            }
        }
    }

    /*this is reusable method is to assert/verify in any test without stopping programme even if assert fail.
    it will display error message after executing whole test.*/
    public static void verifyByGetText(By by,String expectedText,String errorMessage)
    {
        try {
            Assert.assertEquals(driver.findElement(by).getText(),expectedText,errorMessage);
        } catch (Error e) {
            System.out.println(e);
        }
    }

    /*this is reusable method is to assert/verify in any test without stopping programme if assert fail.
    it will display error message after executing whole test.*/
    public static void verifyByGetTextByAttribute(By by,String attributeName,String expectedText,String errorMessage)
    {
        try {
            Assert.assertEquals(driver.findElement(by).getAttribute(attributeName),expectedText,errorMessage);
        } catch (Error e) {
            System.out.println(e);
        }
    }

    /*this is reusable method is to assert/verify in any test without stopping programme if assert fail.
    it will display error message after executing whole test.*/
    public static void verifyByStringVariableValue(String actualText, String expectedText,String errorMessage)
    {
        try {
            Assert.assertEquals(actualText,expectedText,errorMessage);
        } catch (Error e) {
            System.out.println(e);
        }

    }


    //refresh the webpage
    public static void refreshWebPage()
    {
        driver.navigate().refresh();
    }

    //product sort by on any product page
    public static void productSortBy(String sortBy)
    {
        if(sortBy.equalsIgnoreCase("Name: A to Z"))
        {
            selectText(By.id("products-orderby"),"Name: A to Z");

        }else if (sortBy.equalsIgnoreCase("Name: Z to A"))
        {
            selectText(By.id("products-orderby"),"Name: Z to A");

        }else if (sortBy.equalsIgnoreCase("Price: Low to High"))
        {
            selectText(By.id("products-orderby"),"Price: Low to High");

        }else if (sortBy.equalsIgnoreCase("Price: High to Low"))
        {
            selectText(By.id("products-orderby"),"Price: High to Low");

        }else if (sortBy.equalsIgnoreCase("Created on"))
        {
            selectText(By.id("products-orderby"),"Created on");
        }
    }

    //Reusable method to display certain number of product on the page
    public static void displayNoOfItemPerPage(int numberOfItemPerPage)
    {
        if(numberOfItemPerPage==3)
        {
            selectText(By.id("products-pagesize"),"3");
        }else if(numberOfItemPerPage==6)
        {
            selectText(By.id("products-pagesize"),"6");
        }else if(numberOfItemPerPage==9)
        {
            selectText(By.id("products-pagesize"),"9");
        }
    }

    //Reusable method for to check whether product is in Ascending order OR Low to High Price, answer will get in true Or False
    public static boolean ascendingOrLowToHigh(By by)
    {
        List<WebElement> productsNames_WebElement = driver.findElements(by);

        List<String> product_names = new ArrayList<String>();

        for (WebElement e :productsNames_WebElement) {
            String s = e.getText();
            // System.out.println(s);
            product_names.add(s);
            // System.out.println(product_names);
        }
        boolean isSorted = Ordering.natural().isOrdered(product_names);
        return isSorted;
    }

    //Reusable method for to check whether product is in Descending order OR  High  to Low Price,
    // answer will get in true Or False
    public static boolean descendingOrderOrHighToLow(By by)
    {
        List<WebElement> productsNames_WebElement = driver.findElements(by);

        List<String> product_names = new ArrayList<String>();

        for (WebElement e :productsNames_WebElement) {
            String s = e.getText();
            // System.out.println(s);
            product_names.add(s);
            // System.out.println(product_names);
        }
        boolean isSorted = !Ordering.natural().isOrdered(product_names);
        return isSorted;
    }

    //Reusable method to separate currency symbol from price and convert price in double
    public static double separatingCurrencySignFromPrice(By by) {
        //taking price of the product
        String firstPhonePrice = getText(by);
        //Converting price from string to Integer due to $ sing next to price.
        StringBuilder firstPhoneValue = new StringBuilder();
        StringBuilder currencySymbol = new StringBuilder();
        for (char a : firstPhonePrice.toCharArray()) {
            if (Character.isDigit(a) || a == '.') {
                firstPhoneValue.append(a);
            } else {
                currencySymbol.append(a);
            }
        }
        String a1 = firstPhoneValue.toString();
        //price in double without currency symbol
        double result = Double.parseDouble(a1);
        return result;
    }

    //Reusable method to separate currency symbol from price and
    public static String separatingCurrencySymbol(By by) {
        //taking price of the product
        String firstPhonePrice = getText(by);
        //separating $sign and price digits.
        StringBuilder firstPhoneValue = new StringBuilder();
        StringBuilder currencySymbol = new StringBuilder();
        for (char a : firstPhonePrice.toCharArray()) {
            if (Character.isDigit(a) || a == '.') {
                firstPhoneValue.append(a);
            } else {
                currencySymbol.append(a);
            }
        }
        String a1 = firstPhoneValue.toString();
        return a1;
    }


    public String Euro()
    {
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
            //System.out.println(a1);
            if(a1.equalsIgnoreCase("$"))
            {
                a2="$";
            }
        }
        return a2;
    }

//    //Reusable method to scroll page not working
//    public static void scrollDownPage(String scroll, String object)
//    {
//        JavascriptExecutor jse = (JavascriptExecutor).driver;
//        jse.executeScript(scroll,object);
//        //((JavascriptExecutor)driver).executeScript("scroll(x,y)");
//    }

}

