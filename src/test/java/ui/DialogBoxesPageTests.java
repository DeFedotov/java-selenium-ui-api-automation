package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.Constants.BASE_URL;


import java.time.Duration;

public class DialogBoxesPageTests {
    WebDriver driver;
    private static final String DIALOG_BOXES_URL = BASE_URL + "dialog-boxes.html";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(DIALOG_BOXES_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Alert test")
    public void alertTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("my-alert")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals(alert.getText(), "Hello world!");
        alert.accept();
    }

    @Test
    @DisplayName("Confirm test")
    public void confirmTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("my-confirm")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirm = driver.switchTo().alert();
        Assertions.assertEquals(confirm.getText(), "Is this correct?");
        confirm.dismiss();
    }

    @Test
    @DisplayName("Prompt name")
    public void promptTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("my-prompt")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("John Doe");
        Assertions.assertEquals(prompt.getText(), "Please enter your name");
        prompt.accept();
    }

    @Test
    @DisplayName("Modal window test")
    public void modalWindowTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("my-modal")).click();
        WebElement close =  driver.findElement(By.xpath("//button[text()='Close']"));
        Assertions.assertEquals(close.getTagName(), "button");
        wait.until(ExpectedConditions.elementToBeClickable(close));
        close.click();
    }
}
