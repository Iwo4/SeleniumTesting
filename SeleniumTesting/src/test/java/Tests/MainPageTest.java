package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {

    @Test
    public void signOutButtonVisibilityTest() {
        loginPage.performSuccessfulLogin();
        Assert.assertTrue(mainPage.isLogoutButtonDisplayed());
    }

    @Test
    public void menuItemsTest() {
        loginPage.performSuccessfulLogin();
        Assert.assertTrue(mainPage.isStoriesMenuVisible());
        Assert.assertTrue(mainPage.isVocabMenuVisible());
        Assert.assertTrue(mainPage.isTriviaMenuVisible());
        Assert.assertTrue(mainPage.isEasyGermanMenuVisible());
        Assert.assertTrue(mainPage.isDiscussMenuVisible());

    }

    @Test
    public void myReviewsSectionTest() {
        loginPage.performSuccessfulLogin();
        Assert.assertTrue(mainPage.isMyReviewsCardDisplayed());
        Assert.assertEquals(mainPage.getNumberOfCards(), "630 Cards");
        Assert.assertTrue(mainPage.areButtonsInMyReviewsCardDisplayed());
    }
}
