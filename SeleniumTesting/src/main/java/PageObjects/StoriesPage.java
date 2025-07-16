package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoriesPage extends MainPage {
    private By storiesLocator = By.xpath("(//div[@class='css-rf6n7v'])[1]");
    public By foundationalSectionLocator = By.xpath("//div[normalize-space(text())='Foundational']");
    private By firstVocabTrainersLocator = By.xpath("(//div[@class='css-1gx2rap'])[2]");
    private By earlyIntermediateSectionLocator = By.xpath("(//div[@class='css-1gx2rap'])[3]");
    private By secondVocabTrainersLocator = By.xpath("(//div[@class='css-1gx2rap'])[4]");
    private By intermediateSectionLocator = By.xpath("(//div[@class='css-1gx2rap'])[5]");
    private By thirdVocabTrainersLocator = By.xpath("(//div[@class='css-1gx2rap'])[6]");
    private By upperIntermediateSectionLocator = By.xpath("(//div[@class='css-1gx2rap'])[7]");
    private By fourthVocabTrainersLocator = By.xpath("(//div[@class='css-1gx2rap'])[8]");
    public By greetingsStoryLocator = By.xpath("//a[@id='1ed89cd0-7d14-4e60-aa6e-d29df74659f1']");
    private By pricesStoryLocator = By.xpath("//a[@id='8ead5b7a-b929-4fb3-93bf-2c438102dccd']");
    private By lunchTimeStoryLocator = By.xpath("//a[@id='a7f49eb2-dbbf-4667-ac92-166131e815aa']");
    private By losingKeysStoryLocator = By.xpath("//a[@id='469f3bc3-8b06-4f70-a390-31b04a34e284']");
    private By decksTabLocator = By.xpath("//div[text()='Decks']");
    private By vocabTabLocator = By.xpath("(//div[text()='Vocab'])[2]");
    private By grammarTabLocator = By.xpath("//div[text()='Grammar']");
    private By greetingsStartDeckLocator = By.xpath("(//div[@class='css-1bnyyey'])[1]");
    private By introductionsDeckLocator = By.xpath("//div[text()='Introductions']");
    private By kitchenDeckLocator = By.xpath("//div[normalize-space(text())='Kitchen']");

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

    public void openStory(By element) {
        waitForElement(element);
        driver.findElement(element).click();
    }

    public boolean areGreetingDecksTabsWorking() {
        waitForElement(decksTabLocator);
        driver.findElement(vocabTabLocator).click();
        driver.findElement(grammarTabLocator).click();
        driver.findElement(decksTabLocator).click();
        return isDisplayed(greetingsStartDeckLocator);
    }

    public boolean isSectionOpen(By section) {
        WebElement sectionElement = waitForElement(section);
        try {
            WebElement icon = sectionElement.findElement(By.tagName("i"));
            String iconClass = icon.getAttribute("class");
            return iconClass.contains("fa-minus"); // means section is open
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isInstructionDeckVisible() {
        waitForElementClickable(foundationalSectionLocator);
        if (!isSectionOpen(foundationalSectionLocator)) {
            driver.findElement(foundationalSectionLocator).click();
        }
        return isDisplayed(introductionsDeckLocator);
    }

    public boolean isKitchenDeckVisible() {
        waitForElementClickable(upperIntermediateSectionLocator);
        if (!isSectionOpen(upperIntermediateSectionLocator)) {
            driver.findElement(upperIntermediateSectionLocator).click();
        }
        return isDisplayed(kitchenDeckLocator);
    }

    public void expandAllSelections() {
        waitForElementClickable(fourthVocabTrainersLocator);
        if (!isSectionOpen(foundationalSectionLocator)) {
            driver.findElement(foundationalSectionLocator).click();
        }
        if (!isSectionOpen(earlyIntermediateSectionLocator)) {
            driver.findElement(earlyIntermediateSectionLocator).click();
        }
        if (!isSectionOpen(intermediateSectionLocator)) {
            driver.findElement(intermediateSectionLocator).click();
        }
        if (!isSectionOpen(upperIntermediateSectionLocator)) {
            driver.findElement(upperIntermediateSectionLocator).click();
        }

        if (!isSectionOpen(firstVocabTrainersLocator)) {
            driver.findElement(firstVocabTrainersLocator).click();
        }
        if (!isSectionOpen(secondVocabTrainersLocator)) {
            driver.findElement(secondVocabTrainersLocator).click();
        }
        if (!isSectionOpen(thirdVocabTrainersLocator)) {
            driver.findElement(thirdVocabTrainersLocator).click();
        }
        if (!isSectionOpen(fourthVocabTrainersLocator)) {
            driver.findElement(fourthVocabTrainersLocator).click();
        }
    }

}
