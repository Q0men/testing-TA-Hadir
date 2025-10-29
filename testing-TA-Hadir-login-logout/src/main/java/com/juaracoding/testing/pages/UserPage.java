package com.juaracoding.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    private WebDriver driver;
    private By roleBy = By.xpath("//div[@role='combobox' and normalize-space(.)='Nama']");
    private By searchBy = By.xpath("//input[@placeholder='Search...']");
    private By resetBy = By.xpath("//button[@type='button' and text()='Reset']");
    private By SearchButtonBy = By.xpath("//button[@type='submit' and text()='Search']");
    private By filterBy = By.xpath("//button[.//*[contains(@class, 'feather-filter')]]");
    
}
