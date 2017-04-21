@CategoriesList
Feature: : categories list functionality

  Scenario Outline: : user can see category list on home page
    Given user is on home page
    Then user should see category list on left panel of the page as <Categories>
    And user should navigate to those category page

  Examples:
  |Categories|
  |Books|
  |Computers|
  |Electronics|
  |Apparel|
  |Digital downloads|
  |Jewelry|
  |Gift Cards|

