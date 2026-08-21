package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import static constants.Constants.SHADOW_DOM_URL;

public class ShadowDomPageTests extends BaseTest {

    @BeforeEach
    public void setup() {
        driver.get(SHADOW_DOM_URL);
    }

    @Test
    @DisplayName("Shadow DOM test")
    void shadowDomTest() {
        WebElement content = driver.findElement(By.id("content"));
        SearchContext shadowRoot = content.getShadowRoot();
        WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
        Assertions.assertEquals(textElement.getText(), "Hello Shadow DOM");
    }
}
