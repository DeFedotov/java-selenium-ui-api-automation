package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import pageObjects.CookiesPage;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CookiesPageTests extends BaseTest{

    @Test
    @DisplayName("Get cookies test")
    public void getCookiesTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openCookiesPage();

        CookiesPage cookiesPage = new CookiesPage(driver);

        int actualCookiesSize = cookiesPage.getCookiesSize();
        assertEquals(2, actualCookiesSize);
    }

    @Test
    @DisplayName("Get cookie by name")
    public void getCookieByNameTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openCookiesPage();

        CookiesPage cookiesPage = new CookiesPage(driver);

        String actualCookieValue = cookiesPage.getCookieByName("username");
        assertEquals("John Doe", actualCookieValue);
    }

    @Test
    @DisplayName("Add cookie test")
    public void addCookieByNameTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openCookiesPage();

        CookiesPage cookiesPage = new CookiesPage(driver);
        Cookie newCookie = cookiesPage.addCookie("new-cookie-key", "new-cookie-value");

        String actualNewCookieValue = cookiesPage.getCookieByName(newCookie.getName());
        assertEquals(newCookie.getValue(), actualNewCookieValue);
    }

    @Test
    @DisplayName("Edit cookie test")
    public void editCookieByNameTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openCookiesPage();

        CookiesPage cookiesPage = new CookiesPage(driver);
        cookiesPage.editCookie("username", "new-username-value");

        String actualNewCookieValue = cookiesPage.getCookieByName("username");
        assertEquals("new-username-value", actualNewCookieValue);

        cookiesPage.refreshCookies();
    }

    @Test
    @DisplayName("Delete cookie test")
    public void deleteCookieByNameTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openCookiesPage();

        CookiesPage cookiesPage = new CookiesPage(driver);
        cookiesPage.deleteCookie("username");

        assertEquals(1, cookiesPage.getCookiesSize());
    }
}
