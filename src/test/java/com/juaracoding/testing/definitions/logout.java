package com.juaracoding.testing.definitions;

import com.juaracoding.testing.context.DriverContext;
import com.juaracoding.testing.pages.LoginPage;
import com.juaracoding.testing.pages.Dashboard;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logout {
private DriverContext driverContext;
  private LoginPage loginPage;
  private Dashboard dashboard;

    public logout(DriverContext driverContext) {
        this.driverContext = driverContext;
        loginPage = new LoginPage(this.driverContext.driver);
        dashboard = new Dashboard(this.driverContext.driver);
    }

    @Given("Pengguna telah login dengan kredensial valid.")
    public void penggunaTelahLoginDenganKredensialValid() {
        driverContext.driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.setUsernameBy(driverContext.user.getUsername());
        loginPage.setPasswordBy(driverContext.user.getPassword());
        loginPage.clickLogInButton();
    }
    @When("Klik tombol 'Logout'.")
    public void klikTombolLogout() throws InterruptedException {
        Thread.sleep(5000);
        dashboard.profileButtonby();
        Thread.sleep(5000);
        dashboard.logoutButtonBy();
    }
    @Then("Pengguna berhasil logout dan diarahkan ke halaman utama.")
    public void penggunaBerhasilLogoutDanDiarahkanKeHalamanUtama() throws InterruptedException {
        Thread.sleep(3000);
        String actual = driverContext.driver.getCurrentUrl();
        String expected = "https://magang.dikahadir.com/authentication/login";
        Assert.assertEquals(actual, expected);
    }
}