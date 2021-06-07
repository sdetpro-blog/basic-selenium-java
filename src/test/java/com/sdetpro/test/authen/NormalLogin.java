package com.sdetpro.test.authen;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NormalLogin {

    @Test(groups = {"smoke"})
    public void checkGeneralUI() {
        System.out.println("checkGeneralUI - Smoke Test");
    }

    @Test(groups = {"regression"})
    public void loginWithCorrectCreds() {
        Assert.fail("Marked the test fail for debugging!");
        System.out.println("loginWithCorrectCreds - function test");
    }
}
