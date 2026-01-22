Feature: Browse Products by Categories
  As a customer
  I want to browse products by categories
  So that I can find specific types of products easily

  Background:
    Given I am on the Store page

  @smoke @browse-category
  Scenario: Category sidebar is visible
    When I view the category sidebar
    Then category sidebar should be displayed

  @browse-category
  Scenario: Browse products by Men category
    When I click on Men category
    Then product list should show only Men products

  @browse-category
  Scenario: Browse products by Women category
    When I click on Women category
    Then product list should show only Women products

  @browse-category
  Scenario: Browse products by Accessories category
    When I click on Accessories category
    Then product list should show only Accessories products
    And product count should be 3