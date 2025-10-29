package com.juaracoding.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By profileby = By.xpath(
            "//button[@aria-controls='profile-menu' and .//h5[normalize-space(.)='Admin Hadir']]");
    private By managementBy = By.xpath(
            "//*[@class='MuiTypography-root MuiTypography-body1 css-1ub5lza' and normalize-space(.)='Management']");
    private By LogoutBy = By.xpath(
            "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-uajqx8']");
    private By userBy = By.xpath(
            "//*[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf' and normalize-space(.)='User']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;}

    public void profileButtonby() {
        driver.findElement(profileby).click();   
    }
    public void managementButtonBy() {
        driver.findElement(managementBy).click();
    }
    public void logoutButtonBy() {
        driver.findElement(LogoutBy).click();
    }
    public void userbuttonBy() {
        driver.findElement(userBy).click();
    }
}
