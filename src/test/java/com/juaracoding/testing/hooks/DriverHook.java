package com.juaracoding.testing.hooks;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.juaracoding.testing.context.DriverContext;
import com.juaracoding.testing.models.Text;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHook {
    private DriverContext driverContext;

    public DriverHook(DriverContext driverContext) {
        this.driverContext = driverContext;
        this.driverContext.text = new Text();
        this.driverContext.text.setUsername("admin@hadir.com");
        this.driverContext.text.setPassword("MagangSQA_JC@123");
        this.driverContext.text.setUser("admin meeting");
    }

    @Before
    public void setup() throws InterruptedException{
        driverContext.driver = new FirefoxDriver();
        driverContext.driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @After
    public void teardown() throws InterruptedException {
        if (driverContext.driver != null) {
            Thread.sleep(3000);
            driverContext.driver.quit();
        }
    }
}