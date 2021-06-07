package com.sdetpro.test.task;

import org.testng.annotations.Test;

public class TaskManagement {

    @Test(groups = {"smoke"})
    public void checkGeneralUITaskManagement() {
        System.out.println("TaskManagement checkGeneralUI - Smoke Test");
    }

    @Test(groups = {"regression"})
    public void loginWithCorrectCredsTaskManagement() {
        System.out.println(" TaskManagement loginWithCorrectCreds - function test");
    }
}
