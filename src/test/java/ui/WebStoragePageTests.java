package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static constants.Constants.WEB_STORAGE_URL;

public class WebStoragePageTests extends BaseTest{

    @BeforeEach
    public void setup(){
        driver.get(WEB_STORAGE_URL);
    }

    @Test
    @DisplayName("Web Storage test")
    public void webStorageTest() {
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
