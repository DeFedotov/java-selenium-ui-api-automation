package ui;

import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.WebStoragePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebStoragePageTests extends BaseTest{

    @Test
    @DisplayName("Get local storage size")
    public void localStorageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openWebStoragePage();

        WebStoragePage webStoragePage = new WebStoragePage(driver);
        Long actualStorageSize = webStoragePage.getStorageSize("localStorage");

        assertEquals(0, actualStorageSize);
    }

    @Test
    @DisplayName("Display local storage values")
    public void localStorageTest2() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openWebStoragePage();

        WebStoragePage webStoragePage = new WebStoragePage(driver);
        String actualValues = webStoragePage.displayStorageValues("local");

        assertEquals("{}", actualValues);
    }

    @Test
    @DisplayName("Set local storage item")
    public void localStorageTest3() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openWebStoragePage();

        WebStoragePage webStoragePage = new WebStoragePage(driver);
        webStoragePage.setStorageValues("local", "new key", "new value");
        String actualValues = webStoragePage.displayStorageValues("local");

        assertEquals("{\"new key\":\"new value\"}", actualValues);
    }

    @Test
    @DisplayName("Get session storage size")
    public void sessionStorageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openWebStoragePage();

        WebStoragePage webStoragePage = new WebStoragePage(driver);
        Long actualStorageSize = webStoragePage.getStorageSize("sessionStorage");

        assertEquals(2, actualStorageSize);
    }

    @Test
    @DisplayName("Set session storage item")
    public void sessionStorageTest2() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openWebStoragePage();

        WebStoragePage webStoragePage = new WebStoragePage(driver);
        webStoragePage.setStorageValues("session", "new key", "new value");
        String actualValues = webStoragePage.displayStorageValues("session");

        assertEquals("{\"lastname\":\"Doe\",\"name\":\"John\",\"new key\":\"new value\"}", actualValues);
    }

}
