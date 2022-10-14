package ua.ithillel.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.ithillel.browser.WebDriverFactory;

import java.time.Duration;

public class BaseUITests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test() {
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElements(By.name("btnK")).get(1).click();
        Assert.assertEquals(driver.getTitle(), "webdriver - Google Search");
    }

    @AfterTest
    public void stop() {
        driver.quit();
    }
}
