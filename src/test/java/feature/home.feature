Feature: HomePage Feature
  This feature deal with the all components of the home page

  Scenario Outline: Verify Homepage of the application

    Given opened the application
    When user enters "<user>" and "<pass>"
    Then login should be "<status>"

    Examples:
      | user            | pass         | status  |
      | standard_user   | secret_sauce | success |
      | locked_out_user | secret_sauce | fail    |