Feature: Dashboard functionality
  Scenario: Login with valid credentials
    Given I open login page "https://www.saucedemo.com/" in "edge" browser
    When I login with username "performance_glitch_user" and password "secret_sauce"
    Then I see the dashboard title "Swag Labs"