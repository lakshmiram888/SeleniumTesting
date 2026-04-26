Feature: verify demowebshop login

  Scenario: login into demowebshop
    Given Launch the edge browser to navigate to url
    When enter username and password
    Then click login for homepage
