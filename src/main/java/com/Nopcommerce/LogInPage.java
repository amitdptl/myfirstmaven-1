package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by Lenovo on 09/04/2017.
 */
public class LogInPage extends Utils {

    public void logInDemoNopCommerce()
    {
        new HomePage().clickOnRegistration();
        new RegistrationPage().userFillingRegistrationDetail();
        new HomePage().logOut();
        new HomePage().clickOnLogIn();

        //bringing registered email address which from registration page and
        // if not registered then use email address in side "if block"
        String a = RegistrationPage.email;
        if(a==null)
        {
            a="pnarula040417@yahoo.com";
        }

        //Inputting email address under user name field
        typeText(By.id("Email"),a);

        //inputting password
        typeText(By.id("Password"),"Prakash1");

        //click on login button.
        clickOnElement(By.cssSelector("input.button-1.login-button"));

        //click on "My account" after Login from top right menu
        clickOnElement(By.className("ico-account"));
    }

    public void checkOutAsGuest()
    {
        //checking page is user on sign in page? which has option for CHECKOUT AS GUEST
        assertByGetText(By.cssSelector("h1"),"Welcome, Please Sign In!","You are not on Sign In page for to checkout as Guest");

        //click on checkout as guest
        clickOnElement(By.cssSelector("input.button-1.checkout-as-guest-button"));
    }
}
