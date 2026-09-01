package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DialogBoxesPage;
import pageObjects.HomePage;

import static constants.Constants.DIALOG_BOXES_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

public class DialogBoxesPageTests extends BaseTest{

    @BeforeEach
    public void setup(){
        driver.get(DIALOG_BOXES_URL);
    }

//    @Test
//    @DisplayName("Alert test")
//    public void alertTest() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        driver.findElement(By.id("my-alert")).click();
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert = driver.switchTo().alert();
//        assertEquals(alert.getText(), "Hello world!");
//        alert.accept();
//    }

    @Test
    @DisplayName("Confirm test")
    public void confirmTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("my-confirm")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirm = driver.switchTo().alert();
        assertEquals(confirm.getText(), "Is this correct?");
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
        assertEquals(prompt.getText(), "Please enter your name");
        prompt.accept();
    }

    @Test
    @DisplayName("Modal window test")
    public void modalWindowTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("my-modal")).click();
        WebElement close =  driver.findElement(By.xpath("//button[text()='Close']"));
        assertEquals(close.getTagName(), "button");
        wait.until(ExpectedConditions.elementToBeClickable(close));
        close.click();
    }

    @Test
    @DisplayName("Verify alert text")
    public void verifyAlertTextTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openDialogBoxesPage();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        dialogBoxesPage.launchAlert();

        String actualAlertText = dialogBoxesPage.getAlertText();
        assertEquals("Hello world!", actualAlertText);

        dialogBoxesPage.acceptAlert();
    }

    @Test
    @DisplayName("Accept confirm alert")
    public void acceptAlertTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openDialogBoxesPage();

        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        dialogBoxesPage.launchConfirm();

        String actualAlertText = dialogBoxesPage.getAlertText();
        assertEquals("Is this correct?", actualAlertText);

        dialogBoxesPage.acceptAlert();
    }
}
