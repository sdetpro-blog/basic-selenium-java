package com.sdetpro.test.listener;

import com.sdetpro.driverex.DriverBase;
import com.sdetpro.model.pages.LoginPage;
import com.sdetpro.utils.Url;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestListener extends DriverBase {

    @Test
    public void testListenerFailed() {
        WebDriver driver = getDriver();
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        Assert.fail();
    }

    @Test
    public void testListenerPassed() {
        WebDriver driver = getDriver();
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPassword("dfsafdsa");
        loginPage.inputUsername("assad");
        loginPage.clickOnLoginBtn();
    }
}
