package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoadingImagesPageTests {
    private WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String LOADING_IMAGES_URL = BASE_URL + "loading-images.html";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(LOADING_IMAGES_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Loading images using implicit wait")
    public void loadingImagesImplicitWaitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement actualCaption = driver.findElement(By.id("landscape"));
        Assertions.assertTrue(actualCaption.isDisplayed());
    }

    @Test
    @DisplayName("Loading images using explicit wait")
    public void loadingImagesExplicitWaitTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement actualCaption = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        Assertions.assertTrue(actualCaption.isDisplayed());
    }

    @Test
    @DisplayName("Loading images using explicit wait")
    public void loadingImagesFluentWaitTest() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement actualCaption = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        Assertions.assertTrue(actualCaption.isDisplayed());
    }
}
