package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

/**
 * Created by Lenovo on 13/04/2017.
 */
public class CheckOutPageShippingAndPaymentDetail extends Utils {

  public void fillingBillingShippingAndPaymentDetailForCheckOut()
  {
      SoftAssert softAssert = new SoftAssert();
      //checking is user on checkout page?
      softAssert.assertEquals(getText(By.cssSelector("h1")),"Checkout", "User is not on Checkout page");

      //filling checkout personal detail
      typeTextWithClearing(By.id("BillingNewAddress_FirstName"),"mahesh");
      typeTextWithClearing(By.id("BillingNewAddress_LastName"),"naruda");
      typeTextWithClearing(By.id("BillingNewAddress_Email"),"parish@yahoo.com");
      selectText(By.id("BillingNewAddress_CountryId"),"United Kingdom");
      typeTextWithClearing(By.id("BillingNewAddress_City"),"London");
      typeTextWithClearing(By.id("BillingNewAddress_Address1"),"12 wewetr road");
      typeTextWithClearing(By.id("BillingNewAddress_ZipPostalCode"),"ha91dy");
      typeTextWithClearing(By.id("BillingNewAddress_PhoneNumber"),"02082082084");


      //click on continue at checkout
      clickOnElement(By.xpath("//div[@id='checkout-step-billing']/div/input"));

      //shipping method Ground and continue
      clickOnElement(By.cssSelector("input.button-1.shipping-method-next-step-button"));

      //is there Credit Card payment method available for selection?
      softAssert.assertEquals(getText(By.xpath("//li[2]/div/div[2]/label")),"Credit Card", "User is not on payment method or credit card is not available");

      //selecting payment method by credit card
      clickOnElement(By.id("paymentmethod_1"));
      clickOnElement(By.cssSelector("input.button-1.payment-method-next-step-button"));

      //select Master card and filling master card detail
      selectText(By.id("CreditCardType"),"Master card");
      typeText(By.id("CardholderName"),"manu chagan");
      typeText(By.id("CardNumber"),"5404 0000 0000 0084");
      selectText(By.id("ExpireMonth"),"12");
      selectText(By.id("ExpireYear"),"2018");
      typeText(By.id("CardCode"),"485");

      //continue to next page
      clickOnElement(By.cssSelector("input.button-1.payment-info-next-step-button"));

      //softAssert.assertEquals(getText(By.className("product-name")),"Fahrenheit 451 by Ray Bradbury","expected book is not in the cart or cart is empty");

      //confirming order
      clickOnElement(By.cssSelector("input.button-1.confirm-order-next-step-button"));

      softAssert.assertAll();
  }


}
