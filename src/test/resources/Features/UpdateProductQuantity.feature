@updateQuantity
Feature: Update quantity of a product in the shopping cart

  Scenario: User updates the quantity of a product in the shopping cart

    Given I have at least one product in the cart
    When I update the quantity of the product
    And I click Update Cart button
    Then the cart should reflect the updated quantity of product


