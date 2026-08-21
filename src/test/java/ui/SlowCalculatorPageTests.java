package ui;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.Constants.BASE_URL;
import static constants.Constants.SLOW_CALCULATOR_URL;

import java.time.Duration;

public class SlowCalculatorPageTests extends BaseTest {

    @BeforeEach
    public void setup() {
        driver.get(SLOW_CALCULATOR_URL);
    }

    @Test
    @DisplayName("Slow calulator test")
    public void slowCalculatorTest() {
        driver.findElement(By.xpath("//span[text()='5']")).click();
        driver.findElement(By.xpath("//span[text()='x']")).click();
        driver.findElement(By.xpath("//span[text()='7']")).click();
        driver.findElement(By.xpath("//span[text()='=']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.className("screen"), "35"));
    }
}
