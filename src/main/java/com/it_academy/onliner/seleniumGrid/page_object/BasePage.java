package com.it_academy.onliner.seleniumGrid.page_object;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private String GRID_URL = "http://localhost:4444";
    private int DRIVER_WAIT_TIME = 20;
    protected WebDriver driver;
    protected DesiredCapabilities desiredCapabilities;
    protected String BROWSER_NAME="chrome";

    public BasePage() {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(BROWSER_NAME);
        try {
            driver = new RemoteWebDriver(new URL(GRID_URL), desiredCapabilities);
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public BasePage(BasePage page) {
        driver = page.driver;
        desiredCapabilities = page.desiredCapabilities;
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public abstract void navigateToInitialPage();

    public void navigate(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public WebElement waitForElementToBeClickable(WebElement webElement) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(DRIVER_WAIT_TIME));
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
