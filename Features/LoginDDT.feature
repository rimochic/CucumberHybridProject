Feature: Login with Valid Credentials

  Scenario Outline: Successful Login with Valid Credentials
    Given User Launch browser
    When opens URL "<url>"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login button
    Then User navigates to MyAccount Page
    And User close the browser

    Examples: 
      | url                                              | email | password           |
      | https://rahulshettyacademy.com/locatorspractice/ | Admin | rahulshettyacademy |
