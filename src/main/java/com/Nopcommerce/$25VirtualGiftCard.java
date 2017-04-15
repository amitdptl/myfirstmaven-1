package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

/**
 * Created by Lenovo on 11/04/2017.
 */
public class $25VirtualGiftCard extends Utils {

    SoftAssert softAssert = new SoftAssert();

    public void  registrationToGetEmailAddressFor$25VirtualGiftCardEmailToFriend()
    {
        /*registering on nop-commerce.com as we can not use "email a friend" functionality unless there is registered user, as we want to check whether
        we can send email a friend $25 Virtual Gift card?*/
        new HomePage().clickOnRegistration();
        new RegistrationPage().userFillingRegistrationDetail();
        clickOnElement(By.xpath("//div[1]/a/img"));
    }

    public void $25VirtualGiftCardAddingToCardAndClickEmailToFriend()
    {

        //soft assert to check whether we are on $25 Virtual Gift card page
        softAssert.assertEquals(getText(By.cssSelector("h1")),"$25 Virtual Gift Card","Looks Like you are not on correct page :");
        //verifyByGetText(By.cssSelector("h1"),"$25 Virtual Gift Card","Looks Like you are not on correct page :");

        //filling the data on product add to card page
        typeTextWithClearing(By.id("giftcard_43_RecipientName"),"prakeshnnn");
        typeTextWithClearing(By.id("giftcard_43_RecipientEmail"),"pnarol19134429@yahoo.com");
        typeText(By.id("giftcard_43_Message"),"Hello Dear,");

        // /click on add to card
        clickOnElement(By.id("add-to-cart-button-43"));
        //close the notification bar after adding to cart
        clickOnElement(By.xpath("//body/div[5]/span"));

        //click on Email a friend
        clickOnElement(By.cssSelector("input.button-2.email-a-friend-button"));

         softAssert.assertAll();

    }
}
