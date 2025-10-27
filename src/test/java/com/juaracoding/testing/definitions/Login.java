package com.juaracoding.testing.definitions;

import org.checkerframework.checker.units.qual.t;
import org.testng.Assert;

import com.juaracoding.testing.context.DriverContext;
import com.juaracoding.testing.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
  private DriverContext driverContext;
  private LoginPage loginPage;

  public Login(DriverContext driverContext) {
    this.driverContext = driverContext;
    loginPage = new LoginPage(this.driverContext.driver);
  }
  @Given("Buka halaman utama.")
  public void step01() {
    driverContext.driver.get("https://magang.dikahadir.com/authentication/login");
  }

  @When("Masukkan email dan password yang valid.")
  public void step02() {
    loginPage.setUsernameBy(driverContext.user.getUsername());
    loginPage.setPasswordBy(driverContext.user.getPassword());
  }
  @And("Klik tombol 'Login'.")
  public void step03() {
    loginPage.clickLogInButton();;
  }
  @Then("Pengguna berhasil login dan diarahkan ke dashboard.")
  public void step04() throws InterruptedException {
    Thread.sleep(5000);
    String actual = driverContext.driver.getCurrentUrl();
    String expected = "https://magang.dikahadir.com/dashboards/pending";
    Assert.assertEquals(actual, expected);
}
}