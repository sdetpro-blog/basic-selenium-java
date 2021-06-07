package com.sdetpro.test.authen;

import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class SSOLogin {

    @Ignore
    @Test(groups = {"regression"})
    public void anExistingTestMethod(){
        System.out.println("Step 01");
        System.out.println("Step 02");

    }

    @Test(groups = {"smoke"})
    public void checkGeneralUISSOLogin() {
        System.out.println("SSOLogin checkGeneralUI - Smoke Test");
    }

    @Test(groups = {"regression"})
    public void loginWithCorrectCredsSSOLogin() {
        System.out.println(" SSOLogin loginWithCorrectCreds - function test");
    }

}
