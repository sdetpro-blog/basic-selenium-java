package com.sdetpro.apilearning;

import com.sdetpro.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseHover {

    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();

        By avatarSelector = By.cssSelector(".figure");
        By usernameSelector = By.cssSelector(".figcaption h5");
        By usernameHyperlink = By.cssSelector(".figcaption a");
        final int USER_1_INDEX = 0;
        final int USER_2_INDEX = 1;
        final int USER_3_INDEX = 2;

        driver.findElement(By.cssSelector("cssSelectorValue"));

        List<WebElement> userAvatarElems = driver.findElements(avatarSelector);
        List<WebElement> usernameElems = driver.findElements(usernameSelector);
        List<WebElement> userHyperlinkElems = driver.findElements(usernameHyperlink);

        // Move mouse on the first user
        Actions actions = new Actions(driver);
        actions.moveToElement(userAvatarElems.get(USER_1_INDEX)).perform();
        System.out.println(usernameElems.get(USER_1_INDEX).getText());
        System.out.println(userHyperlinkElems.get(USER_1_INDEX).getAttribute("href"));

        // User 2
        actions.moveToElement(userAvatarElems.get(USER_2_INDEX)).perform();
        System.out.println(usernameElems.get(USER_2_INDEX).getText());
        System.out.println(userHyperlinkElems.get(USER_2_INDEX).getAttribute("href"));

        // User 3
        actions.moveToElement(userAvatarElems.get(USER_3_INDEX)).perform();
        System.out.println(usernameElems.get(USER_3_INDEX).getText());
        System.out.println(userHyperlinkElems.get(USER_3_INDEX).getAttribute("href"));

        driver.quit();
    }
}
