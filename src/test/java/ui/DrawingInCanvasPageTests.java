package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static constants.Constants.BASE_URL;

public class DrawingInCanvasPageTests extends BaseTest {
    private static final String DRAW_IN_CANVAS_URL = BASE_URL + "draw-in-canvas.html";

    @Test
    @DisplayName("Drawing in Canvas test")
    public void drawingInCanvasTest() {
        driver.get(DRAW_IN_CANVAS_URL);
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
