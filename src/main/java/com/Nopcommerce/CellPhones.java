package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

/**
 * Created by Lenovo on 15/04/2017.
 */
public class CellPhones extends Utils {


    public double totalPriceOfThreeCellPhone()
    {
        SoftAssert softAssert = new SoftAssert();
        //taking first cell phone price and converting it to double to add with other cell phone price
       double firstCellPhonePrice= separatingCurrencySignFromPrice(By.cssSelector("span.price.actual-price"));
        softAssert.assertEquals(firstCellPhonePrice,245.0);

        //taking second cell phone price and converting it to double to add with other cell phone price
       double secondCellPhonePrice = separatingCurrencySignFromPrice(By.xpath("//div[2]/div/div[2]/div[3]/div/span"));
        softAssert.assertEquals(secondCellPhonePrice,100.0);

        //taking third cell phone price and converting it to double to add with other cell phone price
       double thirdCellPhonePrice = separatingCurrencySignFromPrice(By.xpath("//div[3]/div/div[2]/div[3]/div/span"));
        softAssert.assertEquals(thirdCellPhonePrice,349.0);

        //totalling all three cell phone price
       double totalOfCellPhonesPriceAtProductPage = firstCellPhonePrice + secondCellPhonePrice + thirdCellPhonePrice;

       softAssert.assertAll();

       return totalOfCellPhonesPriceAtProductPage;


    }

    public void addingThreeCellPhoneInTheCart() {

        SoftAssert softAssert = new SoftAssert();
        // blank click on the page
        clickOnElement(By.xpath("//div[3]/div/span"));

        //adding first cell phones in cart
        clickOnElement(By.xpath("//input[@value='Add to cart']"));

        //verifying that cellphone added in cart by comparing message
       softAssert.assertEquals("The product has been added to your shopping cart", getText(By.xpath("//body/div[5]/p")));

        //close the green notification bar after adding cellphone in the cart
        driver.findElement(By.className("close")).click();

        refreshWebPage();

        // adding second cell phone in the cart
        clickOnElement(By.xpath("//div[@class='page category-page']/div[2]/div[3]/div/div[2]/div/div[2]/div[3]/div[2]/input"));

        //verifying that cellphone added in cart by comparing message
        softAssert.assertEquals("The product has been added to your shopping cart", getText(By.xpath("//body/div[5]/p")));
        refreshWebPage();

        //adding third cell phone in the cart
        clickOnElement(By.xpath("//div[@class='master-wrapper-content']/div[2]/div[2]/div/div[2]/div[3]/div/div[3]/div/div[2]/div[3]/div[2]/input"));
        //verifying that cellphone added in cart by comparing message
        softAssert.assertEquals("The product has been added to your shopping cart", getText(By.xpath("//body/div[5]/p")));

       refreshWebPage();

        //click on shopping card from top right corner
        new HomePage().goToShoppingCartFromTopRightCorner();
    }



}
