package com.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.automation.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class CalculatorRunner {
}
