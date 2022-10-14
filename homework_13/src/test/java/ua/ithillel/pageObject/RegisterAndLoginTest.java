package ua.ithillel.pageObject;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.ithillel.docker.BaseTest;
import ua.ithillel.model.User;
import ua.ithillel.pages.MainPage;

public class RegisterAndLoginTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.open();

        MainPage.RegisterForm registerForm = mainPage.clickRegister();
        User user = User.generateRandomUser();
        registerForm.fillRegisterForm(user);

        Assert.assertTrue(mainPage.isUserLoggedIn());
        MainPage main = new MainPage(getWebDriver());
        MainPage.LoginForm loginForm = main.logout();

        loginForm.login(user);
        Assert.assertTrue(mainPage.isUserLoggedIn());
    }
}
