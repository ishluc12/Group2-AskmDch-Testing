@placeOrder
Feature: Checkout – Review and Place Order
  As an online shopper
  I want to review my shopping cart, enter my billing details, and complete my purchase
  So that I can successfully receive the products I selected

  Background:
    Given I am on the store page

  Scenario: Customer completes a purchase with billing details from Rwanda
    And I add "Blue Shoes" to my cart
    When I proceed to checkout
    And I provide my billing information:
      | First name     | John          |
      | Last name      | Doe           |
      | Company name   | Test Company  |
      | Country/Region | Rwanda        |
      | Street address | KG 123 St     |
      | Apartment/unit | Apt 10        |
      | City           | Kigali        |
      | State          | Gasabo        |
      | ZIP code       | 00000         |
      | Phone          | 0780000000    |
      | Email address  | john@test.com |
    And I select the payment method
    And I place the order
    Then I should see a confirmation message
    And an order number should be generated

  Scenario Outline: Customer completes a purchase with multiple products and billing details from the United States
    And I add "<Product>" to my cart
    When I proceed to checkout
    And I provide my billing information:
      | First name     | Jane               |
      | Last name      | Smith              |
      | Company name   | Example Inc        |
      | Country/Region | United States (US) |
      | Street address | 123 Main St        |
      | Apartment/unit | Suite 101          |
      | City           | Los Angeles        |
      | State          | California         |
      | ZIP code       | 90001              |
      | Phone          | 1234567890         |
      | Email address  | jane@test.com      |
    And I select the payment method
    And I place the order
    Then I should see a confirmation message
    And an order number should be generated

    Examples:
      | Product                         |
      | Black Over-the-shoulder Handbag |
      | Anchor Bracelet                 |
      | Blue Shoes                      |
