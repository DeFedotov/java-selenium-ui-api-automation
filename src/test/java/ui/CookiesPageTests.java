package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pageObjects.CookiesPage;
import pageObjects.HomePage;

import java.util.Set;

import static constants.Constants.COOKIES_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CookiesPageTests extends BaseTest{

    @BeforeEach
    public void setup() {
        driver.get(COOKIES_URL);
    }

    @Test
    @DisplayName("Read cookies test")
    public void readCookiesTest() {
        WebDriver.Options options = driver.manage();
        Set<Cookie> cookies = options.getCookies();
        assertEquals(cookies.size(), 2);

        Cookie username = options.getCookieNamed("username");
        assertEquals(username.getValue(), "John Doe");
        assertEquals(username.getPath(), "/");

        driver.findElement(By.id("refresh-cookies")).click();
    }

    @Test
    @DisplayName("Add cookies test")
    public void addCookiesTest() {
        WebDriver.Options options = driver.manage();
        Cookie newCookie = new Cookie("new-cookie-key", "new-cookie-value");
        options.addCookie(newCookie);

        String readValue = options.getCookieNamed(newCookie.getName()).getValue();
        assertEquals(newCookie.getValue(), readValue);

        driver.findElement(By.id("refresh-cookies")).click();
    }

    @Test
    @DisplayName("Edit cookie test")
    public void editCookieTest(){
        WebDriver.Options options = driver.manage();
        Cookie username = options.getCookieNamed("username");
        Cookie editedCookie = new Cookie(username.getName(), "new-value");
        options.addCookie(editedCookie);

        Cookie readCookie  = options.getCookieNamed(username.getName());
        assertEquals(editedCookie, readCookie);

        driver.findElement(By.id("refresh-cookies")).click();
    }

    @Test
    @DisplayName("Delete cookie test")
    public void deleteCookieTest(){
        WebDriver.Options options = driver.manage();
        Set<Cookie> cookies = options.getCookies();
        Cookie username = options.getCookieNamed("username");
        options.deleteCookie(username);

        assertEquals(cookies.size()-1, options.getCookies().size());
    }

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
}
