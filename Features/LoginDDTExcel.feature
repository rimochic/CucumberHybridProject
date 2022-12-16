Feature: Login with Valid Credentials

  Scenario Outline: Successful Login with Valid Credentials
    Given User Launch browser
    When opens URL "https://rahulshettyacademy.com/locatorspractice/"
    And User enters Email and Password from Excel file "<row_index>"
    And Click on Login button
    Then User navigates to MyAccount Page
    And User close the browser
    
    Examples:
    	|row_index|
      |1|
      |2|
