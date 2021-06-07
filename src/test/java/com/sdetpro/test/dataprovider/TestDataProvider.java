package com.sdetpro.test.dataprovider;

import com.sdetpro.driver.DriverBase;
import com.sdetpro.model.pages.LoginPage;
import com.sdetpro.model.pages.UserDashboardPage;
import com.sdetpro.utils.ExcelReaderUtil;
import com.sdetpro.utils.Url;
import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;

public class TestDataProvider extends DriverBase {

    @Test
    @Parameters({"browser"})
    public void loginWithCorrectCreds(String browser) {
        WebDriver driver = getDriver(browser);
        LoginPage loginPage = new LoginPage(driver);
        Assert.fail();
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
    }

    @Ignore
    @Description("USing the prepared data set for data driven testing on login feature")
    @Test(dataProvider = "loginData", description = "Login by using data set")
    public void login(String username, String password) throws MalformedURLException {
        System.out.println(username + "\t" + password);
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        loginPage
            .inputUsername(username)
            .inputPassword(password)
            .clickOnLoginBtn();
        String flashMsg = new UserDashboardPage(driver).getFlashMsgSelector().getText();
    }

    @Ignore
    @Description("USing the prepared data set for data driven testing on login feature")
    @Test(dataProvider = "loginData", description = "Login by using data set")
    public void login2(String username, String password) throws MalformedURLException {
        System.out.println(username + "\t" + password);
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        loginPage
                .inputUsername(username)
                .inputPassword(password)
                .clickOnLoginBtn();
        String flashMsg = new UserDashboardPage(driver).getFlashMsgSelector().getText();
    }

    @DataProvider
    public Object[][] loginData() {

        String excelFileName = "TestData.xlsx";
        File excelFileLocation = new File(System.getProperty("user.dir") + "/src/test/data/" + excelFileName);
        String sheetName = "Login";
        int startRowIndex = 1;
        int startColumnIndex = 0;
        ExcelReaderUtil excelReaderUtil = new ExcelReaderUtil(excelFileLocation, sheetName, startRowIndex, startColumnIndex);
        int totalRow = excelReaderUtil.getTotalRow();
        int totalColumn = excelReaderUtil.getTotalColumn();

        Object[][] loginData = new Object[totalRow - startRowIndex][totalColumn - startColumnIndex];
        for (int startRow = startRowIndex; startRow < totalRow; startRow++) {
            for (int startColumn = startColumnIndex; startColumn < totalColumn; startColumn++) {
                loginData[startRow - startRowIndex][startColumn] = excelReaderUtil.getCellValue(startRow, startColumn);
            }
        }

        return loginData;
    }
}
