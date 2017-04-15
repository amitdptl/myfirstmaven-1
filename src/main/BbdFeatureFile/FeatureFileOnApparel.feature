Feature: Jenny ordering custom T-shirt

  Background: Jenny is already on demo.nopcommerce.com
    And       Jenny has registered account with demo.nopcommerce.com
    And       Jenny is already logged in
    Given      She has valid credit card for payment


      Scenario: Jenny want to add custom T shirt in cart
      Given   Jenny is on Apparel page
      When    she clicked on clothing from left side menu
      And     she selected the custom T-shirt
      And     Jenny add the custom T-shirt in cart
      And     she navigate to shopping card
      Then    She should see custom t-shirt in the cart

     Scenario: Jenny make payment for custom t-shirt
       Given   Jenny has custom T-shirt in the cart
       And     She is on checkout page
       When    She select the country and select the state
       And     she click on term and condition
       And     she filled all required detail and continue payment section
       And     Jenny made the payment with credit card and click on confirm
       Then    Jenny has confirmation order number displayed

    Scenario: Jenny log out from demo.nopcommerce.com
      When    Jenny click on log out button
      Then    Jenny is log out from her account