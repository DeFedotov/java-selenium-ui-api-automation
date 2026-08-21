package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static constants.Constants.DROP_DOWN_URL;

public class DropDownPageTests extends BaseTest{

    @BeforeEach
    public void setup(){
        driver.get(DROP_DOWN_URL);
    }

    @Test
    @DisplayName("Left-click test")
    void leftClickTest() {
        Actions actions = new Actions(driver);

        WebElement dropdown1 = driver.findElement(By.id("my-dropdown-1"));
        actions.click(dropdown1).perform();

        WebElement dropdownMenu1 = driver.findElement(By.xpath("//ul[@class='dropdown-menu show']"));
        Assertions.assertTrue(dropdownMenu1.isDisplayed());

        WebElement actionElement = driver.findElement(By.xpath("//a[contains(text(),'Action')]"));
        Assertions.assertEquals("Action", actionElement.getText());
    }

    @Test
    @DisplayName("Right-click test")
    void rightClickTest() {
        Actions actions = new Actions(driver);

        WebElement dropdown2 = driver.findElement(By.id("my-dropdown-2"));
        actions.contextClick(dropdown2).build().perform();

        WebElement dropDownMenu2 = driver.findElement(By.id("context-menu-2"));
        Assertions.assertTrue(dropDownMenu2.isDisplayed());

        WebElement actionElement = driver.findElement(By.xpath("//ul[@id='context-menu-2']//a[contains(text(),'Another action')]"));
        Assertions.assertEquals("Another action", actionElement.getText());
    }

    @Test
    @DisplayName("Double-click test")
    void doubleClickTest() {
        Actions actions = new Actions(driver);

        WebElement dropdown3 = driver.findElement(By.id("my-dropdown-3"));
        actions.doubleClick(dropdown3).build().perform();

        WebElement dropdownMenu3 = driver.findElement(By.id("context-menu-3"));
        Assertions.assertTrue(dropdownMenu3.isDisplayed());

        WebElement actionElement = driver.findElement(By.xpath("//ul[@id='context-menu-3']//a[contains(text(),'Something else here')]"));
        Assertions.assertEquals("Something else here", actionElement.getText());
    }
}
