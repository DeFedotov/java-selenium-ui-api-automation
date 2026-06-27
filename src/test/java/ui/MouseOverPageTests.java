package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MouseOverPageTests {
    private WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String MOUSE_OVER_URL = BASE_URL + "mouse-over.html";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(MOUSE_OVER_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Mouse over Compass image test")
    public void compassImage() {
        Actions actions = new Actions(driver);
        WebElement compassImage = driver.findElement(By.xpath("//img[@src='img/compass.png']"));

        actions.moveToElement(compassImage).perform();

        WebElement actualCaptioin = driver.findElement(By.xpath("//p[contains(text(), 'Compass')]"));
        Assertions.assertEquals("Compass",  actualCaptioin.getText());
    }

    @Test
    @DisplayName("Mouse over Calendar image test")
    public void calendarImage() {
        Actions actions = new Actions(driver);
        WebElement calendarImage = driver.findElement(By.xpath("//img[@src='img/calendar.png']"));

        actions.moveToElement(calendarImage).perform();

        WebElement actualCaptioin = driver.findElement(By.xpath("//p[contains(text(), 'Calendar')]"));
        Assertions.assertEquals("Calendar",  actualCaptioin.getText());
    }

    @Test
    @DisplayName("Mouse over Award image test")
    public void awardImage() {
        Actions actions = new Actions(driver);
        WebElement awardImage = driver.findElement(By.xpath("//img[@src='img/award.png']"));

        actions.moveToElement(awardImage).perform();

        WebElement actualCaption = driver.findElement(By.xpath("//p[contains(text(), 'Award')]"));
        Assertions.assertEquals("Award",  actualCaption.getText());
    }

    @Test
    @DisplayName("Mouse over Landscape image test")
    public void landscapeImage() {
        Actions actions = new Actions(driver);
        WebElement landscapeImage = driver.findElement(By.xpath("//img[@src='img/landscape.png']"));

        actions.moveToElement(landscapeImage).perform();

        WebElement actualCaption = driver.findElement(By.xpath("//p[contains(text(), 'Landscape')]"));
        Assertions.assertEquals("Landscape",  actualCaption.getText());
    }

    @Test
    @DisplayName("Mouse over all images test")
    public void allImage() {
        Actions actions = new Actions(driver);
        List<String> imagesList = Arrays.asList("Compass", "Calendar", "Award",  "Landscape");

        for (String image : imagesList) {
            WebElement imageElement = driver.findElement(By.xpath("//img[@src='img/" + image.toLowerCase() + ".png']"));
            actions.moveToElement(imageElement).perform();
            WebElement actualCaption = driver.findElement(By.xpath("//p[contains(text(), '" + image + "')]"));
            Assertions.assertEquals(image, actualCaption.getText());
        }
    }
}
