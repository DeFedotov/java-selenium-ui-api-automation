package pageObjects;

import org.openqa.selenium.WebDriver;

import static constants.Constants.BASE_URL;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(BASE_URL);
    }

    public String getHomePageUrl() {
        return BASE_URL;
    }
}
