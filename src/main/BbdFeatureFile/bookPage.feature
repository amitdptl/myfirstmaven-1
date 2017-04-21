Feature:  Apply filters to the Books Category.

  As a user
  I want to apply the filters
  So that I can change the order of display.

  Scenario Outline:  User can see the Sort by filter.

    Given user is on the Books Category Page.
    When user selects the Sort by filter
    Then User should see the <position Option>
    Examples:
    |position Option|
    |Name: A to Z   |
    |Name: Z to A   |
    |Price: Low to Hight|
    |Price: High to Low |
    |created on         |


  Scenario Outline:  User can see the Display filter

    Given user is on the Books Category Page
    When user selects the Display filter
    Then user should see display option<Display per page>
      Examples:
      |Display per page|
      |    3  |
      |    6  |
      |    9  |

  Scenario Outline :  User can see View filter

    Given user is on the Books Category Page
    When User selects the View as
    Then User should see view option <view>
    Examples:
      | view |
      | Grid |
      | List |

  @Display
  Scenario Outline: Display Filter
    Given user is in Books category page
    When user select <display>
    Then user should see <number of products> products per page

    Examples:
      | display |number of products|
      |3|3|
      |6|6|
      |9|9|

  @viewas
  Scenario Outline: View as Filter
    Given user is in Books category page
    When user select <View as>
    Then products should be displayed in <View as> format
    Examples:
      |  View as |
      |Grid|
      |List|







