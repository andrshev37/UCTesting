package org.example;

public class Main {

    //private static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        UCTest ucTest = new UCTest();

        // Execute UC1
        ucTest.executeTest(
                Config.UC_USERNAME, Config.UC_PASSWORD,
                Config.UC1_ERR_MSG_TASK, Config.UC1_ERR_MSG_SHOULD, Config.UC1_NAME
        );

        // Execute UC2
        ucTest.executeTest(
                Config.UC_USERNAME, Config.UC_PASSWORD,
                Config.UC2_ERR_MSG_TASK, Config.UC2_ERR_MSG_SHOULD, Config.UC2_NAME
        );

        // Execute UC3
        ucTest.executeTest(
                Config.UC_USERNAME, Config.UC_PASSWORD,
                Config.UC3_ERR_MSG_TASK, Config.UC3_ERR_MSG_SHOULD, Config.UC3_NAME
        );
    }
}






