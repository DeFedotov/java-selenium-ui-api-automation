package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static constants.Constants.BASE_URL;

public class WebStoragePageTests extends BaseTest{
    private static final String WEB_STORAGE_URL = BASE_URL + "web-storage.html";

    @Test
    @DisplayName("Web Storage test")
    public void webStorageTest() {
        driver.get(WEB_STORAGE_URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Long localStorageSize = (Long) js.executeScript("return window.localStorage.length;");
//        log.debug("Local storage elements: {}", localStorageSize);

        Long sessionStorageSize = (Long) js.executeScript("return window.sessionStorage.length;");

        for (int i = 0; i < sessionStorageSize; i++) {
            String key = (String) js.executeScript("return window.sessionStorage.key(arguments[0]);", i);
//            String value = (String) js.executeScript("return window.sessionStorage.getItem(arguments[0]);", key);
//            log.debug("Session storage: {}={}", key, value);
        }

        Assertions.assertEquals(2, sessionStorageSize);

        js.executeScript("window.sessionStorage.setItem(arguments[0], arguments[1]);", "new element", "new value");

        Long updatedSessionStorageSize = (Long) js.executeScript("return window.sessionStorage.length;");
        Assertions.assertEquals(3, updatedSessionStorageSize);

        driver.findElement(By.id("display-session")).click();
    }

}
