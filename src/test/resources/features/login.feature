Feature: Login functionality

  Scenario: Login with empty username and password
    Given I open login page "https://www.saucedemo.com/" in "edge" browser or firefox
    When I login with username "" and password ""
    Then I see an error message "Username is required"


  Scenario: Login with empty password
    Given I open login page "https://www.saucedemo.com/" in "edge" browser or firefox
    When I login with username "1" and password ""
    Then I see an error message "Password is required"

  Scenario: Login with valid credentials
    Given I open login page "https://www.saucedemo.com/" in "edge" browser or firefox
    When I login with username "performance_glitch_user" and password "secret_sauce"
    Then I see the dashboard title "Swag Labs"
