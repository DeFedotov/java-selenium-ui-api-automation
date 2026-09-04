package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage{

    By sourceLocator = By.id("draggable");
    By targetLocator = By.id("target");

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @Step("Point target location")
    public Point pointTargetLocation(){
        return driver.findElement(targetLocator).getLocation();
    }

    @Step("Point source final location")
    public Point pointSourceFinalLocation(){
        return driver.findElement(sourceLocator).getLocation();
    }

    @Step("Drag and drop item")
    public DragAndDropPage dragAndDropItem(){
        Actions actions = new Actions(driver);

        WebElement target = driver.findElement(targetLocator);
        WebElement source = driver.findElement(sourceLocator);

        actions.dragAndDrop(source, target).perform();
        return this;
    }
}
