package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by Lenovo on 08/04/2017.
 */
public class RegistrationPage extends Utils {

    static String email;

    public void userFillingRegistrationDetail()
    {
        //filling registration form detail for to register a user on demoNopCommerce Website
        clickOnElement(By.id("gender-male"));
        typeText(By.id("FirstName"),"Prekesh");
        typeText(By.id("LastName"),"narula");

        //creating email address with date stamp to make unique email address every time
        email ="pnarul"+dateStamp()+"@yahoo.com";
        typeText(By.id("Email"),email);

        //creating user name
        typeText(By.id("Company"),"yogiraj");
        //password for user name
        typeText(By.id("Password"),"Prakash1");
        typeText(By.id("ConfirmPassword"),"Prakash1");

        //click on registration button after filling all required details
        clickOnElement(By.id("register-button"));
    }

    public static void logOut()

    {
        clickOnElement(By.className("ico-logout"));
    }

}
