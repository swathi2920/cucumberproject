package com.casestudy.cucumber.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(features="cucumberproject/src/test/java/com/casestudy/cucumber/features/", glue="com/casestudy/cucumber/definitions", plugin = {"pretty","junit:target/cucumber-reports/Cucumber.xml"},
tags = "(@Module1 or @Module2 or @Module3) and (not @ignore)")
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}