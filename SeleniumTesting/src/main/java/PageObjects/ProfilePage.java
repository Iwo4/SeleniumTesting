package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    private By profileNameLocator = By.xpath("//div[@class='css-2dse8b']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileName() {
        return getText(profileNameLocator);
    }
}
