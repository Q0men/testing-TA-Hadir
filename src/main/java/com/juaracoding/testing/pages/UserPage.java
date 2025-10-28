package com.juaracoding.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    private WebDriver driver;
    private By rolebuttonBy = By.xpath("//div[@role='combobox' and normalize-space(.)='Nama']");
    private By searchBy = By.xpath("//input[@placeholder='Search...']");
    private By resetbuttonBy = By.xpath("//button[@type='button' and text()='Reset']");
    private By searchButtonBy = By.xpath("//button[@type='submit' and text()='Search']");
    private By filterBy = By.xpath("//button[.//*[contains(@class, 'feather-filter')]]");
    private By exportBy = By.xpath("//button[@type='button' and text()='Export']");
    private By nextpageBy = By.xpath("//button[@type='button' and @title='Go to next page']");
    private By LastpageBy = By.xpath("//button[@type='button' and @title='Go to last page']");
    
}
