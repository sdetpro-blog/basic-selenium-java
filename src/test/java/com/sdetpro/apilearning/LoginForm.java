package com.sdetpro.apilearning;

import com.sdetpro.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginForm {

    public static void main(String[] args) {
        final String testUrl = "https://the-internet.herokuapp.com/login";
        WebDriver driver = Webdriver.getChromeDriver();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get(testUrl);
        driver.manage().window().maximize();

        WebElement usernameElem = driver.findElement(By.id("username"));
        WebElement passwordElem = driver.findElement(By.id("password"));
        WebElement loginBtnElem = driver.findElement(By.cssSelector("[type='submit']"));

        usernameElem.sendKeys("tomsmith_");
        passwordElem.sendKeys("SuperSecretPassword!");
        loginBtnElem.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash-messages")));

        driver.findElement(By.id("wrong___")).click(); // interval time 500ms
    }
}
