package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoriesPage extends MainPage {
    private By storiesLocator = By.xpath("(//div[@class='css-rf6n7v'])[1]");
    private By foundationalSectionLocator = By.xpath("(//div[@class='css-1gx2rap'])[1]");
    private By firstVocabTrainersLocator = By.xpath("(//div[@class='css-1gx2rap'])[2]");
    private By earlyIntermediateSectionLocator = By.xpath("(//div[@class='css-1gx2rap'])[3]");
    private By secondVocabTrainersLocator = By.xpath("(//div[@class='css-1gx2rap'])[4]");
    private By intermediateSectionLocator = By.xpath("(//div[@class='css-1gx2rap'])[5]");
    private By thirdVocabTrainersLocator = By.xpath("(//div[@class='css-1gx2rap'])[6]");
    private By upperIntermediateSectionLocator = By.xpath("(//div[@class='css-1gx2rap'])[7]");
    private By fourthVocabTrainersLocator = By.xpath("(//div[@class='css-1gx2rap'])[8]");
    private By greetingsStoryLocator = By.xpath("//a[@id='1ed89cd0-7d14-4e60-aa6e-d29df74659f1']");
    private By pricesStoryLocator = By.xpath("//a[@id='8ead5b7a-b929-4fb3-93bf-2c438102dccd']");
    private By lunchTimeStoryLocator = By.xpath("//a[@id='a7f49eb2-dbbf-4667-ac92-166131e815aa']");
    private By losingKeysStoryLocator = By.xpath("//a[@id='469f3bc3-8b06-4f70-a390-31b04a34e284']");

    public StoriesPage(WebDriver driver) {
        super(driver);
    }

    public void openStoriesPage() {
        visit("https://seedlang.com/stories/home");
//        driver.findElement(storiesLocator).click();
    }

    public boolean isAllLevelSelectionVisible() {
        waitForElement(upperIntermediateSectionLocator);
        return isDisplayed(foundationalSectionLocator)
                && isDisplayed(earlyIntermediateSectionLocator)
                && isDisplayed(intermediateSectionLocator)
                && isDisplayed(upperIntermediateSectionLocator);
    }

    public boolean isAllVocabTrainersVisible() {
        waitForElement(firstVocabTrainersLocator);
        return isDisplayed(fourthVocabTrainersLocator)
                && isDisplayed(secondVocabTrainersLocator)
                && isDisplayed(thirdVocabTrainersLocator)
                && isDisplayed(fourthVocabTrainersLocator);
    }

    public boolean areStoriesVisible() {
        waitForElement(foundationalSectionLocator);
        driver.findElement(foundationalSectionLocator).click();
        waitForElement(greetingsStoryLocator);
        return isDisplayed(greetingsStoryLocator)
                && isDisplayed(pricesStoryLocator)
                && isDisplayed(lunchTimeStoryLocator);
    }

    public void openLosingKeyStory() {
        waitForElement(losingKeysStoryLocator);
        driver.findElement(losingKeysStoryLocator).click();
    }

}
