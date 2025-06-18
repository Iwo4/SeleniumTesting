package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By profileLogoLocator = By.xpath("(//div[@class='css-1y9b2ry'])[2]");
    private By signOutButtonLocator = By.xpath("//div[@class='css-rpivlm']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutButtonDisplayed() {
        waitForElement(profileLogoLocator).click();
        return isDisplayed(signOutButtonLocator);
    }

}
