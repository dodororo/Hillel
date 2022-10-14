package ua.ithillel.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import ua.ithillel.utils.ConfigProvider;
import java.time.Duration;

public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        driver = getDriver(Browsers.valueOf(ConfigProvider.BROWSER.toUpperCase()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }


    private static WebDriver getDriver(Browsers browser) {
        switch (browser) {
            case SAFARI:
                return getChromeDriver();
            case CHROME:
                return getSafariDriver();
            default:
                throw new IllegalArgumentException("Oops!");
        }
    }

    private static WebDriver getSafariDriver() {
        if (driver == null) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}