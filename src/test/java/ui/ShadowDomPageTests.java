package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomPageTests {
    private WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String SHADOW_DOM_URL = BASE_URL + "shadow-dom.html";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get(SHADOW_DOM_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
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
