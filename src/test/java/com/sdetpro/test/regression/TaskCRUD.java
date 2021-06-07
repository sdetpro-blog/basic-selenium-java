package com.sdetpro.test.regression;

import com.sdetpro.model.pages.LoginPage;
import com.sdetpro.model.pages.UserDashboardPage;
import com.sdetpro.test.ExampleCommonMethod;
import com.sdetpro.utils.Url;
import com.sdetpro.utils.Webdriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TaskCRUD extends ExampleCommonMethod {

    @Test()
    public void loginWithCorrectCredentials() {
        WebDriver driver = Webdriver.getChromeDriver();
        SoftAssert softAssert = new SoftAssert();

        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage
            .inputUsername("tomsmith")
            .inputPassword("SuperSecretPassword!")
            .clickOnLoginBtn();

        UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
        String expectedPageHeader = "Secure Area";
        String actualPageHeader = userDashboardPage.getPageHeaderSelector().getText();
        softAssert.assertEquals(actualPageHeader, expectedPageHeader, "ERR | Page Header is wrong!");
        softAssert.assertTrue(userDashboardPage.getLogoutBtn().isDisplayed(), "ERR | Logout button is not displayed");

        // Close browser all assert All verification points
        driver.close();
        softAssert.assertAll();
    }

    @Test()
    public void loginWithIncorrectCredentials() {
        WebDriver driver = Webdriver.getChromeDriver();
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage
            .inputUsername("tomsmith")
            .inputPassword("......")
            .clickOnLoginBtn();
        driver.close();
    }
}
