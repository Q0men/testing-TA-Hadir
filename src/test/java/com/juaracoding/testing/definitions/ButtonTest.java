package com.juaracoding.testing.definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

// -------------------------Skenario1---------------------------------------
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

// -------------------------Skenario2---------------------------------------

@When("Admin memasukkan data user yang tidak terdaftar pada kolom pencarian")
public void admin_memasukkan_data_user_yang_tidak_terdaftar_pada_kolom_pencarian() throws InterruptedException {
    Thread.sleep(2000);
    userPage.searchBy("usertidakada");
}
@Then("Sistem menampilkan informasi bahwa data user tidak ditemukan pada halaman Management User")
public void sistem_menampilkan_informasi_bahwa_data_user_tidak_ditemukan_pada_halaman_management_user(){
}

// -------------------------Skenario3---------------------------------------
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

// -------------------------Skenario4---------------------------------------
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
    userPage.searchBy("123456");
}
@Then("Sistem menampilkan data user sesuai dengan role yang dipilih pada tabel di halaman Management User")
public void sistem_menampikan_data_sesuai_role() throws InterruptedException {
    Thread.sleep(2000);
    String actual = driverContext.driver.findElement(By.xpath("//*[normalize-space(.)='Dark Tomcat']")).getText();
    String expected = "Dark Tomcat";
    Assert.assertEquals(actual, expected);
}

// -------------------------Skenario5---------------------------------------
@When("Admin menekan tombol Logout")
public void admin_menekan_tombol_logout() throws InterruptedException {
        Thread.sleep(3000);
        dashboardPage.profileButtonby();
        Thread.sleep(3000);
        dashboardPage.logoutButtonBy();
}
@Then("Sistem mengarahkan Admin ke halaman Login")
public void admin_berhasil_logout_dan_diarahkan_ke_halaman_utama() throws InterruptedException {
    Thread.sleep(3000);
    String actual = driverContext.driver.getCurrentUrl();
    String expected = "https://magang.dikahadir.com/authentication/login";
    Assert.assertEquals(actual, expected);
}
// -------------------------Skenario6---------------------------------------
@When("Admin menekan tombol Filter")
public void admin_menekan_tombol_filter() {
    userPage.filterBy();
}
@Then("Sistem menampilkan opsi filter untuk mengelola tampilan data user di halaman Management User")
public void sistem_menampilkan_informasi_Kelompok() throws InterruptedException {
    Thread.sleep(2000);
    String actual = driverContext.driver.findElement(By.xpath("//*[@id='mui-2'and normalize-space(.)='Filter User']")).getText();
    String expected = "Filter User";
    Assert.assertEquals(actual, expected);
}
// -------------------------Skenario7---------------------------------------
@When("Admin menekan tombol filter dan memilih unit")
public void admin_menekan_tombol_unit() throws InterruptedException {
    userPage.filterBy();
    String comboboxunit = "//div[@role='combobox' and @id='mui-component-select-job_departement_id']";
    driverContext.driver.findElement(By.xpath(comboboxunit)).click();
}
@And("Admin memilih Unit")
public void admin_memilih_unit_pada() throws InterruptedException {
    Thread.sleep(2000);
    String optionunit = "//li[@role='option' and normalize-space(.)='BCA'][1]";
    driverContext.driver.findElement(By.xpath(optionunit)).click();
}
@Then("Sistem menampilkan Unit pada combobox sesuai dengan unit yang dipilih")
public void sistem_menampikan_unit_yang_dipilih() throws InterruptedException {
    Thread.sleep(2000);
    String actual = driverContext.driver.findElement(By.xpath("//div[@role='combobox' and @id='mui-component-select-job_departement_id']")).getText();
    String expected = "BCA";
    Assert.assertEquals(actual, expected);
}


// -------------------------Skenario8---------------------------------------
@When("Admin menekan tombol filter dan memilih filter")
public void admin_menekan_tombol_filter1() throws InterruptedException {
    userPage.filterBy();
    String comboboxkaryawan = "//div[@role='combobox' and @id='mui-component-select-employee_type_id']";
    String optionkaryawan = "//li[@role='option' and normalize-space(.)='Mitra']";
    driverContext.driver.findElement(By.xpath(comboboxkaryawan)).click();
    driverContext.driver.findElement(By.xpath(optionkaryawan)).click();
    JavascriptExecutor js = (JavascriptExecutor) driverContext.driver;
    WebElement targetElement = driverContext.driver.findElement(By.xpath("//button[@type='submit' and normalize-space(.)='Terapkan']"));
    js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
    Thread.sleep(2000);
    targetElement.click();
}

@And("Admin mengisi kolom pencarian dengan data user sesuai filter yang dipilih")
public void admin_mengisi_kolom_pencarian_dengan_data_user_sesuai_kelompok_yang_dipilih() throws InterruptedException {
    Thread.sleep(4000);
    userPage.searchBy("123");
}
@Then("Sistem menampilkan data user sesuai dengan filter yang dipilih pada tabel di halaman Management User")
public void sistem_menampikan_data_sesuai_kelompok() throws InterruptedException {
    Thread.sleep(2000);
    String actual = driverContext.driver.findElement(By.xpath("//*[normalize-space(.)='123']")).getText();
    String expected = "123";
    Assert.assertEquals(actual, expected);
}
}