package com.it_academy.onliner.selenideTest;

import com.it_academy.onliner.selenide.page_object.CatalogPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AccessoriesElementsTest extends BaseTestSelenide {
    private static String CATALOG_URL = "https://catalog.onliner.by/";
    private static CatalogPage catalogPage = new CatalogPage();

    @DisplayName("Presence elements in Accessories section test")
    @Test
    public void testIfElements_PresentInAccessoriesSection() {
        catalogPage.open(CATALOG_URL);
        clearAndRefresh();
        List<String> accessoriesElements = catalogPage
                .clickOnComputersAnsNetsSection()
                .clickOnAccessoriesSection()
                .getListOfAccessoriesElements();
        System.out.println(accessoriesElements);
        assertThat(accessoriesElements.iterator())
                .as("Accessories elements are not presented")
                .isNotNull()
                .hasNext();
    }
}
