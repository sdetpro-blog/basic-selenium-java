package com.sdetpro.test;

import com.sdetpro.model.pages.LoginPage;
import com.sdetpro.utils.Webdriver;
import org.openqa.selenium.WebDriver;

public class TestLoginWithPOM {

    public static void main(String[] args) {
        WebDriver driver = Webdriver.getChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);
//        loginPage.username().sendKeys("Tomsmith");
//        loginPage.password().sendKeys("SuperSecretPassword!");
//        loginPage.loginBtn().click();

//        loginPage.inputUsername("my username");
//        loginPage.inputPassword("my password");
//        loginPage.clickOnLoginBtn();
//
//        String loginBtnColor = loginPage.loginBtn().getCssValue("background-color");
//        System.out.println("Login Btn Color: " + loginBtnColor);

        loginPage
                .inputUsername("My Username")
                .inputPassword("My Password")
                .clickOnLoginBtn();
    }
}
