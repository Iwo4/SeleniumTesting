package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test
    public void signOutButtonVisibilityTest(){
        loginPage.performSuccessfulLogin();
        Assert.assertTrue(mainPage.isLogoutButtonDisplayed());
    }

    @Test
    public void profileNameCheckTest(){
        loginPage.performSuccessfulLogin();
    }
}
