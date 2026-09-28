package ui;

import configs.TestPropertiesConfig;
import extensions.AllureExtension;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static patterns.WebDriverFactory.createWebDriver;

@Feature("Extensions")
@ExtendWith(AllureExtension.class)
public class BaseTest {
    public static WebDriver driver;
    static TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    public void setUp() {
        driver = createWebDriver(configProperties.browser());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
