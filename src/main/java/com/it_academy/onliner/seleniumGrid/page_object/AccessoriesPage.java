package com.it_academy.onliner.seleniumGrid.page_object;

import com.it_academy.onliner.seleniumGrid.navigatition.OnlinerNavigationUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccessoriesPage extends BasePage {
    private static final By ACCESSORIES_ELEMENTS_XPATH_PATTERN =
            By.xpath("//*[@class = 'catalog-navigation-list__dropdown-list']//*[@class = 'catalog-navigation-list__dropdown-title']");

    private static final By ACCESSORIES_ELEMENTS_DESCRIPTION_XPATH_PATTERN =
            By.xpath("//*[@class='catalog-navigation-list__aside-title' " +
                    "and contains(text(),'Комплектующие')]" +
                    "//following-sibling::div[@class='catalog-navigation-list__dropdown']" +
                    "//a//span[contains(@class, 'list__dropdown-description') and contains(text(), 'товар')]");

    public AccessoriesPage() {
        super();
    }

    public AccessoriesPage(BasePage basePage) {
        super(basePage);
    }

    public List<String> getListOfAccessoriesElements() {
        List<WebElement> webElements = findElements(ACCESSORIES_ELEMENTS_XPATH_PATTERN);
        List<String> stringOfAllElements = new ArrayList<>();
        webElements.stream().map(WebElement::getText).forEach(stringOfAllElements::add);
        return stringOfAllElements.stream().skip(162).limit(13).toList();
    }

    public List<String> getDescriptionOfAccessoriesElements() {
        List<WebElement> webElements = findElements(ACCESSORIES_ELEMENTS_DESCRIPTION_XPATH_PATTERN);
        List<String> stringOfAllElements = new ArrayList<>();
        webElements.stream().map(WebElement::getText).forEach(stringOfAllElements::add);
        return stringOfAllElements.stream().limit(13).toList();
    }

    @Override
    public void navigateToInitialPage() {
        navigate(OnlinerNavigationUrls.CATALOG_PAGE_URL);
    }
}
