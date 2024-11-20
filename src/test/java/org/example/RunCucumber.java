package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.runner.JUnitCore;
import org.junit.experimental.ParallelComputer;




@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.example.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunCucumber {
    public static void main(String[] args) {
        // Паралельний запуск тестів
        Class<?>[] classes = {RunCucumber.class};
        JUnitCore.runClasses(new ParallelComputer(true, true), classes);
    }
}
