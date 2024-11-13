package org.example;

public class Config {
    //browser configuration
    public static final String BROWSER = "firefox"; // or "edge"
    //site configuration
    public static final String SITE = "https://www.saucedemo.com/";
    //web elements configuration
    public static final String usernameField = "username";
    public static final String passwordField = "password";
    //UC configuration:
    public static final String UC_USERNAME = "performance_glitch_user";
    public static final String UC_PASSWORD = "secret_sauce";
    // UC1 configuration
    public static final String UC1_ERR_MSG_TASK = "UC1: Error message should match 'Username is required'";
    public static final String UC1_ERR_MSG_SHOULD = "Username is required";
    public static final String UC1_NAME = "UC1";
    // UC2 configuration
    public static final String UC2_ERR_MSG_TASK = "UC2: Error message should match 'Password is required'";
    public static final String UC2_ERR_MSG_SHOULD = "Password is required";
    public static final String UC2_NAME = "UC2";
    // UC3 configuration
    public static final String UC3_ERR_MSG_TASK = "UC3: Dashboard title should match 'Swag Labs'";
    public static final String UC3_ERR_MSG_SHOULD = "Swag Labs";
    public static final String UC3_NAME = "UC3";
}
