package com.sdetpro.draftpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    private WebDriver driver;
    private final By usernameSelector = By.id("username");
    private final By passwordSelector = By.id("password");
    private final By loginBtnSelector = By.cssSelector("[type='submit']");


    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement username() {
        return driver.findElement(usernameSelector);
    }

    public WebElement password() {
        return driver.findElement(passwordSelector);
    }

    public WebElement loginBtn() {
        return driver.findElement(loginBtnSelector);
    }

    public void setUsername(String username) {
        this.username().sendKeys(username);
    }

    public void setPassword(String password) {
        this.password().sendKeys(password);
    }

    public void clickOnLoginBtn() {
        this.loginBtn().click();
    }
}
