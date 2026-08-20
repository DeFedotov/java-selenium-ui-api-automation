package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.Constants.BASE_URL;

import java.time.Duration;
import java.util.List;

public class FramePageTests extends BaseTest{
    private static final String FRAME_URL = BASE_URL + "frames.html";

    @Test
    @DisplayName("IFrame test")
    public void iFrameTest() {
        driver.get(FRAME_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String frameName = "frame-body";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(frameName)));
        driver.switchTo().frame(frameName);

        By pName = By.tagName("p");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pName,0));
        List<WebElement> paragraphs = driver.findElements(pName);
        Assertions.assertEquals(paragraphs.size(), 20);
    }
}
