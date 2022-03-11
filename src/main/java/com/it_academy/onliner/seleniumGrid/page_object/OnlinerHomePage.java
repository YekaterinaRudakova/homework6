package com.it_academy.onliner.seleniumGrid.page_object;

import com.it_academy.onliner.seleniumGrid.navigatition.OnlinerNavigationUrls;
import org.openqa.selenium.By;

public class OnlinerHomePage extends BasePage {

    protected static final By CATALOG_LINK_XPATH_PATTERN =
            By.xpath("//*[contains(@class, 'b-main-page-blocks-header-2 cfix')]//a[contains(text(), 'Каталог')]");

    public OnlinerHomePage() {
        super();
    }

    public OnlinerHomePage(BasePage basePage) {
        super(basePage);
    }

    public CatalogPage clickOnCatalogLink() {
        waitForElementToBeClickable(findElement(CATALOG_LINK_XPATH_PATTERN)).click();
        return new CatalogPage(this);
    }

    @Override
    public void navigateToInitialPage() {
        navigate(OnlinerNavigationUrls.HOME_PAGE_URL);
    }
}
