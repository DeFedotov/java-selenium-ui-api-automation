package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static constants.Constants.NOTIFICATIONS_URL;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class NotificationsPageTests extends BaseTest {

    @BeforeEach
    public void setup() {
        driver.get(NOTIFICATIONS_URL);
    }

    @Test
    @DisplayName("Notification test with safe mock")
    void notificationsTest() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();

        prefs.put("profile.default_content_setting_values.notifications", 1);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script =
                "const callback = arguments[arguments.length - 1]; " +
                        "const OldNotify = window.Notification; " +
                        "function newNotification(title, options) { " +
                        "   callback(title); " +
                        "   if (OldNotify) { return new OldNotify(title, options); } " +
                        "   return { title: title }; " +
                        "} " +
                        "if (OldNotify && OldNotify.requestPermission) { " +
                        "   newNotification.requestPermission = OldNotify.requestPermission.bind(OldNotify); " +
                        "} " +
                        "Object.defineProperty(newNotification, 'permission', { " +
                        "   get: function() { return 'granted'; } " +
                        "}); " +
                        "window.Notification = newNotification; " +
                        "document.getElementById('notify-me').click();";

        Object notificationTitle = js.executeAsyncScript(script);

        Assertions.assertEquals("This is a notification", notificationTitle, "Notification text mismatch!");
    }
}