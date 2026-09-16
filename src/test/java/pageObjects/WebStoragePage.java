package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WebStoragePage extends BasePage{


    By getStorageLocator(String storageName) {
        return By.id("display-" + storageName);
    }
    By getStorageValueLocator(String storageName) {
        return By.id(storageName + "-storage");
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
        return driver.findElement(getStorageValueLocator(storageName)).getText();
    }

    @Step("Set storage arguments")
    public void setStorageValues(String storageName, String key, String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window."+storageName+"Storage.setItem(arguments[0], arguments[1]);", key, value);
    }
}
