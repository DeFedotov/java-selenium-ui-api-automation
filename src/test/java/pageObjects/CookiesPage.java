package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CookiesPage extends BasePage{

    By refreshCookiesLocator = By.id("refresh-cookies");

    public CookiesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Refresh cookies")
    public void refreshCookies() {
        driver.findElement(refreshCookiesLocator).click();
    }

    @Step("Get cookies size")
    public int getCookiesSize(){
        WebDriver.Options options = driver.manage();
        Set<Cookie> cookies = options.getCookies();
        return cookies.size();
    }

    @Step("Get cookie value by it's name: {cookieName}")
    public String getCookieByName(String cookieName){
        WebDriver.Options options = driver.manage();
        Cookie username = options.getCookieNamed(cookieName);
        assert username != null;
        return username.getValue();
    }

    @Step("Add new cookie value: {cookieName}, {cookieValue}")
    public Cookie addCookie(String cookieName, String cookieValue){
        WebDriver.Options options = driver.manage();
        Cookie cookie = new Cookie(cookieName, cookieValue);
        options.addCookie(cookie);
        return cookie;
    }

    @Step("Edit existing cookie value: {cookieName}, {cookieValue}")
    public Cookie editCookie(String cookieName, String cookieValue){
        WebDriver.Options options = driver.manage();
        Cookie username = options.getCookieNamed(cookieName);
        Cookie editedCookie = new Cookie(username.getName(), cookieValue);
        options.addCookie(editedCookie);
        return editedCookie;
    }

    @Step("Delete cookie value")
    public Cookie deleteCookie(String cookieName){
        WebDriver.Options options = driver.manage();
        Cookie deletedCookie = options.getCookieNamed(cookieName);
        assert deletedCookie != null;
        options.deleteCookie(deletedCookie);
        return deletedCookie;
    }
}
