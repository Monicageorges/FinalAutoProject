@smoke

  Feature: Register | users could register with new accounts
    Scenario: guest user could register with valid data successfully
      Given user go to register page
      When user chooses gender
      And user enters first name
      And user enters last name
      And user chooses date of birth
      And user enters email address
      And user enters company name
      And user enters password
      And user enters confirm password
      And user clicks on register button
      Then success registration message displayed
      And user clicks on continue button to return to home page