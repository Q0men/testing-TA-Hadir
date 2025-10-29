package com.juaracoding.testing.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
  features = {"src/test/resources/features/LoginLogout.feature",
              "src/test/resources/features/ManagementUser.feature",},

  glue = {"com.juaracoding.testing.definitions", 
  "com.juaracoding.testing.hooks"},
  
  plugin = {"pretty", "html:target/cucumber-reports.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
  
  public class RunnerTest extends AbstractTestNGCucumberTests {

  @BeforeClass
  public void beforeClass() {
  }

}
