package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationPageTests {

    private WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String NAVIGATION_URL = BASE_URL + "navigation1.html";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get(NAVIGATION_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Navigation test")
    void navigationPageTest() {
        driver.findElement(By.xpath("//a[text()='Next']")).click();
        driver.findElement(By.xpath("//a[text()='3']")).click();
        driver.findElement(By.xpath("//a[text()='Previous']")).click();
        driver.findElement(By.xpath("//a[text()='1']")).click();

        String text = driver.findElement(By.xpath("//p[@class='lead']")).getText();
        Assertions.assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", text);


    }
}
