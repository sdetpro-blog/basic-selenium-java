package com.sdetpro.apilearning;

import com.sdetpro.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicContentHandle {

    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        By removeButtonSelector = By.cssSelector("#checkbox-example button");
        By checkBoxSelector = By.id("checkbox");
        By inputSelector = By.cssSelector("#input-example input");
        By enableInputBtnSelector = By.cssSelector("#input-example button");

        System.out.println("Is the checkbox displayed: " + driver.findElement(checkBoxSelector).isDisplayed());

        driver.findElement(removeButtonSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBoxSelector));
        try {
            driver.findElement(checkBoxSelector);
        } catch (Exception e){
            System.out.println("The checkbox was removed:");
        }


        // Handle the input form
        System.out.println("Is the Inout form enabled: " + driver.findElement(inputSelector).isEnabled());
        driver.findElement(enableInputBtnSelector).click();
        wait.until(ExpectedConditions.textToBe(enableInputBtnSelector, "Disable"));
        System.out.println("Is the Inout form enabled: " + driver.findElement(inputSelector).isEnabled());
    }
}
