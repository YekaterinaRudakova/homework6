package com.it_academy.onliner.selenideTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;

abstract public class BaseTestSelenide {


    private static void setUp() {
        Configuration.headless = false;
        Configuration.screenshots = false;
        Configuration.timeout = 5000;
        // можно в селениде запускать selenium Grid
        // Configuration.remote="http://localhost:4444";
        Configuration.browserSize = "1536x960";
    }

    @BeforeAll
    public static void init() {
        setUp();
    }

    @BeforeAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    public static void clearAndRefresh() {
        Selenide.localStorage().clear();
        Selenide.refresh();
    }
}
