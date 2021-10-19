package org.yukhymenko;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

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

    public static String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // odd: the Object param of getContents is not currently used
        Transferable contents = clipboard.getContents(null);
        boolean hasTransferableText = (contents != null)
                && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasTransferableText) {
            try {
                result = (String) contents
                        .getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
        return result;
    }

    public void goToClipboardContent(){
        driver.get(getClipboardContents());
    }

}
