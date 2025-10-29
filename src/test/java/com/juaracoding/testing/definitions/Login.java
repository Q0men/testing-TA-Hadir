package com.juaracoding.testing.definitions;

import org.testng.Assert;

import com.juaracoding.testing.context.DriverContext;
import com.juaracoding.testing.pages.LoginPage;
import org.openqa.selenium.By;

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

  // --- Skenario 1: Login Sukses ---
  @Given("Buka halaman utama.")
  public void bukahalamanutama() {
    driverContext.driver.get("https://magang.dikahadir.com/authentication/login");
  }

  @When("Masukkan email dan password yang valid.")
  public void masukkanEmailDanPasswordValid() {
    loginPage.setUsernameBy(driverContext.text.getUsername());
    loginPage.setPasswordBy(driverContext.text.getPassword());
  }
  @And("Klik tombol 'Login'.")
  public void klikTombolLogin() {
    loginPage.clickLogInButton();;
  }
  @Then("Pengguna berhasil login dan diarahkan ke dashboard.")
  public void penggunaBerhasilLogin() throws InterruptedException {
    Thread.sleep(5000);
    String actual = driverContext.driver.getCurrentUrl();
    String expected = "https://magang.dikahadir.com/dashboards/pending";
    Assert.assertEquals(actual, expected);
}

// --- Skenario 2: Login Gagal ---

@When("Masukkan email atau password yang tidak valid.")
public void masukkanEmailAtauPasswordTidakValid() {
  loginPage.setUsernameBy(driverContext.text.getUsername());
  loginPage.setPasswordBy("wrongpassword");
}
@Then("Pesan kesalahan 'Kredensial tidak valid' ditampilkan.")
public void pesanKesalahanDitampilkan() throws InterruptedException {
  Thread.sleep(3000);
  String actual = driverContext.driver.findElement(By.xpath(
    "//*[@class='MuiTypography-root MuiTypography-body1 css-1qamc72' and normalize-space(.)='Email atau password salah']")).getText();
  String expected = "Email atau password salah";
  Assert.assertEquals(actual, expected);
}
}