package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogBoxesPage extends BasePage{

    @FindBy(id="my-alert")
    private WebElement alertLocator;

    @FindBy(id="my-confirm")
    private WebElement confirmLocator;

    @FindBy(id="my-prompt")
    private WebElement promptLocator;

    @FindBy(id="my-modal")
    private WebElement modalLocator;

    @FindBy(id="confirm-text")
    private WebElement textUnderConfirmButtonLocator;

    @FindBy(id="prompt-text")
    private WebElement textUnderPromptButtonLocator;

    @FindBy(xpath="//div[@class='modal-body']")
    private WebElement modalWindowBodyLocator;

    @FindBy(xpath = "//button[text()='Close']")
    private WebElement closeModalWindowLocator;

    @FindBy(xpath = "//button[normalize-space(text())='Save changes']")
    private WebElement saveModalWindowLocator;

    @FindBy(id = "modal-text")
    private WebElement textUnderModalButtonLocator;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public DialogBoxesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Launch alert")
    public void launchAlert() {
        alertLocator.click();
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
        confirmLocator.click();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Step("Dismiss alert")
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    @Step("Verify text under confirm button")
    public String getTextUnderConfirmButton() {
        return textUnderConfirmButtonLocator.getText();
    }

    @Step("Launch prompt")
    public void launchPrompt() {
        promptLocator.click();
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Step("Enter prompt")
    public void enterPrompt(String prompt) {
        driver.switchTo().alert().sendKeys(prompt);
    }

    @Step("Verify text under prompt button")
    public String getTextUnderPromptButton() {
        return textUnderPromptButtonLocator.getText();
    }

    @Step("Launch modal window")
    public void launchModalWindow() {
        modalLocator.click();
        wait.until(ExpectedConditions.elementToBeClickable(closeModalWindowLocator));
    }

    @Step("Get modal window body text")
    public String getModalWindowText() {
        return modalWindowBodyLocator.getText();
    }

    @Step("Close modal window")
    public void closeModalWindow() {
        closeModalWindowLocator.click();
    }

    @Step("Save modal window changes")
    public void saveModalWindow() {
        saveModalWindowLocator.click();
    }

    @Step("Verify text under modal button")
    public String getTextUnderModalButton() {
        return textUnderModalButtonLocator.getText();
    }
}
