package com.it_academy.onliner.seleniumGridTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ComputersAndElementsTest extends BaseTestSeleniumGrid {
    @DisplayName("Presence elements in Computers and nets section test")
    @Test
    public void testIfElementsPresent_InComputersAndNetsSection() {
        List<String> computersAndNetsElements = catalogPage
                .clickOnComputersAnsNetsSection()
                .getListOfComputersAndNetsElements();
        System.out.println(computersAndNetsElements);
        Iterator<String> computersAndNetsElementsIterator = computersAndNetsElements.iterator();
        assertThat(computersAndNetsElementsIterator)
                .as("Computers and nets elements are not presented")
                .isNotNull()
                .hasNext();
    }
}
