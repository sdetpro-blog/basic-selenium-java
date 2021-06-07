package com.sdetpro.apilearning;

import com.sdetpro.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesHandle {

    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        final int FIRST_CHECKBOX_INDEX = 0;
        final int SECOND_CHECKBOX_INDEX = 1;
        final By checkboxesCssSelector = By.cssSelector("[type='checkbox']");

        // Check that the checkboxes are selected or not
        List<WebElement> checkboxesGroup = driver.findElements(checkboxesCssSelector);
        WebElement chcbx1Elem = checkboxesGroup.get(FIRST_CHECKBOX_INDEX);
        WebElement chcbx2Elem = checkboxesGroup.get(SECOND_CHECKBOX_INDEX);

        System.out.println("Is checkbox 1 selected: " + chcbx1Elem.isSelected());
        System.out.println("Is checkbox 2 selected: " + chcbx2Elem.isSelected());

        // Try to select the first one
        System.out.println("====01====");
        chcbx1Elem.click();
        System.out.println("Is checkbox 1 selected: " + chcbx1Elem.isSelected());

        // Try to unselect the second one
        System.out.println("=======02======");
        chcbx2Elem.click();
        System.out.println("Is checkbox 2 selected: " + chcbx2Elem.isSelected());

        // The try to reselect the second

        driver.quit();
    }
}
