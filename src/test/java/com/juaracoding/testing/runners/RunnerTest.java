package com.juaracoding.testing.runners;

import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
 features = {"src/test/resources/features/test1-login.feature",
             "src/test/resources/features/test2-logut.feature"},

 glue = {"com.juaracoding.testing.definitions", 
        "com.juaracoding.testing.hooks"},

 plugin = {"pretty", "html:target/cucumber-reports.html"})

public class RunnerTest extends AbstractTestNGCucumberTests {

  @BeforeClass
  public void beforeClass() {
  }

}
