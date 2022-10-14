package ua.ithillel.browser;

import org.openqa.selenium.WebDriver;

public class WebDriverProviderLazy {

    private static WebDriverProviderLazy instance;
    private final WebDriver driver;

    private WebDriverProviderLazy() {
        driver = WebDriverFactory.getDriver();
    }

    public static WebDriverProviderLazy getInstance() {
        if (instance == null) {
            instance = new WebDriverProviderLazy();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }
}