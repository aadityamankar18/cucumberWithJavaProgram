Feature: HomePage Feature
  This feature deals with all components of the home page

  Scenario Outline: Verify SauceDemo login

    Given opened the application
    When user enters "<user>" and "<pass>"
    Then saucedemo login should be "<status>"

    Examples:
      | user            | pass         | status  |
      | standard_user   | secret_sauce | success |
      | locked_out_user | secret_sauce | fail    |

  Scenario Outline: Verify Rahul Shetty login

    Given opened the website
    When user enters "<user>" and "<pass>"
    Then rahul login should be "<status>"

    Examples:
      | user                      | pass               | status  |
      | aadityamankar18@gmail.com | rahulshettyacademy | success |
      | locked_out_user           | secret_sauce       | fail    |