package ua.ithillel.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitUntilElementIsVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProvider.IMPLICITLY_WAIT));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    public static void waitForElementToDisappear(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigProvider.IMPLICITLY_WAIT));
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(by)));
    }
}
