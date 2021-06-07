package com.sdetpro.apilearning;

import com.sdetpro.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class UrlPageTitleHandle {

    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        By usernameSelector = By.id("username");
        By passwordSelector = By.id("password");
        By loginBtnSelector = By.cssSelector("[type='submit']");

        WebElement usernameElem = driver.findElement(usernameSelector);
        WebElement passwordElem = driver.findElement(passwordSelector);
        WebElement loginBtnElem = driver.findElement(loginBtnSelector);

        usernameElem.sendKeys("tomsmith");
        passwordElem.sendKeys("SuperSecretPassword!");
        loginBtnElem.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginBtnSelector));

        String pageTitleAfterLogin = driver.getTitle();
        String pageUrlAfterLogin = driver.getCurrentUrl();

        System.out.println("Page Title: " + pageTitleAfterLogin);
        System.out.println("Page URL: " + pageUrlAfterLogin);

        try {
            URL urlParser = new URL(pageUrlAfterLogin);
            System.out.println("Page's base URL: " + urlParser.getHost());
            System.out.println("Page URL path: " + urlParser.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
