Feature: Test login functionalities

  @positive_test
  Scenario: Check login is successful with valid credentials
    Given a user is on the login page
    When user enters username "rifat" and password "12345"
    And click on login button
    Then user is navigated to home page

  @negative_test
  Scenario: Check login is unsuccessful with invalid credentials
    Given a user is on the login page
    When user enters username "rifat" and password "444444"
    And click on login button
    Then user is failed to login

  @dataDriven_test
  Scenario Outline: Check login is successful with valid credentials for multiple users
    Given a user is on the login page
    When user enters username "<username>" and password "<password>"
    And click on login button
    Then user is navigated to home page

    Examples:
    |username|password|
    |Rifat   |12345   |
    |Robert  |12345   |
    |Edward  |12345   |