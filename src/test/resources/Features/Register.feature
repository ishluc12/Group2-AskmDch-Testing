@account
Feature: Customer Registration

  As a new Customer
  I want to create an account
  So that I can log in

  Background:
    Given I am on the Account Page

  Rule: New customer is registered as provided data are valid

    Scenario: Register with valid data
      When I register with valid data
        |username     |ttster157        |
        |email address|teiter157@gmail.com|
        |password     |tesTer12345@askomdch|
      And clicks the register button
      Then the account is registered and I get welcome message with name "ttster157"

  Rule: New customer is not registered as provided data are invalid
    Scenario Outline: Register with invalid data
      When I register with invalid "<username>","<email>" and "<password>"
      And clicks the register button
      Then the user should see an error message "<errorMessage>"

      Examples:
        | username    | email                | password   | errorMessage                                                                    |
        | Testing Web | testing@Web.com      | testing123 | Error: An account is already registered with your email address. Please log in. |
        |             | newuser1234@test.com | testing123 | Error: Please enter a valid account username.                                   |
        | user1       |                      | user1!     | Error: Please provide a valid email address.                                    |
        | user2       | user2@com            | user2!     | Error: Please provide a valid email address.                                    |
        | user3       | user3@example.com    |            | Error: Please enter an account password.                                        |
