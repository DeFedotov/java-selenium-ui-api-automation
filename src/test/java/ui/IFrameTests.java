package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.Constants.BASE_URL;

import java.time.Duration;
import java.util.List;

public class IFrameTests extends BaseTest {
    private static final String IFRAME_URL = BASE_URL + "iframes.html";

    @Test
    @DisplayName("IFrame test")
    public void iFrameTest() {
        driver.get(IFRAME_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe"));

        By pName = By.tagName("p");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pName,0));
        List<WebElement> paragraphs = driver.findElements(pName);
        Assertions.assertEquals(paragraphs.size(), 20);
    }
}
