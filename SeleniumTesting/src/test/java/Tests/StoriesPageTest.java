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
}
