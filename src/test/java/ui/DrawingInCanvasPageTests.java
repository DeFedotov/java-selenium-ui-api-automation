package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DrawingInCanvasPageTests {
    private WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String DRAW_IN_CANVAS_URL = BASE_URL + "draw-in-canvas.html";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(DRAW_IN_CANVAS_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Drawing in Canvas test")
    public void drawingInCanvasTest() {
        Actions actions = new Actions(driver);
        WebElement canvas = driver.findElement(By.id("my-canvas"));
        actions.moveToElement(canvas).clickAndHold();
        int numPoints = 10;
        int radius = 20;
        for (int i = 0; i <= numPoints; i++) {
            double angle = Math.toRadians(360 * i / numPoints);
            double x = Math.sin(angle) * radius;
            double y = Math.cos(angle) * radius;
            actions.moveByOffset((int) x, (int) y);
        }
        actions.release(canvas).build().perform();
    }
}
