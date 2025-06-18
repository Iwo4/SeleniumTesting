package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By storiesLocator = By.xpath("(//div[@class='css-rf6n7v'])[1]");
    private By vocabLocator = By.xpath("(//div[@class='css-rf6n7v'])[2]");
    private By triviaLocator = By.xpath("(//div[@class='css-rf6n7v'])[3]");
    private By easygermanLocator = By.xpath("//div[@class='css-e6hd45']");
    private By discussLocator = By.xpath("(//div[@class='css-rf6n7v'])[4]");
    private By profileLogoLocator = By.xpath("(//div[@class='css-1y9b2ry'])[2]");
    private By signOutButtonLocator = By.xpath("//div[@class='css-rpivlm']");
    private By myReviewsCardLocator = By.xpath("//div[@class='css-1d3g393']");
    private By numberOfCardsLocator = By.xpath("//div[@class='text css-f89qar']");
    private By openDeckButtonLocator = By.xpath("//button[@class=' css-3oh3g9']");
    private By helpButtonLocator = By.xpath("//div[@class='css-7lgd04']");
    private By showAnswerButtonLocator = By.xpath("//div[@class='css-5r61c8']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //    Header menu:
    public boolean isStoriesMenuVisible() {
        return isDisplayed(storiesLocator);
    }

    public boolean isVocabMenuVisible() {
        return isDisplayed(vocabLocator);
    }

    public boolean isTriviaMenuVisible() {
        return isDisplayed(triviaLocator);
    }

    public boolean isEasyGermanMenuVisible() {
        return isDisplayed(easygermanLocator);
    }

    public boolean isDiscussMenuVisible() {
        return isDisplayed(discussLocator);
    }

    public boolean isLogoutButtonDisplayed() {
        waitForElement(profileLogoLocator).click();
        return isDisplayed(signOutButtonLocator);
    }

    //    Reviews section:
    public boolean isMyReviewsCardDisplayed() {
        waitForElement(myReviewsCardLocator);
        return isDisplayed(myReviewsCardLocator);
    }

    public String getNumberOfCards() {
        return driver.findElement(numberOfCardsLocator).getText();
    }

    public boolean areButtonsInMyReviewsCardDisplayed() {
        waitForElement(myReviewsCardLocator).click();
        waitForElement(openDeckButtonLocator).click();
        waitForElement(helpButtonLocator);
        return isDisplayed(helpButtonLocator) && isDisplayed(showAnswerButtonLocator);
    }


}
