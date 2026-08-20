package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import static constants.Constants.BASE_URL;

public class NavigationPageTests extends BaseTest {
    private static final String NAVIGATION_URL = BASE_URL + "navigation1.html";

    @Test
    @DisplayName("Navigation test")
    void navigationPageTest() {
        driver.get(NAVIGATION_URL);
        driver.findElement(By.xpath("//a[text()='Next']")).click();
        driver.findElement(By.xpath("//a[text()='3']")).click();
        driver.findElement(By.xpath("//a[text()='Previous']")).click();
        driver.findElement(By.xpath("//a[text()='1']")).click();

        String text = driver.findElement(By.xpath("//p[@class='lead']")).getText();
        Assertions.assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", text);


    }
}
