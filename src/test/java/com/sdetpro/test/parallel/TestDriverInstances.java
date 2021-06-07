package com.sdetpro.test.parallel;

import com.sdetpro.driver.DriverBase;
import com.sdetpro.model.pages.LoginPage;
import com.sdetpro.model.pages.UserDashboardPage;
import com.sdetpro.utils.Url;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDriverInstances extends DriverBase {

    @Test
    public void testLoginWithCorrectCreds() {
        WebDriver driver = getDriver();
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage
            .inputUsername("Tomsmith")
            .inputPassword("SuperSecretPassword!")
            .clickOnLoginBtn();
        UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
        Assert.assertEquals(userDashboardPage.getLogoutBtn().isDisplayed(), true);

    }

    @Test
    public void testLoginWithIncorrectCreds() {
        WebDriver driver = getDriver();
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage
            .inputUsername("My Username")
            .inputPassword("My Password")
            .clickOnLoginBtn();
        UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
        Assert.assertEquals(userDashboardPage.getLogoutBtn().isDisplayed(), true);
    }

}
