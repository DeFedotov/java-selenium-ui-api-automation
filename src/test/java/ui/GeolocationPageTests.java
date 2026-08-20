package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static constants.Constants.BASE_URL;

import java.util.HashMap;
import java.util.Map;

public class GeolocationPageTests extends BaseTest{
    private static final String GEOLOCATION_URL = BASE_URL + "geolocation.html";

    @Test
    @DisplayName("Geolocation test")
    public void geolocationTest() {
        driver.get(GEOLOCATION_URL);
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings_values.geolocation", 1);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }
}
