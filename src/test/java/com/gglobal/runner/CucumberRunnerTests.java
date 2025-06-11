package com.gglobal.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "", features = {"src/test/resources/features/"}, glue = {
    "com.gglobal.stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json",
        "junit:target/cukes.xml"})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {}