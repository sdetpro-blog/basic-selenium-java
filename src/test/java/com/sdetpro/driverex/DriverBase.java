package com.sdetpro.driverex;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class DriverBase {

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;

    @BeforeSuite(alwaysRun = true)
    public static void instantiateDriverObject() {
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webDriverThread = new DriverFactory();
            webDriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    @AfterSuite(alwaysRun = true)
    public static void clearCookies() {
        for (DriverFactory webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }

    public static WebDriver getDriver() {
        return driverThread.get().getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        getDriver().manage().deleteAllCookies();
        if (result.getStatus() == ITestResult.FAILURE) {
            // 1. Get the test Method name
            String testMethod = result.getName();

            // 2. Declare the file location
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH);
            int d = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            String dateTaken = y + "-" + (m + 1) + "-" + d + "-" + hr + "-" + min + "-" + sec;
            String fileLocation = System.getProperty("user.dir") + "/screenshot/" + testMethod + "_"+ dateTaken + ".png";

            // 3. Declare the file name

            // 4. Save the screenshot to the system
            File screenShot = ((TakesScreenshot) driverThread.get().getDriver()).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenShot, new File(fileLocation));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
