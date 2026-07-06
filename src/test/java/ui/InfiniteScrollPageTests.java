package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InfiniteScrollPageTests {
    private WebDriver  driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String INFINITE_SCROLL_URL = BASE_URL + "infinite-scroll.html";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get(INFINITE_SCROLL_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Infinite scroll test")
    public void infiniteScrollTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> paragraphs = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("p"), 0));
        int initParagraphs = paragraphs.size();

        WebElement lastParagraph = driver.findElement(By.xpath(String.format("//p[%d]", initParagraphs)));
        String script = "arguments[0].scrollIntoView();";
        js.executeScript(script,  lastParagraph);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("p"), initParagraphs));
    }
}
