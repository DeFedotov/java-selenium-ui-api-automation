package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.bidi.module.Script;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LongTextPageTests {
    private WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String LONG_PAGE_URL = BASE_URL + "long-page.html";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get(LONG_PAGE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Long page test")
    public void longPageTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "window.scrollBy(0,1000)";
        js.executeScript(script);
    }

    @Test
    @DisplayName("Long page read last paragraph")
    public void longPageReadLastParagraphTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement lastElement = driver.findElement(By.cssSelector("p:last-child"));
        String script = "arguments[0].scrollIntoView();";
        js.executeScript(script,  lastElement);
    }
}
