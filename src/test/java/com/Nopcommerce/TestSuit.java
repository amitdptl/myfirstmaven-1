package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Lenovo on 08/04/2017.
 */
public class TestSuit extends BaseTest{

    //objects for all the class to call the method's of particular class with object names.
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    BookPage bookPage = new BookPage();
    Clothing clothing = new Clothing();
    LogInPage logInPage = new LogInPage();
    $25VirtualGiftCard $25virtualGiftCard = new $25VirtualGiftCard();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    Book_Fahrenheit451ByRayBradbury book_fahrenheit451ByRayBradbury = new Book_Fahrenheit451ByRayBradbury();
    CheckOutPageShippingAndPaymentDetail checkOutPageShippingAndPaymentDetail = new CheckOutPageShippingAndPaymentDetail();
    Cart cart = new Cart();
    Utils utils = new Utils();
    ComputersPage computersPage = new ComputersPage();
    NoteBooksPage noteBooksPage = new NoteBooksPage();
    Electronics electronics = new Electronics();
    CellPhones cellPhones = new CellPhones();
    Apparel apparel = new Apparel();

    @Test
    public void userShouldRegisterSuccessful()
    {
        homePage.clickOnRegistration();

        //filling registration detail
        registrationPage.userFillingRegistrationDetail();

        //assert to check whether registration is completed successfully
        utils.assertByGetText( By.className("result"),"Your registration completed","User is not registered Successfully");

    }
    @Test
    public void userShouldLogInSuccessful()
    {
        //login with registered email address,  registering and checking whether user is able to login with same email.
        logInPage.logInDemoNopCommerce();

        //verifying whether user is login successfully
        utils.assertByGetTextByAttribute(By.id("FirstName"),"value","Prekesh","User is not login");
    }

    @Test
    public void apparelDepartmentTwoProductAddToComparisionFromClothing()
    {
        //click on apparel from Home page at department menu
        homePage.clickOnApparel();

        //click on Clothing from Apparel page left side menu
        apparel.clickOnClothingFromLeftSideMenu();

        /*adding two product in comparision basket from clothing section, taking two print screen before adding and after adding to compare basket
        and click on compare basket, clear the basket after check whether that products are in compare basket*/
        clothing.apparelClothingAddingTwoItemInComparision();

        //assert to check is compare basket is empty?, after comparing product
        utils.assertByGetText(By.className("no-data"),"You have no items to compare.","may be compare basket is not Empty");
    }

    @Test
    public void userShouldBeAbleToAdd$25VirtualGiftCardInCartAndEmailToFriend() {
        //registering to email address for to check following functionality check
        $25virtualGiftCard.registrationToGetEmailAddressFor$25VirtualGiftCardEmailToFriend();

        //click on $25 Virtual Gift card from home page
        homePage.clickVirtualGiftCard$25AddingToCart();

        //filling all required detail, add to cart and click on Email a friend link
        $25virtualGiftCard.$25VirtualGiftCardAddingToCardAndClickEmailToFriend();

        //filling friend's detail, personal message and click on send.
        emailAFriendPage.fillingFriendEmailAndPersonalMessageFor$25VirtualGiftCard();

        //assertion to check whether email sent successfully to friend after adding to cart.
        utils.assertByGetTextByAttribute(By.className("result"), "innerText", "Your message has been sent.", "Email not sent");
    }

    @Test
    public void book_Fahrenheit451ByRayBradburyCheckOutAsGuestAndMakingMasterCardPayment()
     {
         //click on Book from home page
         homePage.clickOnBookDepartment();

         //click on book name:"Fahrenheit 451 by Ray Bradbury"
         bookPage.bookClickOnFahrenheit451ByRayBradbury();

         //This book add in  to wish list, change the quantity to 4, click on add to cart and click on "shopping cart" from green notification bar
         book_fahrenheit451ByRayBradbury.fahrenheit451ByRayBradburyBookAddToWishListAndChangeQuantity();

         //At cart page selecting country and state, click on terms and click on CHECKOUT
         cart.fillingDetailAtCartAndClickContinue();

         //click on checkout as guest from Login page
         logInPage.checkOutAsGuest();

         //filling checkout detail, shipping address, payment method, payment detail and click on confirm.
         checkOutPageShippingAndPaymentDetail.fillingBillingShippingAndPaymentDetailForCheckOut();

         //assertion order confirmation message
         utils.assertByGetText(By.xpath("//div[@class='master-wrapper-page']/div[3]/div/div/div/div[2]/div/div/strong"),"Your order has been successfully processed!",
                 "order is not confirmed or there is an error");
     }

    @Test
    public void cellPhonesAddingToCartAndAssertTotalPriceAtCheckOut()
    {
        //click on electronics from home page
        homePage.clickOnElectronics();

        //click on cell phone under Electronic page left side menu
        electronics.clickOnCellPhoneLeftSideMenuElectronicsPage();

        //storing all three cell phone price
        double totalPriceOfThreeCellPhone = cellPhones.totalPriceOfThreeCellPhone();

        //adding all cell phones in the cart
        cellPhones.addingThreeCellPhoneInTheCart();

        //taking total price from cart
        double totalOfThreeCellPhoneAtShoppingCart = cart.totalOfThreeCellPhonePriceAtCart();

        //verify Total of three cell phone price and price at cart are matching?
        Assert.assertTrue(totalOfThreeCellPhoneAtShoppingCart==totalPriceOfThreeCellPhone,"Total price at Shopping cart is not matching");

        //filling required detail at cart and continue to check out
        cart.fillingDetailAtCartAndClickContinue();

        //click on checkout as guest
        logInPage.checkOutAsGuest();

        //filling all check out detail, billing&shipping address, payment detail and place an order
        checkOutPageShippingAndPaymentDetail.fillingBillingShippingAndPaymentDetailForCheckOut();

        //verifying order confirmation message
        utils.assertByGetText(By.xpath("//div[@class='master-wrapper-page']/div[3]/div/div/div/div[2]/div/div/strong"),
                                "Your order has been successfully processed!",
                                "order is not confirmed or there is an error");
    }

    @Test
    public void userShouldAbleToSortProductOfNotebooksPageAtoZ()
    {
        //click on computer department from Top menu bar on Home page
        homePage.clickOnComputerDepartment();

        //click on Notebooks on computer page
        computersPage.clickOnNotebooks();

        //sort by product A to Z
        noteBooksPage.sortNotebooksPageProductAtoZ();

        //verify that product is sort on A to Z order.
        Assert.assertTrue(utils.ascendingOrLowToHigh(By.xpath("//div[@class='item-grid']/div/div/div[2]/h2")),"product is not sorted");

    }




}
