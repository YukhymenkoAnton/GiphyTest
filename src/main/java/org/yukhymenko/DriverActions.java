package org.yukhymenko;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverActions {
    public WebDriver driver;

    public DriverActions(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void typeText(By locator, String text){
        WebElement field = driver.findElement(locator);
        field.click();
        field.sendKeys(text);
    }

    public boolean isElementVisible(By locator, int timeOutSeconds){
        try{
            WebDriverWait wait = new WebDriverWait(driver,timeOutSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));}
        catch (TimeoutException | NotFoundException e) {
            return false;
        }
        return true;
    }

    public String getAttributeValue(By locator, String AttributeName){
        WebElement element = driver.findElement(locator);
        return element.getAttribute(AttributeName);
    }

}
