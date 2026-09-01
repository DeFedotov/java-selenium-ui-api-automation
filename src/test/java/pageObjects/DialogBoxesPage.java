package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogBoxesPage extends BasePage{

    public static final String DIALOG_BOXES_URL = "dialog-boxes.html";

    By alertLocator = By.id("my-alert");
    By confirmLocator = By.id("my-confirm");
    By promptLocator = By.id("my-prompt");
    By modalLocator = By.id("my-modal");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public DialogBoxesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Launch alert")
    public void launchAlert() {
        driver.findElement(alertLocator).click();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Step("Get alert text")
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    @Step("Accept alert")
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    @Step("Launch confirm")
    public void launchConfirm() {
        driver.findElement(confirmLocator).click();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Step("Dismiss alert")
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

}
