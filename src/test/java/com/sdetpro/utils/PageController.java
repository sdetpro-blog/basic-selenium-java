package com.sdetpro.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageController {

    public static void scrollToBottom(WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    public static boolean isElementInViewPort(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        boolean isInVertical = (Boolean) javascriptExecutor
                .executeScript("return ((window.pageYOffset + window.innerHeight) > $(arguments[0]).offset().top)", element);
        boolean isInVerticalTop = (Boolean) javascriptExecutor
                .executeScript("return ((window.pageYOffset) < ($(arguments[0]).offset().top + $(arguments[0]).height()))", element);
        boolean isInHorizontalLeftSide = (Boolean) javascriptExecutor
                .executeScript("return ((window.innerWidth) > $(arguments[0]).offset().left)", element);

        boolean isInHorizontalRightSide = (Boolean) javascriptExecutor
                .executeScript("return ((window.innerWidth) > ($(arguments[0]).offset().left) + $(arguments[0]).width())", element);

        return  isInVertical && isInVerticalTop && isInHorizontalLeftSide && isInHorizontalRightSide;
    }
}
