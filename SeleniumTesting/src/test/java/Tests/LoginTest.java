package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        loginPage.performSuccessfulLogin();
        loginPage.waitForWelcomePage();
        Assert.assertEquals(loginPage.getUrl(), "https://seedlang.com/reviews/home");
        Assert.assertTrue(mainPage.isLogoutButtonDisplayed());
    }

    @Test
    public void incorrectEmailTest(){
        loginPage.visitLoginPage();
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys("@@@@");
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("123");
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Sorry, there is no account with that email address.");
    }

    @Test
    public void incorrectPasswordTest(){
        loginPage.visitLoginPage();
        loginPage.enterUsername();
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("123");
        loginPage.clickSignInButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Sorry, that is an incorrect password. Please try again.");
    }
}
