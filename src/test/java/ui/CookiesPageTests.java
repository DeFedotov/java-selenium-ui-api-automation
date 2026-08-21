package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static constants.Constants.COOKIES_URL;

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
        Assertions.assertEquals(cookies.size(), 2);

        Cookie username = options.getCookieNamed("username");
        Assertions.assertEquals(username.getValue(), "John Doe");
        Assertions.assertEquals(username.getPath(), "/");

        driver.findElement(By.id("refresh-cookies")).click();
    }

    @Test
    @DisplayName("Add cookies test")
    public void addCookiesTest() {
        WebDriver.Options options = driver.manage();
        Cookie newCookie = new Cookie("new-cookie-key", "new-cookie-value");
        options.addCookie(newCookie);

        String readValue = options.getCookieNamed(newCookie.getName()).getValue();
        Assertions.assertEquals(newCookie.getValue(), readValue);

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
        Assertions.assertEquals(editedCookie, readCookie);

        driver.findElement(By.id("refresh-cookies")).click();
    }

    @Test
    @DisplayName("Delete cookie test")
    public void deleteCookieTest(){
        WebDriver.Options options = driver.manage();
        Set<Cookie> cookies = options.getCookies();
        Cookie username = options.getCookieNamed("username");
        options.deleteCookie(username);

        Assertions.assertEquals(cookies.size()-1, options.getCookies().size());
    }
}
