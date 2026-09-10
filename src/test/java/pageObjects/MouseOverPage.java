package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseOverPage extends BasePage{

    By getImageLocator(String imageName){
        return By.xpath("//img[@src='img/" + imageName.toLowerCase() + ".png']");
    }

    By getCaption(String imageName){
        return By.xpath("//p[contains(text(), '" + imageName + "')]");
    }

    public MouseOverPage(WebDriver driver) {
        super(driver);
    }

    @Step("Mouse over {imageName} image")
    public MouseOverPage mouseOverImage(String imageName){
        Actions actions = new Actions(driver);
        WebElement image = driver.findElement(getImageLocator(imageName));
        actions.moveToElement(image).perform();
        return this;
    }

    @Step("Get caption for {imageName}")
    public String getImageCaption(String imageName){
        return driver.findElement(getCaption(imageName)).getText();
    }
}
