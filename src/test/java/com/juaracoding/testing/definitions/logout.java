package com.juaracoding.testing.definitions;

import com.juaracoding.testing.context.DriverContext;
import com.juaracoding.testing.pages.LoginPage;
import com.juaracoding.testing.pages.DashboardPage;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logout {
private DriverContext driverContext;
  private LoginPage loginPage;
  private DashboardPage dashboardpage;

    public logout(DriverContext driverContext) {
        this.driverContext = driverContext;
        loginPage = new LoginPage(this.driverContext.driver);
        dashboardpage = new DashboardPage(this.driverContext.driver);
    }

    @Given("Pengguna telah login dengan kredensial valid.")
    public void penggunaTelahLoginDenganKredensialValid() {
        driverContext.driver.get("https://magang.dikahadir.com/authentication/login");
        loginPage.setUsernameBy(driverContext.text.getUsername());
        loginPage.setPasswordBy(driverContext.text.getPassword());
        loginPage.clickLogInButton();
    }
    @When("Klik tombol 'Logout'.")
    public void klikTombolLogout() throws InterruptedException {
        Thread.sleep(5000);
        dashboardpage.profileButtonby();
        Thread.sleep(5000);
        dashboardpage.logoutButtonBy();
    }
    @Then("Pengguna berhasil logout dan diarahkan ke halaman utama.")
    public void penggunaBerhasilLogoutDanDiarahkanKeHalamanUtama() throws InterruptedException {
        Thread.sleep(3000);
        String actual = driverContext.driver.getCurrentUrl();
        String expected = "https://magang.dikahadir.com/authentication/login";
        Assert.assertEquals(actual, expected);
    }
}