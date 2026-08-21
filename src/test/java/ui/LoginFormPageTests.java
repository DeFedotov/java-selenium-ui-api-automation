package ui;

import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static constants.Constants.LOGIN_FORM_URL;

public class LoginFormPageTests extends BaseTest {
    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @BeforeEach
    public void setup() {
        driver.get(LOGIN_FORM_URL);
    }

    @Test
    @DisplayName("Login form test")
    public void loginFormTest() {
        driver.findElement(By.id("username")).sendKeys(config.getUsername());
        driver.findElement(By.id("password")).sendKeys(config.getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement message = driver.findElement(By.id("success"));

        Assertions.assertEquals("Login successful", message.getText());

    }
}
