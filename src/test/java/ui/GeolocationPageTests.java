package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class GeolocationPageTests {
    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private static final String GEOLOCATION_URL = BASE_URL + "geolocation.html";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(GEOLOCATION_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Geolocation test")
    public void geolocationTest() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings_values.geolocation", 1);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }
}
