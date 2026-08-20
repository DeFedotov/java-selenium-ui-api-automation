package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static constants.Constants.BASE_URL;

public class DragAndDropPageTests extends BaseTest{
    private static final String DRAG_AND_DROP_URL = BASE_URL + "drag-and-drop.html";

    @Test
    @DisplayName("Drag and drop test")
    public void dragAndDropTest() {
        driver.get(DRAG_AND_DROP_URL);
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("target"));

        Point targetLocation = new Point(target.getLocation().getX(), target.getLocation().getY());

        actions.dragAndDrop(source, target).perform();

        Point sourceLocationFinal = new Point(source.getLocation().getX(), source.getLocation().getY());
        Assertions.assertEquals(sourceLocationFinal, targetLocation);
    }
}
