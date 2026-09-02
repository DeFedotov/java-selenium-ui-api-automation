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
    By textUnderConfirmButtonLocator = By.id("confirm-text");
    By textUnderPromptButtonLocator = By.id("prompt-text");

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

    @Step("Verify text under confirm button")
    public String getTextUnderConfirmButton() {
        return driver.findElement(textUnderConfirmButtonLocator).getText();
    }

    @Step("Launch prompt")
    public void launchPrompt() {
        driver.findElement(promptLocator).click();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Step("Enter prompt")
    public void enterPrompt(String prompt) {
        driver.switchTo().alert().sendKeys(prompt);
    }

    @Step("Verify text under prompt button")
    public String getTextUnderPromptButton() {
        return driver.findElement(textUnderPromptButtonLocator).getText();
    }

}
