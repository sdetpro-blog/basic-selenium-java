package com.sdetpro.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterComponent {

    private WebDriver driver;
    private By pageFooterSelector = By.id("page-footer");
    private By pageFooterLinkText = By.cssSelector("#page-footer a");

    public FooterComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement pageFooter() {
        return driver.findElement(pageFooterSelector);
    }

    public WebElement pageFooterLinkText() {
        return driver.findElement(pageFooterLinkText);
    }

}
