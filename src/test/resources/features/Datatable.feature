
Feature: login testing with multiple set of data

  Scenario Outline: login test

    Given user got the login page
    When Enter the login data "<username>" and "<password>"
    And press the enter button
    Then login result should be "<result>"

    Examples:
      | username | password  | result  |
      | Admin    | admin123  | success |
      | admin    | admin1234 | error   |
      | jack     | admin123  | error   |
      | Rock     | rocky123  | error   |
