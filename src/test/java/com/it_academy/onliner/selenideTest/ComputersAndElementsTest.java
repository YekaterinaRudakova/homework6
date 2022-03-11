package com.it_academy.onliner.selenideTest;

import com.it_academy.onliner.selenide.page_object.CatalogPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ComputersAndElementsTest extends BaseTestSelenide {
    private static String CATALOG_URL = "https://catalog.onliner.by/";
    private static CatalogPage catalogPage = new CatalogPage();

    @DisplayName("Presence elements in Computers and nets section test")
    @Test
    public void testIfElementsPresent_InComputersAndNetsSection() {
        catalogPage.open(CATALOG_URL);
        clearAndRefresh();
        List<String> computersAndNetsElements = catalogPage
                .clickOnComputersAnsNetsSection()
                .getListOfComputersAndNetsElements();
        assertThat(computersAndNetsElements.iterator())
                .as("Computers and nets elements are not presented")
                .isNotNull()
                .hasNext();
    }
}
