Feature: Checkout – Review and place order
  As a customer
  I want to review my order and enter my billing details
  So that I can successfully place an order and complete my purchase

  Background:
    Given I am on the checkout page

  Scenario: Customer places an order with valid billing details
    When I enter valid billing details:
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
    And I select payment method
    And I click the Place Order button
    Then a confirmation message is displayed
