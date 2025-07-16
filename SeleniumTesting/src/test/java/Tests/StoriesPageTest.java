package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StoriesPageTest extends BaseTest {

    @Test
    public void visibilityOfMenuItemsTest() {
        loginPage.performSuccessfulLogin();
        storiesPage.openStoriesPage();
        Assert.assertTrue(storiesPage.isAllLevelSelectionVisible());
        Assert.assertTrue(storiesPage.isAllVocabTrainersVisible());
    }

    @Test
    public void foundationalSectionTest() {
        loginPage.performSuccessfulLogin();
        storiesPage.openStoriesPage();
        Assert.assertTrue(storiesPage.areStoriesVisible());
        storiesPage.openLosingKeyStory();
        Assert.assertEquals(storiesPage.getUrl(), "https://seedlang.com/topics/469f3bc3-8b06-4f70-a390-31b04a34e284");
    }

    @Test
    public void greetingsStoryTest() {
        loginPage.performSuccessfulLogin();
        storiesPage.openStoriesPage();
        storiesPage.openStory(storiesPage.greetingsStoryLocator);
        Assert.assertEquals(storiesPage.getUrl(), "https://seedlang.com/topics/1ed89cd0-7d14-4e60-aa6e-d29df74659f1");
        Assert.assertTrue(storiesPage.areGreetingDecksTabsWorking());
    }

    @Test
    public void sectionExpandingTest() throws InterruptedException {
        loginPage.performSuccessfulLogin();
        storiesPage.openStoriesPage();
        Assert.assertTrue(storiesPage.isInstructionDeckVisible());
        Assert.assertTrue(storiesPage.isKitchenDeckVisible());
    }

    @Test
    public void expandingAllSelectionsTest() {
        loginPage.performSuccessfulLogin();
        storiesPage.openStoriesPage();
        storiesPage.expandAllSelections();
        Assert.assertTrue(storiesPage.isKitchenDeckVisible());
    }
}
