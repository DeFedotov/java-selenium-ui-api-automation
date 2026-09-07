package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDomPage extends BasePage{

    By contentLocator = By.id("content");

    public ShadowDomPage(WebDriver driver) {
        super(driver);
    }

    public String shadowDom(){
        WebElement content = driver.findElement(contentLocator);
        SearchContext shadowRoot = content.getShadowRoot();
        WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
        return textElement.getText();
    }
}
