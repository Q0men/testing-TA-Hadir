package com.juaracoding.testing.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ManagementDivisiPage {

    private WebDriver driver;
    private final By managementBtn = By.xpath("//div[@class='sidebar__item MuiBox-root css-0']/p[text()=\"Management\"]");
    private final By divisiBtn = By.xpath("//div[@class=\"MuiBox-root css-1pd2x36\"]/p[text()='Divisi']");
    private final By validasiDivisi = By.xpath("//h5[text()='NAMA Divisi']");

    public ManagementDivisiPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickManagementBtn() {
        driver.findElement(managementBtn).click();
    }

    public void clickDivisiBtn() {
        driver.findElement(divisiBtn).click();
    }

    public String validasiViewDivisi() {
        return driver.findElement(validasiDivisi).getText();
    }
}
