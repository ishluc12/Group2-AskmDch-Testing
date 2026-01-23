Feature: Sort Products
  As a customer
  I want to sort products
  So that I can view items in my preferred order

  Background:
    Given I am on Store page

  @sort
  Scenario: Default sorting is applied on page load
    When user records initial product order
    Then products should maintain default order

  @sort @high
  Scenario Outline: Customer can sort products by different options
    When I click sort dropdown
    And I select <SortOption> option
    Then products should be sorted according to <SortOption>
    And <ValidationMessage> should be verified

    Examples:
      | SortOption                 | ValidationMessage                   |
      | Sort by popularity         | most popular products appear first  |
      | Sort by average rating     | highest rated products appear first |
      | Sort by price: low to high | lowest price product appears first  |
      | Sort by price: high to low | highest price product appears first |
      | Sort by latest             | newest products appear first        |
