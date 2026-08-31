package ui;

import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginFormPageTests extends BaseTest {
    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @Test
    @DisplayName("Login form test")
    public void loginFormTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openLoginFormPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(config.getUsername());
        loginPage.enterPassword(config.getPassword());
        loginPage.clickSubmitButton();

        String actualMessage = loginPage.verifySuccessMessage();

        assertEquals("Login successful", actualMessage);
    }
}
