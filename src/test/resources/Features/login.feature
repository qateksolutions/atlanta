Feature: Test login functionalities

  Scenario: Check login is successful with valid credentials
    Given a user is on the login page
    When user enters username and password
    And click on login button
    Then user is navigated to home page

  Scenario: Check login is unsuccessful with invalid credentials
    Given a user is on the login page
    When user enters "rifat" and "444444"
    And click on login button
    Then user is failed to login

  Scenario Outline: Check login is successful with valid credentials for multiple users
    Given a user is on the login page
    When user enters <username> and <password>
    And click on login button
    Then user is navigated to home page

    Examples:
    |username|password|
    |Rifat   |12345   |
    |Robert  |12345   |
    |Edward  |12345   |