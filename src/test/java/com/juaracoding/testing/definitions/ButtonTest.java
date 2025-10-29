package com.juaracoding.testing.definitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.juaracoding.testing.context.DriverContext;
import com.juaracoding.testing.pages.DashboardPage;
import com.juaracoding.testing.pages.LoginPage;
import com.juaracoding.testing.pages.UserPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ButtonTest {
private DriverContext driverContext;
private LoginPage loginPage;
private DashboardPage dashboardPage;
private UserPage userPage;

public ButtonTest(DriverContext driverContext) {
    this.driverContext = driverContext;
    loginPage = new LoginPage(this.driverContext.driver);
    dashboardPage = new DashboardPage(this.driverContext.driver);
    userPage = new UserPage(this.driverContext.driver);
}

@Given("Admin sudah berada di halaman Management User")
public void Admin_sudah_berada_di_halaman_user() throws InterruptedException {
    driverContext.driver.get("https://magang.dikahadir.com/authentication/login");
    loginPage.setUsernameBy(driverContext.text.getUsername());
    loginPage.setPasswordBy(driverContext.text.getPassword());
    loginPage.clickLogInButton();
    Thread.sleep(5000);
    dashboardPage.managementButtonBy();
    Thread.sleep(4000);
    dashboardPage.userbuttonBy();
    Thread.sleep(4000);
}

@When("Admin memasukkan data user pada kolom pencarian")
public void Admin_klik_role_button() {
    userPage.searchBy(driverContext.text.getUser());

}
@And("Admin menekan tombol Search")
public void Admin_menekan_tombol_search() {
    userPage.searchButtonBy();
}
@Then("Sistem menampilkan data user yang dicari pada tabel di halaman Management User")
public void Sistem_menampilkan_data_user_yang_dicari_pada_tabel_di_halaman_management_user() throws InterruptedException {
    Thread.sleep(2000);
    String actual = driverContext.driver.findElement(By.xpath("//*[normalize-space(.)='Admin Meeting']")).getText();
    String expected = "Admin Meeting";
    Assert.assertEquals(actual, expected);
}

@When("Admin memasukkan data user yang tidak terdaftar pada kolom pencarian")
public void admin_memasukkan_data_user_yang_tidak_terdaftar_pada_kolom_pencarian() throws InterruptedException {
    Thread.sleep(2000);
    userPage.searchBy("usertidakada");
}
@Then("Sistem menampilkan informasi bahwa data user tidak ditemukan pada halaman Management User")
public void sistem_menampilkan_informasi_bahwa_data_user_tidak_ditemukan_pada_halaman_management_user(){
}


@And("Admin menekan tombol Reset")
public void admin_menekan_tombol_reset() {
    userPage.resetButtonBy();
}
@Then("Sistem mengosongkan kolom pencarian dan menampilkan semua data user pada tabel di halaman Management User")
public void kolom_search_kosong(){
    String actual = driverContext.driver.findElement(By.xpath("//input[@id='search']")).getText();
    String expected = "";
    Assert.assertEquals(actual, expected);
}
@When("Admin menekan tombol Role dan memilih role yang diinginkan")
public void admin_menekan_tombol_role() {
    String combobox = "//div[@role='combobox' and normalize-space(.)='Nama']";
    String option = "//li[@role='option' and normalize-space(.)='Nik']";
    driverContext.driver.findElement(By.xpath(combobox)).click();
    driverContext.driver.findElement(By.xpath(option)).click();

}
@And("Admin mengisi kolom pencarian dengan data user sesuai role yang dipilih")
public void admin_mengisi_kolom_pencarian_dengan_data_user_sesuai_role_yang_dipilih() throws InterruptedException {
    Thread.sleep(2000);
    userPage.searchBy("Dark Tomcat");
}
@Then("Sistem menampilkan data user sesuai dengan role yang dipilih pada tabel di halaman Management User")
public void sistem_menampikan_data_sesuai_role() throws InterruptedException {
    Thread.sleep(2000);
    String actual = driverContext.driver.findElement(By.xpath("//*[normalize-space(.)='Dark Tomcat']")).getText();
    String expected = "Dark Tomcat";
    Assert.assertEquals(actual, expected);
}

}