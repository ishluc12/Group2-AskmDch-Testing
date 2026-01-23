@browseByCategory
Feature: Browse Products by Categories
  As a customer
  I want to browse products by categories
  So that I can find specific types of products easily

  Background:
    Given I am on the Store page

  Scenario: Browse products by Men category
    When I click on Men category
    Then product list should show only Men products

  Scenario: Browse products by Women category
    When I click on Women category
    Then product list should show only Women products

  Scenario: Browse products by Accessories category
    When I click on Accessories category
    Then product list should show only Accessories products