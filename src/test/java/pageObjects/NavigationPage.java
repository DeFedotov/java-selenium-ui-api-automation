package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage{

    By getPageLocator(String pageName){
        return By.xpath("//a[text()='"+pageName+"']");
    }

    By textLocator = By.xpath("//p[@class='lead']");

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to {pageName} page")
    public void navigateToPage(String pageName){
        driver.findElement(getPageLocator(pageName)).click();
    }

    @Step("Get page text")
    public String getPageText(){
        return driver.findElement(textLocator).getText();
    }
}
