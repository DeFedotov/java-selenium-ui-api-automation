package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import static constants.Constants.NAVIGATION_URL;

public class NavigationPageTests extends BaseTest {

    @BeforeEach
    public void setup() {
        driver.get(NAVIGATION_URL);
    }

    @Test
    @DisplayName("Navigation test")
    void navigationPageTest() {

        driver.findElement(By.xpath("//a[text()='Next']")).click();
        driver.findElement(By.xpath("//a[text()='3']")).click();
        driver.findElement(By.xpath("//a[text()='Previous']")).click();
        driver.findElement(By.xpath("//a[text()='1']")).click();

        String text = driver.findElement(By.xpath("//p[@class='lead']")).getText();
        Assertions.assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", text);


    }
}
