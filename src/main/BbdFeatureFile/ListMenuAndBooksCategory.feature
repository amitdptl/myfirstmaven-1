Feature: Categories List Menu and Books Category

  As a user
  I want to apply the filters
  So that I can change the order of display

  Scenario Outline: user can see book category on top panel of Home page
    Given user on Home page
    When user select book category
    Then user should navigate to book category page
    And user see Book category page with <filters>
    And user see product in Grid view

    Examples:
    |filters|
    |Sort By|
    |Display|
    |View as|

    @Sort by
    Scenario Outline: apply sort by filter
      Given user is on book category page
      When  user select sort by filter <Sort by>
      Then  user should see sorted product by <order>

      Examples:
      |Sort by|order|
      |Name: A to Z|alphabetical ascending order|
      |Name: Z to A|alphabetical descending order|
      |Price: Low to High|price descending order |
      |Price: High to Low|price acending order   |
      |Created on        |lasted updated date    |

      @Display
      Scenario Outline: apply Display filter
        Given user is on book category page
        When user select display filter <Display> from list
        Then user should see <no of product> per page

        Examples:
        |Display|no of product|
        |3      |3            |
        |6      |6            |
        |9      |9            |

      @viewAs
      Scenario Outline: apply view filter
        Given user is on books category page
        When user select view as filter <view As>
        Then user should see product soted in <different view>

        Examples:
        |view As|different view|
        |Grid  |product sorted in Grid view|
        |List  |product sorted in List view|




















