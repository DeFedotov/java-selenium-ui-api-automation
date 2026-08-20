package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import static constants.Constants.BASE_URL;

import java.time.Duration;

public class LongTextPageTests extends BaseTest {
    private static final String LONG_PAGE_URL = BASE_URL + "long-page.html";

    @Test
    @DisplayName("Long page test")
    public void longPageTest() {
        driver.get(LONG_PAGE_URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "window.scrollBy(0,1000)";
        js.executeScript(script);
    }

    @Test
    @DisplayName("Long page read last paragraph")
    public void longPageReadLastParagraphTest() {
        driver.get(LONG_PAGE_URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement lastElement = driver.findElement(By.cssSelector("p:last-child"));
        String script = "arguments[0].scrollIntoView();";
        js.executeScript(script,  lastElement);
    }
}
