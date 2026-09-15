package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WebStoragePage extends BasePage{

    By showLocationStorageLocator = By.id("display-local");
    By showSessionStorageLocator = By.id("display-session");
    By getStorageLocator(String storageName) {
        return By.id("display-" + storageName);
    }
    public WebStoragePage(WebDriver driver) {
        super(driver);
    }

    @Step("Get storage size")
    public Long getStorageSize(String storageName){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Long) js.executeScript("return window." + storageName + ".length;");
    }

    @Step("Display storage values")
    public String displayStorageValues(String storageName){
        driver.findElement(getStorageLocator(storageName)).click();
        return storageName;
    }
}
