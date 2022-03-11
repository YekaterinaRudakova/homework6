package com.it_academy.onliner.selenideTest;

import com.it_academy.onliner.selenide.page_object.CatalogPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AccessoriesDescriptionTest extends BaseTestSelenide {
    private static String CATALOG_URL = "https://catalog.onliner.by/";
    private static CatalogPage catalogPage = new CatalogPage();

    @DisplayName("Presence description of elements in Accessories section test")
    @Test
    public void testIfElementsDescription_PresentUnderEachElementsTitle() {
        catalogPage.open(CATALOG_URL);
        clearAndRefresh();
        List<String> accessoriesDescriptions = catalogPage
                .clickOnComputersAnsNetsSection()
                .clickOnAccessoriesSection()
                .getDescriptionOfAccessoriesElements();
        System.out.println(accessoriesDescriptions);
        assertThat(accessoriesDescriptions)
                .as("Each description of elements in section Accessories should contain p.")
                .anyMatch(element -> element.contains("р."));
    }
}
