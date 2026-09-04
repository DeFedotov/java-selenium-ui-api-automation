package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Point;
import pageObjects.DragAndDropPage;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragAndDropPageTests extends BaseTest{

    @Test
    @DisplayName("Drag and drop test")
    public void dragAndDropTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openDragAndDropPage();

        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        Point expectedLocation = dragAndDropPage.pointTargetLocation();

        dragAndDropPage.dragAndDropItem();

        Point actualLocation = dragAndDropPage.pointSourceFinalLocation();
        assertEquals(expectedLocation, actualLocation);
    }
}
