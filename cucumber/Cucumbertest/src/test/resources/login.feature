Feature: verify demowebshop login

  Scenario: login into demowebshop
    Given Launch the edge browser to navigate to url
    When Enter username and password
    Then Click login to homepage
