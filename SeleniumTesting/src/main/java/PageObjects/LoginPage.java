package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By emailFieldLocator = By.xpath("//input[@type='email']");
    private By passwordFieldLocator = By.xpath("//input[@type='password']");
    private By signInButtonLocator = By.xpath("//button[@class=' css-1kqvten']");
    private By welcomePageLocator = By.xpath("//div[@class='css-16jqoyn']");
    private By errorMessageLocator = By.xpath("//div[@class='css-qgjc6s']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void visitLoginPage() {
        super.visit("https://seedlang.com/onboarding/sign_in");
        waitForElement(emailFieldLocator);
    }

    public void enterUsername() {
        String username = System.getenv("LOGIN_USERNAME");
        driver.findElement(emailFieldLocator).sendKeys(username);
    }

    public void enterPassword() {
        String password = System.getenv("LOGIN_PASSWORD");
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButtonLocator).click();
    }

    public void performLogin() {
        enterUsername();
        enterPassword();
        clickSignInButton();
    }

    public void waitForWelcomePage() {
        waitForElement(welcomePageLocator);
    }

    public String getErrorMessage() {
        WebElement message = waitForElement(errorMessageLocator);
        return message.getText();
    }

    public void performSuccessfulLogin() {
        visitLoginPage();
        performLogin();
        waitForWelcomePage();
    }
}
