package ui;

import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.ShadowDomPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShadowDomPageTests extends BaseTest {

    @Test
    @DisplayName("Shadow DOM test")
    void shadowDomTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openShadowDomPage();

        ShadowDomPage shadowDomPage = new ShadowDomPage(driver);
        String actualShadowDOMText = shadowDomPage.shadowDom();

        assertEquals("Hello Shadow DOM", actualShadowDOMText);
    }
}
