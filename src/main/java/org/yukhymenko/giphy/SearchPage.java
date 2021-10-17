package org.yukhymenko.giphy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.yukhymenko.DriverActions;

public class SearchPage extends DriverActions {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private static final By GIFS_ELEMENT_LOCATOR =  By.xpath("//div[contains(text(),'GIFs')]");
    private static final By SORT_ELEMENT_LOCATOR =  By.xpath("//span[contains(text(),'Sort')]");

    public void assertPageOpened(){
        boolean result = isElementVisible(SORT_ELEMENT_LOCATOR,10);
        Assert.assertTrue(result, "Search page was not loaded");
    }

    public boolean searchResultShown() {
        int timeOut = 10;
        return isElementVisible(GIFS_ELEMENT_LOCATOR, timeOut);
    }

}
