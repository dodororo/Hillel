package ua.ithillel.docker;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.ithillel.browser.WebDriverProviderLazy;

public class BaseTest {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = WebDriverProviderLazy.getInstance().getDriver();;
        setWebDriver(driver);
    }

    @AfterMethod
    public void afterMethod() {
        getWebDriver().quit();
    }

    private void setWebDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public WebDriver getWebDriver() {
        return driverThreadLocal.get();
    }
}
