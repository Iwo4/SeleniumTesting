package Tests;

import PageObjects.LoginPage;
import PageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    @Test
    public void login() {
        loginPage.visitLoginPage();
        loginPage.performLogin();
        loginPage.waitForWelcomePage();
        Assert.assertEquals(loginPage.getUrl(), "https://seedlang.com/reviews/home");
        Assert.assertTrue(mainPage.isLogoutButtonDisplayed());
    }
}
