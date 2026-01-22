Feature: Login Functionality
  In order to do internet banking
  As a valid Askmdch Customer
  I want to login successfully


  Scenario Outline: Login successful
    Given I am in the login form of the Askmdch Application
    When I enter valid "<username_or_email>"
    And I enter valid password "<password>"
    And I click login button
    Then I should be taken to the dashboard

    Examples:
      | username_or_email | password |
      | chris             | chris123 |




