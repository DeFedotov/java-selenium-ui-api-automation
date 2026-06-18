package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageTests {
    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void openHomePageTest() {
        String actualTitle = driver.getTitle();

        assertEquals("Hands-On Selenium WebDriver with Java",  actualTitle);
    }

    @Test
    void openWebFormPageTest() {
        String expectedUrl = BASE_URL + "web-form.html";
        String expectedPageName = "Web form";

        driver.findElement(By.xpath("//a[@href='web-form.html']")).click();
        String actualUrl = driver.getCurrentUrl();
        String actualPageName = driver.findElement(By.className("display-6")).getText();

        assertEquals(expectedUrl, actualUrl, "Web form url is incorrect.");
        assertEquals(expectedPageName, actualPageName, "Page name is incorrect.");
    }
}
