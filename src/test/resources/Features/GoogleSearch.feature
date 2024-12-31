@DEV @SIT
Feature: Google Search Functionality

  Scenario: Search for AWS on Google
    Given User opens Google homepage
    When User searches for AWS
    Then Results are displayed