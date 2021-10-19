package org.yukhymenko.giphy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.yukhymenko.DriverActions;

public class SingleGifPage extends DriverActions {
    public SingleGifPage(WebDriver driver) {
        super(driver);
    }

    private static final By SINGLE_GIF_ELEMENT_LOCATOR =  By.xpath("(//img)[3]");
    private static final By SHARE_BUTTON_ELEMENT_LOCATOR =  By.xpath("//span[contains(text(),'Share')]");
    private static final By COPY_LINK_ELEMENT_LOCATOR =  By.xpath("//button[contains(text(),'Copy GIF')]");


    public void assertPageOpened(){
        boolean result = isElementVisible(SHARE_BUTTON_ELEMENT_LOCATOR,10);
        Assert.assertTrue(result, "Single Gif page was not loaded");
    }

    public String getNameOfTheGif(){
        return getAttributeValue(SINGLE_GIF_ELEMENT_LOCATOR,"alt");
    }

    public void clickOnShareButton(){
        click(SHARE_BUTTON_ELEMENT_LOCATOR);
    }

    public void clickOnCopyGifLinkButton(){
        click(COPY_LINK_ELEMENT_LOCATOR);
    }

    public String getCurrentURL() {
       return driver.getCurrentUrl();
    }

    public String getGifId(){
        String result = getCurrentURL();
        result = result.substring(result.length() - 18);
        return result;
    }

    public String getGifIdCopiedLink(){
        String result = getCurrentURL();
        result = result.replace("/giphy.gif", "");
        result = result.substring(result.length() - 18);
        return result;
    }



}
