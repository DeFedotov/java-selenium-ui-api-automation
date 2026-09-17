package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CookiesPage extends BasePage{

    By refreshCookiesLocator = By.id("refresh-cookies");

    public CookiesPage(WebDriver driver) {
        super(driver);
    }

    public void refreshCookies() {
        driver.findElement(refreshCookiesLocator).click();
    }

    public int getCookiesSize(){
        WebDriver.Options options = driver.manage();
        Set<Cookie> cookies = options.getCookies();
        return cookies.size();
    }

    public String getCookieByName(String cookieName){
        WebDriver.Options options = driver.manage();
        Set<Cookie> cookies = options.getCookies();
        Cookie username = options.getCookieNamed("username");
        assert username != null;
        return username.getValue();
    }
}
