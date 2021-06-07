package com.sdetpro.apilearning;

import com.sdetpro.utils.Webdriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSAlertHandle {

    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        final By jsAlertBtnSelector = By.cssSelector("[onclick=\"jsAlert()\"]");
        final By jsConfirmBtnSelector = By.cssSelector("[onclick=\"jsConfirm()\"]");
        final By jsPromptBtnSelector = By.cssSelector("[onclick=\"jsPrompt()\"]");
        final By resultSelector = By.id("result");

        driver.findElement(jsAlertBtnSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert content: " + alert.getText());

        alert.accept();
        System.out.println(driver.findElement(resultSelector).getText());


        // Play with JS Confirm Alert
        driver.findElement(jsConfirmBtnSelector).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert content: " + alert.getText());

        alert.dismiss();
        System.out.println(driver.findElement(resultSelector).getText());

        // Play with Js Prompt alert
        driver.findElement(jsPromptBtnSelector).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.sendKeys("Tu Huynh");
        alert.accept();
        System.out.println(driver.findElement(resultSelector).getText());

    }
}
