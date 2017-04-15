package com.Nopcommerce;

import org.openqa.selenium.By;


/**
 * Created by Lenovo on 11/04/2017.
 */
public class EmailAFriendPage extends Utils {

    public void fillingFriendEmailAndPersonalMessageFor$25VirtualGiftCard()
    {

        //verify/assert by checking we are on right page
        verifyByGetText(By.cssSelector("h1"),"Email a friend","You are not on Email a friend page");
        //filling email a friend detail
        typeText(By.id("FriendEmail"),"pnarol19132831@yahoo.com");
        //personal message
        typeText(By.id("PersonalMessage"),"Gift for you.");

        //click on send email to friend
        clickOnElement(By.xpath("//input[@class='button-1 send-email-a-friend-button']"));
    }
}
