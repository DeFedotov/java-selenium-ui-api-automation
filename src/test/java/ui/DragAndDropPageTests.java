package ui;

import jdk.jfr.Threshold;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPageTests {
    private WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String DRAG_AND_DROP_URL = BASE_URL + "drag-and-drop.html";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(DRAG_AND_DROP_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Drag and drop test")
    public void dragAndDropTest() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("target"));

        Point targetLocation = new Point(target.getLocation().getX(), target.getLocation().getY());

        actions.dragAndDrop(source, target).perform();

        Point sourceLocationFinal = new Point(source.getLocation().getX(), source.getLocation().getY());
        Assertions.assertEquals(sourceLocationFinal, targetLocation);
    }
}
