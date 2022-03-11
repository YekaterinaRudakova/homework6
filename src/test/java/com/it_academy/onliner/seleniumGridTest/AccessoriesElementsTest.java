package com.it_academy.onliner.seleniumGridTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AccessoriesElementsTest extends BaseTestSeleniumGrid {
    @DisplayName("Presence elements in Accessories section test")
    @Test
    public void testIfElements_PresentInAccessoriesSection() {
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
