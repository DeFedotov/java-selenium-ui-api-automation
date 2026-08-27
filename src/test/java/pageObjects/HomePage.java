package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BasePage{
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    By chapterLocator = By.cssSelector("h5.card-title");
    By linkLocator = By.xpath("./../a");

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

    @Step("Count all chapters on Home Page")
    public int countChapters(){
        int qtyChapters = 0;
        List<WebElement> chapters = driver.findElements(chapterLocator);
        for (WebElement chapter : chapters) {
            qtyChapters += 1;
        }
        return qtyChapters;
    }

    @Step("Count and click all Home Page chapters links")
    public int countAndClickLinks() {
        int qtyLinks = 0;
        List<WebElement> chapters = driver.findElements(chapterLocator);
        for (WebElement chapter : chapters) {
            List<WebElement> links = chapter.findElements(linkLocator);
            qtyLinks += links.size();
            System.out.println(chapter.getText());
            for (WebElement link : links) {
                System.out.println(link.getText());
                link.click();
                driver.navigate().back();
            }
        }
        return qtyLinks;
    }
}
