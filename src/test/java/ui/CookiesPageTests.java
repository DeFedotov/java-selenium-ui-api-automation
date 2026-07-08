package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CookiesPageTests {
    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String COOKIES_URL = BASE_URL + "cookies.html";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(COOKIES_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
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
}
