package com.sdetpro.core.test;


import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;

public interface CommonTestMethods {

    default Runner start(String url, WebDriver driver) {
        return new Runner(url, driver);
    }

    public static class Runner {

        private final String url;
        private final WebDriver driver;

        public Runner(String url, WebDriver driver) {
            this.url = url;
            this.driver = driver;
        }

        public WebDriver driver(){
            return this.driver;
        }

        public Runner loadUrl() {
            driver.manage().window().maximize();
            driver.get(this.url);
            return this;
        }

        public void runTest(Consumer<Runner> test) {
            test.accept(this);
        }
    }
}
