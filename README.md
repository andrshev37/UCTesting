Branches: "main" whith Junit,PageObject,Cucumber; "oldimpruved" impruved version of old version whithout using of junit
    src/test/resourses/features/login.feature for testing configurations
Various of additional options:

Test Automation tool: Selenium WebDriver;  

Project Builder: Maven;

Browsers: 1) Firefox; 2) Edge;

Locators: XPath; And ID

Test Runner: JUnit; Jupiter-Junit and Cucumber-Junit

[Optional] Patterns: 1) Singleton; 2) Adapter; 3) Strategy;WebDriverSingleton.java

[Optional] Test automation approach: BDD; whith Cucumber

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



