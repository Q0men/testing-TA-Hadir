package com.juaracoding.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    private WebDriver driver;
    private By searchBy = By.xpath("//input[@id='search']");
    private By resetbuttonBy = By.xpath("//button[@type='button' and text()='Reset']");
    private By searchButtonBy = By.xpath("//button[@type='submit' and text()='Search']");
    private By filterBy = By.xpath("//button[.//*[contains(@class, 'feather-filter')]]");
    private By exportBy = By.xpath("//button[@type='button' and text()='Export']");
    private By nextpageBy = By.xpath("//button[@type='button' and @title='Go to next page']");
    private By LastpageBy = By.xpath("//button[@type='button' and @title='Go to last page']");
    // private By checkboxBy = By.xpath("//input[@type='checkbox'])[1]");

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void searchBy(String search) {
        driver.findElement(searchBy).sendKeys(search);
    }
    public void resetButtonBy() {
        driver.findElement(resetbuttonBy).click();
    }
    public void searchButtonBy() {
        driver.findElement(searchButtonBy).click();
    }
    public void filterBy() {
        driver.findElement(filterBy).click();
    }
    public void exportBy() {
        driver.findElement(exportBy).click();
    }
    public void nextpageBy() {
        driver.findElement(nextpageBy).click();
    }
    public void lastpageBy() {
        driver.findElement(LastpageBy).click();
    }

}
