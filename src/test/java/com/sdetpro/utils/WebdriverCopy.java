package com.sdetpro.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class WebdriverCopy {

    public static WebDriver getChromeDriver() {
        // For chrome driver
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "/src/test/chromedriver/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        return new ChromeDriver();


        // For FF driver
//        String path = System.getProperty("user.dir");
//        String firefoxDriverPath = path + "/selenium-grid/geckodriver";
//        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
//        return new FirefoxDriver();

        // For MicrosoftEdge | Can't run in parallel
//        String path = System.getProperty("user.dir");
//        String edgeDriverPath = path + "/selenium-grid/geckodriver";
//        System.setProperty("webdriver.edge.driver", edgeDriverPath);
//        return new EdgeDriver();

        // For Safari Driver | Can't run in parallel
//        return new SafariDriver();
    }
}
