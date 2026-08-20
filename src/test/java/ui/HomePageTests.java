package ui;

import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageTests extends BaseTest{
    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @Test
    void openWebFormPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("web-form.html", "Web form", "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openNavigationPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("navigation1.html", "Navigation example", "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openDropDownPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("dropdown-menu.html", "Dropdown menu",  "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openMouseOverPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("mouse-over.html", "Mouse over",  "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openDrugAndDropPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("drag-and-drop.html",  "Drag and drop",   "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openDrawInCanvasPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("draw-in-canvas.html", "Drawing in canvas",  "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openLoadingImagesPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("loading-images.html", "Loading images",   "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openSlowCalculatorPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("slow-calculator.html", "Slow calculator",    "Chapter 3. WebDriver Fundamentals");
    }

    @Test
    void openLongPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("long-page.html", "This is a long page",   "Chapter 4. Browser-Agnostic Features");
    }

    @Test
    void openInfiniteScrollPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("infinite-scroll.html", "Infinite scroll",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openShadowDomPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("shadow-dom.html", "Shadow DOM",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openCookiesPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("cookies.html", "Cookies",   "Chapter 4. WebDriver Fundamentals");
    }

//    @Test
//    void openFramesPageTest() {
//        driver.get(config.getBaseUrl());
//        verifyPage("frames.html", "Frames",   "Chapter 4. WebDriver Fundamentals");
//    }

    @Test
    void openIframesPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("iframes.html",  "IFrame",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openDialogBoxesPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("dialog-boxes.html",  "Dialog boxes",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openWebStoragePageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("web-storage.html",  "Web storage",   "Chapter 4. WebDriver Fundamentals");
    }

    @Test
    void openGeolocationPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("geolocation.html",  "Geolocation",   "Chapter 5. Browser-Specific Manipulation");
    }

    @Test
    void openNotificationsPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("notifications.html",  "Notifications",   "Chapter 5. Browser-Specific Manipulation");
    }

    @Test
    void openGetUserMediaPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("get-user-media.html", "Get user media",  "Chapter 5. Browser-Specific Manipulation");
    }

    @Test
    void openMultilanguagePageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("multilanguage.html", "Multilanguage page",  "Chapter 5. Browser-Specific Manipulation");
    }

    @Test
    void openConsoleLogsPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("console-logs.html", "Console logs",   "Chapter 5. Browser-Specific Manipulation");
    }

    @Test
    void openLoginFormPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("login-form.html", "Login form", "Chapter 7. The Page Object Model (POM)");
    }

    @Test
    void openSlowLoginPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("login-slow.html", "Slow login form", "Chapter 7. The Page Object Model (POM)");
    }

    @Test
    void openRandomCalculatorPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("random-calculator.html",  "Random calculator",   "Chapter 8. Testing Framework Specifics");
    }

    @Test
    void openDownloadFilesPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("download.html", "Download files",   "Chapter 9. Third-Party Integrations");
    }

    @Test
    void openAbTestingPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("ab-testing.html", "A/B Testing",    "Chapter 9. Third-Party Integrations");
    }

    @Test
    void openDataTypesPageTest() {
        driver.get(config.getBaseUrl());
        verifyPage("data-types.html", "Data types",   "Chapter 9. Third-Party Integrations");
    }

    void verifyPage(String pageHtml, String expectedPageName, String chapterName) {
        String expectedUrl = config.getBaseUrl() + pageHtml;

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
        driver.get(config.getBaseUrl());
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
