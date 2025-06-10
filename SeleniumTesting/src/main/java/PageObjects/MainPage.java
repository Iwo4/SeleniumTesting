package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By logoutButtonLocator = By.xpath("//li[@class='on-click']");
    private By profileLogoLocator = By.xpath("(//div[@class='css-1y9b2ry'])[2]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutButtonDisplayed() {
        driver.findElement(profileLogoLocator).click();
        return isDisplayed(logoutButtonLocator);
    }
}
