package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.HomePage;
import pageObjects.SlowCalculatorPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlowCalculatorPageTests extends BaseTest {

    @Test
    @DisplayName("Slow calculator test")
    public void slowCalculatorTest2() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.openSlowCalculatorPage();

        SlowCalculatorPage slowCalculatorPage = new SlowCalculatorPage(driver);

        slowCalculatorPage
                .clickOnButton("5")
                .clickOnButton("x")
                .clickOnButton("7")
                .clickOnButton("=");

        String expectedResult = "35";
        String actualResult = slowCalculatorPage.getResult(expectedResult);

        assertEquals(expectedResult, actualResult);
    }
}
