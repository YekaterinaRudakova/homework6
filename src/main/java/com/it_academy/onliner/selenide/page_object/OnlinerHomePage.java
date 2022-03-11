package com.it_academy.onliner.selenide.page_object;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OnlinerHomePage extends BasePage {

    private static final SelenideElement CATALOG_LINK = $x("//*[contains(@class, " +
            "'b-main-page-blocks-header-2 cfix')]//a[contains(text(), 'Каталог')]");

    public CatalogPage clickOnCatalogLink() {
        waitAndClick(CATALOG_LINK);
        return new CatalogPage();
    }
}
