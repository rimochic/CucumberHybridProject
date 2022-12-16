Feature: Login with Valid Credentials

  Scenario: Successful Login with Valid Credentials
    Given User Launch browser
    When opens URL "https://rahulshettyacademy.com/locatorspractice/"
    And User enters Email as "Admin" and Password as "rahulshettyacademy"
    And Click on Login button
    Then User navigates to MyAccount Page
    And User close the browser
