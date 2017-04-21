Feature: Product Categories List

  As a User
  I want to see categories list on HomePage
  So that I can goto categories

  @fil
  Scenario Outline: User can see Filters for Selected Category
    Given User is on Homepage
    When he selects a "<Category>" and "<Sub Category>"
    Then he should be navigated to selected category page with header "<Category>" or "<Sub Category>"
    And should have an option to apply the filter as "Sort by","Display"

    Examples:
      | Category    | Sub Category  |
      | Books       |               |
      | Computers   | Desktops      |
      | Computers   | Notebooks     |
      | Computers   | Software      |
      | Electronics | Camera & photo|
      | Electronics | Cell phones   |
      | Electronics | others        |
      | Apparel     | Shoes         |
      | Apparel     | Clothing      |
      | Apparel     | Accessories   |
      |Digital Downloads|           |
      |Jewelry          |           |
      |Gift Cards       |           |

  Scenario Outline: User can apply filters to product list page and view the items
    Given User is in home page
    When selects books page
    Then User should see <Sort by> Filter with following options
    And User should see <Display> Filter with following options
    And User should see <View as> Filter with following options
    Examples:
      Sort by:                   Display:          View as:
      | Position          |      | 3  |           | Grid |
      | Name:A to Z       |      | 6  |           | List |
      | Name:Z to A       |      | 9  |           |      |
      | Price:Low to High |      |    |           |      |
      | Price:High to Low |      |    |           |      |
      | Created: on       |      |    |           |      |

