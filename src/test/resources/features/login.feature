Feature: Demo feature
  Background:
    Given Go to loginpage

    When enter correct username and password
      |username| |password|
      |Admin123| |admin123|
  @smoke
  Scenario: login functionality with valid data

    Then login successfull

    And  profile picture displayed

  @regression @smoke
  Scenario: login functionality with invalid data

    Then it should throw error

    And error message display