package com.it_academy.onliner.seleniumGridTest;

import com.it_academy.onliner.seleniumGrid.page_object.OnlinerHomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CatalogElementsTest {
    private static OnlinerHomePage onlinerHomePage;

    @BeforeAll
    public static void navigateToOnlinerSite() {
        onlinerHomePage = new OnlinerHomePage();
        onlinerHomePage.navigateToInitialPage();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Presence elements in Catalog test")
    @Test
    public void testIfElements_PresentInCatalog() {
        List<String> catalogElements = onlinerHomePage.clickOnCatalogLink()
                .getListOfCatalogElements();

        System.out.println(catalogElements);

        assertThat(catalogElements.iterator())
                .as("Catalog elements are not presented")
                .isNotNull()
                .hasNext();
    }

    @AfterAll
    public static void closeBrowser() {
        onlinerHomePage.closeBrowser();
    }
}
