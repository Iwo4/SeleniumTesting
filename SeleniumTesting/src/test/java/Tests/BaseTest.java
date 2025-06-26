package Tests;

import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.StoriesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected StoriesPage storiesPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
            default:
                driver = new ChromeDriver();
                break;
        }
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        storiesPage = new StoriesPage(driver);
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//    }
}
