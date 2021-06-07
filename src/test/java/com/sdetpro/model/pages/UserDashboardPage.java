package com.sdetpro.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserDashboardPage {

    private WebDriver driver;
    private By flashMsgSelector = By.id("flash");
    private By pageHeaderSelector = By.tagName("h2");
    private By subHeaderSelector = By.className("subheader");
    private By logoutBtn = By.cssSelector(".example a");

    public UserDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFlashMsgSelector() {
        return driver.findElement(flashMsgSelector);
    }

    public WebElement getPageHeaderSelector() {
        return driver.findElement(pageHeaderSelector);
    }

    public WebElement getSubHeaderSelector() {
        return driver.findElement(subHeaderSelector);
    }

    public WebElement getLogoutBtn() {
        return driver.findElement(logoutBtn);
    }
}
