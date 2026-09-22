package ui;

import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.NavigationPage;

import static constants.NavigationConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationPageTests extends BaseTest {

    @Test
    @DisplayName("Navigate to page {pageName} test")
    void navigationTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openNavigationPage();

        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.navigateToPage("2");
        String actualText = navigationPage.getPageText();

        assertEquals(SECOND_PAGE_TEXT,actualText);
    }

    @Test
    @DisplayName("Navigate to {pageName} page")
    void navigationTest2(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openNavigationPage();

        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.navigateToPage("2");
        navigationPage.navigateToPage("Next");

        String actualText = navigationPage.getPageText();
        assertEquals(THIRD_PAGE_TEXT,actualText);
    }

    @Test
    @DisplayName("Navigate to {pageName} page")
    void navigationTest3(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openNavigationPage();

        NavigationPage navigationPage = new NavigationPage(driver);

        navigationPage.navigateToPage("2");
        navigationPage.navigateToPage("Previous");

        String actualText = navigationPage.getPageText();
        assertEquals(FIRST_PAGE_TEXT,actualText);
    }
}
