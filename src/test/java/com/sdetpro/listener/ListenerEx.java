package com.sdetpro.listener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

public class ListenerEx extends TestListenerAdapter implements ITestListener, ISuiteListener {


    @Override
    public void onTestFailure(ITestResult result){

        // 1. Get the test Method name
        String testMethod = result.getName();

        // 2. Declare the file location
        String fileLocation = System.getProperty("user.dir") + "/screenshot/" + testMethod + ".png";

        // 3. Declare the file name

        // 4. Save the screenshot to the system
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShot, new File(fileLocation));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onFinish(ITestContext context) {
        System.out.println("SUITE finished");
    }
}
