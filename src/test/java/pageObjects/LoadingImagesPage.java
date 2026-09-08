package pageObjects;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadingImagesPage extends BasePage{

    By landscapeLocator = By.id("landscape");

    public LoadingImagesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Load images using implicit wait")
    public WebElement loadingImagesImplicitWait() {
        return driver.findElement(landscapeLocator);
    }

    @Step("Load images using explicit wait")
    public WebElement loadingImagesExplicitWait(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(landscapeLocator));
    }

    @Step
    @DisplayName("Load images using fluent wait")
    public WebElement loadingImagesFluentWait(int timeout, int pooling) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pooling))
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(landscapeLocator));
    }

}
