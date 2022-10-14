package ua.ithillel.docker;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.ithillel.browser.WebDriverProviderLazy;
import ua.ithillel.model.User;
import ua.ithillel.utils.ConfigProvider;


public class RegisterUser {
    private WebDriver driver;

    @BeforeTest
    public void BeforeTest() {
        driver = WebDriverProviderLazy.getInstance().getDriver();
    }

    @Test
    public void RegisterTest() {
        Faker faker = new Faker();
        User user = User.builder()
                .setUserName(faker.name().username())
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password())
                .build();
        driver.navigate().to(ConfigProvider.BASE_URL);

        driver.findElement(By.id("register")).findElement(By.xpath("./child::*")).click();

        driver.findElements(By.name("username")).get(1).sendKeys(user.getUserName());
        driver.findElements(By.name("first-name")).get(0).sendKeys(user.getFirstName());
        driver.findElement(By.name("last-name")).sendKeys(user.getLastName());
        driver.findElement(By.name("email")).sendKeys(user.getEmail());
        driver.findElements(By.name("password")).get(1).sendKeys(user.getPassword());
        driver.findElements(By.className("btn")).get(2).click();

        Assert.assertEquals(driver.findElement(By.id("registration-message")).getText(), "Registration and login successful.");
    }

    @AfterTest
    public void AfterTest() {
        driver.quit();
    }
}