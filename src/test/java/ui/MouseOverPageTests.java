package ui;

import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.MouseOverPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class MouseOverPageTests extends BaseTest {

    @Test
    @DisplayName("Mouse over image")
    public void image() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        MouseOverPage mouseOverPage = homePage.openMouseOverPage();

        mouseOverPage.mouseOverImage("Compass");
        String actualCaption = mouseOverPage.getImageCaption("Compass");

        assertEquals("Compass", actualCaption);
    }

    @Test
    @DisplayName("Mouse over all images")
    public void allImages() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        MouseOverPage mouseOverPage = homePage.openMouseOverPage();

        List<String> imagesList = Arrays.asList("Compass", "Calendar", "Award",  "Landscape");

        for (String image : imagesList) {
            mouseOverPage.mouseOverImage(image);
            String actualCaption = mouseOverPage.getImageCaption(image);
//            System.out.println("Caption: " + actualCaption);
            assertEquals(image, actualCaption);
        }
    }
}
