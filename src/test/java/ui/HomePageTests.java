package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageTests {
    private WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void openWebFormPageTest() {
        verifyPage("web-form.html", "Web form", "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openNavigationPageTest() {
        verifyPage("navigation1.html", "Navigation example", "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openDropDownPageTest() {
        verifyPage("dropdown-menu.html", "Dropdown menu",  "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openMouseOverPageTest() {
        verifyPage("mouse-over.html", "Mouse over",  "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openDrugAndDropPageTest() {
        verifyPage("drag-and-drop.html",  "Drag and drop",   "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openDrawInCanvasPageTest() {
        verifyPage("draw-in-canvas.html", "Drawing in canvas",  "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openLoadingImagesPageTest() {
        verifyPage("loading-images.html", "Loading images",   "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openSlowCalculatorPageTest() {
        verifyPage("slow-calculator.html", "Slow calculator",    "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openLongPageTest() {
        verifyPage("long-page.html", "This is a long page",   "Chapter 4. Browser-Agnostic Features");
    }

    @Test
    void openInfiniteScrollPageTest() {
        verifyPage("infinite-scroll.html", "Infinite scroll",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openShadowDomPageTest() {
        verifyPage("shadow-dom.html", "Shadow DOM",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openCookiesPageTest() {
        verifyPage("cookies.html", "Cookies",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openFramesPageTest() {
        verifyPage("frames.html", "Frames",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openIframesPageTest() {
        verifyPage("iframes.html",  "IFrame",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openDialogBoxesPageTest() {
        verifyPage("dialog-boxes.html",  "Dialog boxes",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openWebStoragePageTest() {
        verifyPage("web-storage.html",  "Web storage",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openGeolocationPageTest() {
        verifyPage("geolocation.html",  "Geolocation",   "Chapter 5. Browser-Specific Manipulation");
    }

    @Test
    void openNotificationsPageTest() {
        verifyPage("notifications.html",  "Notifications",   "Chapter 5. Browser-Specific Manipulation");
    }

    @Test
    void openGetUserMediaPageTest() {
        verifyPage("get-user-media.html", "Get user media",  "Chapter 5. Browser-Specific Manipulation");
    }

    @Test
    void openMultilanguagePageTest() {
        verifyPage("multilanguage.html", "Multilanguage page",  "Chapter 5. Browser-Specific Manipulation");
    }

    @Test
    void openConsoleLogsPageTest() {
        verifyPage("console-logs.html", "Console logs",   "Chapter 5. Browser-Specific Manipulation");
    }

    @Test
    void openLoginFormPageTest() {
        verifyPage("login-form.html", "Login form", "Chapter 7. The Page Object Model (POM)");
    }

    @Test
    void openSlowLoginPageTest() {
        verifyPage("login-slow.html", "Slow login form", "Chapter 7. The Page Object Model (POM)");
    }

    @Test
    void openRandomCalculatorPageTest() {
        verifyPage("random-calculator.html",  "Random calculator",   "Chapter 8. Testing Framework Specifics");
    }

    @Test
    void openDownloadFilesPageTest() {
        verifyPage("download.html", "Download files",   "Chapter 9. Third-Party Integrations");
    }

    @Test
    void openAbTestingPageTest() {
        verifyPage("ab-testing.html", "A/B Testing",    "Chapter 9. Third-Party Integrations");
    }

    @Test
    void openDataTypesPageTest() {
        verifyPage("data-types.html", "Data types",   "Chapter 9. Third-Party Integrations");
    }

    void verifyPage(String pageHtml, String expectedPageName, String chapterName) {
        String expectedUrl = BASE_URL + pageHtml;

        String complexXpath = "//h5[text()='" + chapterName + "']/../a[contains(@href, '" + pageHtml + "')]";

        driver.findElement(By.xpath("//a[@href='" + pageHtml + "']")).click();

        String actualUrl = driver.getCurrentUrl();
        String actualPageName = driver.findElement(By.className("display-6")).getText();

        assertEquals(expectedUrl, actualUrl, "Web form url is incorrect.");
        assertEquals(expectedPageName, actualPageName, "Page name is incorrect.");

        driver.navigate().back();
    }

    @Test
    void openAllLinksTest() {
        int qtyLinks = 0;
        List<WebElement> chapters = driver.findElements(By.cssSelector("h5.card-title"));
        for (WebElement chapter : chapters) {
            List<WebElement> links = chapter.findElements(By.xpath("./../a"));
            qtyLinks += links.size();
            System.out.println(chapter.getText());
            for (WebElement link : links) {
                System.out.println(link.getText());
                link.click();
                driver.navigate().back();
            }
        }

        assertEquals(6, chapters.size(), "Links count is incorrect.");
        assertEquals(27, qtyLinks);
    }
}
