Branches: "main" whith Junit; "oldimpruved" impruved version of old version whithout using of junit
    Currently working on branche "configurated" in which will be congig file for configuration(,site ,browser 
    ,inputs for tests)
Various of additional options:

Test Automation tool: Selenium WebDriver;

Project Builder: Maven;

Browsers: 1) Firefox; 2) Edge;

Locators: XPath;

Test Runner: JUnit;

[Optional] Patterns: 1) Singleton; 2) Adapter; 3) Strategy;

[Optional] Test automation approach: BDD;

Assertions: Hamcrest;

[Optional] Loggers: SLF4J.

Provide parallel execution, add logging for tests and use Data Provider to parametrize tests. Make sure that all tasks are supported by these 3 conditions: UC-1; UC-2; UC-3.

UC-1 Test Login form with empty credentials:

Type any credentials into "Username" and "Password" fields.

Clear the inputs.

Hit the "Login" button.

Check the error messages: "Username is required".

UC-2 Test Login form with credentials by passing Username:

Type any credentials in username.

Enter password.

Clear the "Password" input.

Hit the "Login" button.

Check the error messages: "Password is required".

UC-3 Test Login form with credentials by passing Username & Password:

Type credentials in username which are under Accepted username are sections.

Enter password as secret sauce.

Click on Login and validate the title “Swag Labs” in the dashboard.


