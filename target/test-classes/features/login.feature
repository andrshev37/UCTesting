Feature: Login functionality

  Scenario: Login with empty username and password
    Given I open login page "https://www.saucedemo.com/" in "firefox" browser
    When I login with username "" and password ""
    Then I see an error message "Username is required"

  Scenario: Login with empty password
    Given I open login page "https://www.saucedemo.com/" in "edge" browser
    When I login with username "1" and password ""
    Then I see an error message "Password is required"

  Scenario: Login with valid credentials
    Given I open login page "https://www.saucedemo.com/" in "edge" browser
    When I login with username "performance_glitch_user" and password "secret_sauce"
    Then I see the dashboard title "Swag Labs"
#Examples:
  #browser: firefox or edge
  #|Accepted usernames are:|Password for all users:
  #|standard_user          |secret_sauce
  #|locked_out_user        |
  #|problem_user           |
  #|performance_glitch_user|
  #|error_user             |
  #|visual_user            |