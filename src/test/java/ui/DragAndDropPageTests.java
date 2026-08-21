package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static constants.Constants.DRAG_AND_DROP_URL;

public class DragAndDropPageTests extends BaseTest{

    @BeforeEach
    public void setup(){
        driver.get(DRAG_AND_DROP_URL);
    }

    @Test
    @DisplayName("Drag and drop test")
    public void dragAndDropTest() {
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("target"));

        Point targetLocation = new Point(target.getLocation().getX(), target.getLocation().getY());

        actions.dragAndDrop(source, target).perform();

        Point sourceLocationFinal = new Point(source.getLocation().getX(), source.getLocation().getY());
        Assertions.assertEquals(sourceLocationFinal, targetLocation);
    }
}
