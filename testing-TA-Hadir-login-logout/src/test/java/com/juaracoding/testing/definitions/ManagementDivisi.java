package com.juaracoding.testing.definitions;

import com.juaracoding.testing.context.DriverContext;
import com.juaracoding.testing.pages.LoginPage;
import com.juaracoding.testing.pages.ManagementDivisiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;


public class ManagementDivisi {
    private DriverContext driverContext;
    private LoginPage loginPage;
    private ManagementDivisiPage mDP;

    public ManagementDivisi(DriverContext driverContext) {
        this.driverContext = driverContext;
        loginPage = new LoginPage(this.driverContext.driver);
        mDP = new ManagementDivisiPage(this.driverContext.driver);
    }

    // ---- Management Divisi ----
    @Given("Klik tombol management.")
    public void tombolmanagement() throws InterruptedException {
        driverContext.driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.setUsernameBy(driverContext.user.getUsername());
        loginPage.setPasswordBy(driverContext.user.getPassword());
        loginPage.clickLogInButton();
        Thread.sleep(1000);
        mDP.clickManagementBtn();
    }

    @When("Klik tombol divisi.")
    public void tombolDivisi() throws InterruptedException{
        mDP.clickDivisiBtn();
        Thread.sleep(1000);
    }

    @Then("Pengguna berhasil masuk kehalaman Management Divisi.")
    public void validasiHalamanDivisi() throws InterruptedException {
        String expected = "NAMA DIVISI";
        String actual = mDP.validasiViewDivisi();
        Assert.assertEquals(expected, actual);
        Thread.sleep(1000);
    }

}