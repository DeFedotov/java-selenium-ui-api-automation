package pageObjects;

import configs.TestPropertiesConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.xpath("//button[@type='submit']");
    By successMessageLocator = By.id("success");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter username")
    public void enterUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    @Step("Click Submit button")
    public void clickSubmitButton() {
        driver.findElement(loginButtonLocator).click();
    }

    @Step("Verify success message")
    public String verifySuccessMessage() {
        return driver.findElement(successMessageLocator).getText();
    }
}
