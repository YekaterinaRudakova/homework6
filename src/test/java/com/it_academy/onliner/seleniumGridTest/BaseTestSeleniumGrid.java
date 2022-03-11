package com.it_academy.onliner.seleniumGridTest;

import com.it_academy.onliner.seleniumGrid.page_object.CatalogPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTestSeleniumGrid {
    protected static CatalogPage catalogPage;

    @BeforeAll
    public static void navigateToOnlinerSite() {
        catalogPage = new CatalogPage();
        catalogPage.navigateToInitialPage();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void closeBrowser() {
        catalogPage.closeBrowser();
    }
}
