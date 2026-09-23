package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElement usernameLocator;

    @FindBy(id = "password")
    private WebElement passwordLocator;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButtonLocator;

    @FindBy(id = "success")
    private WebElement successMessageLocator;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter username")
    public void enterUsername(String username) {
        usernameLocator.sendKeys(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
       passwordLocator.sendKeys(password);
    }

    @Step("Click Submit button")
    public void clickSubmitButton() {
        loginButtonLocator.click();
    }

    @Step("Verify success message")
    public String verifySuccessMessage() {
        return successMessageLocator.getText();
    }
}
