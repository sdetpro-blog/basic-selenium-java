package com.sdetpro.test.task;

import org.testng.annotations.Test;

public class TaskCRUD {

    @Test(groups = {"smoke"})
    public void checkGeneralUITaskCRUD() {
        System.out.println("TaskCRUD checkGeneralUI - Smoke Test");
    }

    @Test(groups = {"regression"})
    public void loginWithCorrectCredsTaskCRUD() {
        System.out.println(" TaskCRUD loginWithCorrectCreds - function test");
    }
}
