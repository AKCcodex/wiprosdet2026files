Feature: PHPTravels Login Module

  @Smoke @Regression
  Scenario Outline: Validate Login Functionality

    Given user launches browser
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then validate login result

    Examples:
      | username                | password   |
      | user@phptravels.com     | demouser   |
      | invalid@gmail.com       | invalid    |
   