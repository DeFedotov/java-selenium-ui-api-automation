package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static constants.Constants.BASE_URL;

public class LoginFormPageTests {
    WebDriver driver;
    private static final String LOGIN_FORM_URL = BASE_URL + "login-form.html";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(LOGIN_FORM_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Login form test")
    public void loginFormTest() {
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("user");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement message = driver.findElement(By.id("success"));

        Assertions.assertEquals("Login successful", message.getText());

    }
}
