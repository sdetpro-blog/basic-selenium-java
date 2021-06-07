package com.sdetpro.test.smoke;

import com.sdetpro.model.pages.LoginPage;
import com.sdetpro.model.pages.UserDashboardPage;
import com.sdetpro.utils.Url;
import com.sdetpro.utils.Webdriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {

    @Test
    public void registerUser(){
        System.out.println("Registering the user....");
    }

    @Test(dependsOnMethods = "registerUser")
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
        softAssert.assertAll();
    }

}
