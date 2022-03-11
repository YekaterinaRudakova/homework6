package com.it_academy.onliner.seleniumGrid.page_object;

import com.it_academy.onliner.seleniumGrid.navigatition.OnlinerNavigationUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComputersAndNetsPage extends BasePage {
    protected static final By COMPUTERS_AND_NETS_ELEMENTS_XPATH_PATTERN =
            By.xpath("//*[@class='catalog-navigation-list__aside-list']//*[@class='catalog-navigation-list__aside-title']");
    protected static final By ACCESSORIES_SECTION_XPATH_PATTERN =
            By.xpath("//*[contains(@class,'catalog-navigation-list__aside-title') and contains(text(), 'Комплектующие')]");

    public ComputersAndNetsPage() {
        super();
    }

    public ComputersAndNetsPage(BasePage basePage) {
        super(basePage);
    }

    public List<String> getListOfComputersAndNetsElements() {
        List<WebElement> webElements = findElements(COMPUTERS_AND_NETS_ELEMENTS_XPATH_PATTERN);
        List<String> stringOfAllElements = new ArrayList<>();
        webElements.stream().map(WebElement::getText).forEach(stringOfAllElements::add);
        return stringOfAllElements.stream().skip(13).limit(10).toList();
    }

    public AccessoriesPage clickOnAccessoriesSection() {
        waitForElementToBeClickable(findElement(ACCESSORIES_SECTION_XPATH_PATTERN)).click();
        return new AccessoriesPage(this);
    }

    @Override
    public void navigateToInitialPage() {
        navigate(OnlinerNavigationUrls.CATALOG_PAGE_URL);
    }
}
