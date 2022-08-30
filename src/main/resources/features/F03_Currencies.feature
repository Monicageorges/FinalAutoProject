@smoke

Feature: Currencies | users could select currency
  Scenario: user could select euro currency
    Given User log in with email and password
    When User select euro currency from drop down menu
    Then All items prices change to euro
