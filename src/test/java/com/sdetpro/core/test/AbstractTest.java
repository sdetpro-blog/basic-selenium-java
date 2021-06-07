package com.sdetpro.core.test;

import com.sdetpro.driver.DriverBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTest extends DriverBase {

    protected void test(StandardTest standardTest) {
        WebDriver driver = getDriver();

        standardTest.test(driver);

        try {
            standardTest.test(driver);
        } catch (Throwable throwable) {
            // Error Handler here before throw the err
            System.out.println("\n\n");
            System.out.println("The error IS: " + throwable);
            System.out.println("\n\n");
            throw throwable;
        } finally {
            // 1. Get the test method name
            String testMethod = standardTest.getClass().getMethods()[0].getName();

            // 2. Declare File location
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);

            String takenTime = y + "-" + (month+1) + "-" + day + "-" + hr + "-" + min + "-" + sec;

            String fileLocation = System.getProperty("user.dir") + "/screenshots/" + testMethod + "-" + takenTime + ".png";

            // 3. Save screenshot to the system
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShot, new File(fileLocation));
            } catch (Exception e){
                e.printStackTrace();
            }
//            driver.quit();
        }
    }

    @FunctionalInterface
    protected interface StandardTest {
        void test(WebDriver driver);
    }
}
