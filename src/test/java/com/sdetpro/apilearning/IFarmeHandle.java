package com.sdetpro.apilearning;

import com.sdetpro.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFarmeHandle {

    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");

        By iframeNodeSelector = By.id("mce_0_ifr");
        By iframeBodySelector = By.id("tinymce");

        WebElement iframeElem = driver.findElement(iframeNodeSelector);
        driver.switchTo().frame(iframeElem);

        WebElement iframeBodyElem = driver.findElement(iframeBodySelector);
        iframeBodyElem.clear();
        iframeBodyElem.sendKeys("This is my new content!");

        // Switch BACK to the main frame
        driver.switchTo().defaultContent();

        driver.quit();
    }
}
