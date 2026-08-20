package ui;

import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginFormPageTests extends BaseTest {
    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
    private static final String LOGIN_FORM_URL = "login-form.html";

    @Test
    @DisplayName("Login form test")
    public void loginFormTest() {
        driver.get(config.getBaseUrl() + LOGIN_FORM_URL);
        driver.findElement(By.id("username")).sendKeys(config.getUsername());
        driver.findElement(By.id("password")).sendKeys(config.getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement message = driver.findElement(By.id("success"));

        Assertions.assertEquals("Login successful", message.getText());

    }
}
