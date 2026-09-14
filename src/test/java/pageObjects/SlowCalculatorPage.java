package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SlowCalculatorPage extends BasePage {

    private By getButtonLocator(String buttonName){
        return By.xpath("//span[text()='" + buttonName + "']");
    }

    private final By screenLocator = By.className("screen");

    public SlowCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click calculator button {button}")
    public SlowCalculatorPage clickOnButton(String button){
        driver.findElement(getButtonLocator(button)).click();
        return this;
    }

    @Step("Get expected result {expectedResult}")
    public String getResult(String expectedResult){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(screenLocator, expectedResult));
        return driver.findElement(screenLocator).getText();
    }
}
