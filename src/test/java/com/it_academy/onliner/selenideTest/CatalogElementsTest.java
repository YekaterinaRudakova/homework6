package com.it_academy.onliner.selenideTest;

import com.it_academy.onliner.selenide.page_object.OnlinerHomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CatalogElementsTest extends BaseTestSelenide {
    private static String ONLINER_WEBSITE_URL = "https://www.onliner.by/";
    private static OnlinerHomePage onlinerHomePage = new OnlinerHomePage();


    @DisplayName("Presence elements in Catalog test")
    @Test
    public void testIfElements_PresentInCatalog() {
        onlinerHomePage.open(ONLINER_WEBSITE_URL);
        clearAndRefresh();
        List<String> catalogElements = onlinerHomePage.clickOnCatalogLink()
                .getListOfCatalogElements();
        assertThat(catalogElements.iterator())
                .as("Catalog elements are not presented")
                .isNotNull()
                .hasNext();
    }
}
