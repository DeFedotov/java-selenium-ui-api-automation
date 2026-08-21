package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import static constants.Constants.LONG_PAGE_URL;

import java.time.Duration;

public class LongTextPageTests extends BaseTest {

    @BeforeEach
    public void setup() {
        driver.get(LONG_PAGE_URL);
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
