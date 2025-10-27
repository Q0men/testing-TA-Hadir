package com.juaracoding.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameBy = By.xpath("//input[@name='email']");
    private By passwordBy = By.xpath("//input[@id='password']");
    private By loginButtonBy = By.xpath("//button[@type='submit' and text()='Masuk']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsernameBy(String username) {
        driver.findElement(usernameBy).sendKeys(username);
    }

    public void setPasswordBy(String password) {
        driver.findElement(passwordBy).sendKeys(password);
    }

    public void clickLogInButton() {
        driver.findElement(loginButtonBy).click();
    }
}
