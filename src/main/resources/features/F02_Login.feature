@smoke

Feature: Login | users could login with their accounts
  Scenario: user could log in with valid email and password
    Given User open login page
    When User enter email and password
    And User click on login button
    Then User login successfully and return to home page
  Scenario: user could log in with invalid email and password
    Given User open login page
    When User enter invalid email and password
    And User click on login button
    Then User login failed and error message appears
