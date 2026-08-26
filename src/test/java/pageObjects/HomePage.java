package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static constants.Constants.BASE_URL;

public class HomePage extends BasePage{
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Home Page")
    public void openHomePage() {
        driver.get(BASE_URL);
    }

    @Step("Get Home Page URL")
    public String getHomePageUrl() {
        return BASE_URL;
    }

    @Step("Get Home Page Title")
    public String getHomePageTitle() {
        return driver.getTitle();
    }
}
