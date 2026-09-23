package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShadowDomPage extends BasePage{

    @FindBy(id = "content")
    private WebElement contentLocator;

    public ShadowDomPage(WebDriver driver) {
        super(driver);
    }

    public String shadowDom(){
        SearchContext shadowRoot = contentLocator.getShadowRoot();
        WebElement textElement = shadowRoot.findElement(By.cssSelector("p"));
        return textElement.getText();
    }
}
