package com.sdetpro.test;

import com.sdetpro.core.test.AbstractTest;
import com.sdetpro.core.test.CommonTestMethods;
import com.sdetpro.draftpages.Login;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.function.Consumer;

public class ExampleCommonMethod extends AbstractTest implements CommonTestMethods {

    public Consumer<Runner> sampleTest = runner -> {
        WebDriver driver = runner.driver();
        Login loginPage = new Login(driver);
        runner.driver().get("https://the-internet.herokuapp.com/login");

        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickOnLoginBtn();
        Assert.fail();
    };

}
