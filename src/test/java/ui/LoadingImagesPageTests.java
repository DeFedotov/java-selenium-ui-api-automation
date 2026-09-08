package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import pageObjects.HomePage;
import pageObjects.LoadingImagesPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoadingImagesPageTests extends BaseTest{

    @Order(1)
    @Test
    @DisplayName("Loading images using implicit wait test")
    public void loadingImagesImplicitWaitTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openLoadingImagesPage();

        LoadingImagesPage loadingImagesPage = new LoadingImagesPage(driver);
        WebElement actualCaption = loadingImagesPage.loadingImagesImplicitWait();

        assertTrue(actualCaption.isDisplayed());
    }

    @Order(2)
    @Test
    @DisplayName("Loading images using explicit wait test")
    public void loadingImagesExplicitWaitTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openLoadingImagesPage();

        LoadingImagesPage loadingImagesPage = new LoadingImagesPage(driver);
        WebElement actualCaption = loadingImagesPage.loadingImagesExplicitWait(10);

        assertTrue(actualCaption.isDisplayed());
    }

    @Order(3)
    @Test
    @DisplayName("Loading images using fluent wait test")
    public void loadingImagesFluentWaitTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openLoadingImagesPage();

        LoadingImagesPage loadingImagesPage = new LoadingImagesPage(driver);
        WebElement actualCaption = loadingImagesPage.loadingImagesFluentWait(10, 1);

        assertTrue(actualCaption.isDisplayed());
    }
}
