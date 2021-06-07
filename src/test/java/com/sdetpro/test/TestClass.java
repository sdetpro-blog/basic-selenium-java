package com.sdetpro.test;

import org.testng.annotations.Test;

public class TestClass extends ExampleCommonMethod {

    @Test
    public void testSth() {
        test(driver -> { // This is a lambda expression considered as StandardTest
            start(System.getenv("testingUrl"), driver) // This one return a Runner instance
                .loadUrl() // method in Runner
                .runTest(sampleTest); // Method in runner
        });
    }

    @Test
    public void testSthElse() {
        test(driver ->
            start(System.getenv("testingUrl"), driver)
                .loadUrl()
                .runTest(sampleTest)
        );
    }
}
