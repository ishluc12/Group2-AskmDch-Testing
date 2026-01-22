Feature: Add product to cart functionality
  As a customer
  I want to add products to my cart
  So that I can purchase them later

  Scenario Outline: Add products to cart
    Given I am on the store page
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      |product_name|
      |"Blue Shoes"|
