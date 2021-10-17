package org.yukhymenko.giphy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.yukhymenko.DriverActions;

public class HomePage extends DriverActions {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String homePageUrl = "https://giphy.com/";
    private static final By TRENDING_ELEMENT_LOCATOR =  By.xpath("//h3[contains(text(),'Trending')]");
    private static final By SEARCH_BAR_ELEMENT_LOCATOR =  By.tagName("input");
    private static final By SEARCH_BUTTON_ELEMENT_LOCATOR =  By.xpath("//img[@src='/static/img/search-icon.svg']");
    private static final By FIRST_GIF_NAME_ELEMENT_LOCATOR =  By.xpath("(//img)[3]");
    private static final By FIRST_GIF_ELEMENT_LOCATOR =  By.xpath("(//div[@class='Container-sc-3mbxb4 jfTqrJ'])[1]");

    public void openHomePage(){ driver.get(this.homePageUrl);}

    public void enterSearchRequest(String text){
        typeText(SEARCH_BAR_ELEMENT_LOCATOR, text);
    }

    public void clickSearch(){
        click(SEARCH_BUTTON_ELEMENT_LOCATOR);
    }

    public void clickOnFirstTrendingGif(){
        isElementVisible(FIRST_GIF_ELEMENT_LOCATOR,10);
        click(FIRST_GIF_ELEMENT_LOCATOR);
    }

    public boolean isTrendingSectionExists(){
        int timeOut = 10;
        return isElementVisible(TRENDING_ELEMENT_LOCATOR, timeOut);
    }

    public boolean isSearchBarExists(){
        int timeOut = 10;
        return isElementVisible(SEARCH_BAR_ELEMENT_LOCATOR, timeOut);
    }

    public void assertPageOpened(){
        boolean result = isElementVisible(TRENDING_ELEMENT_LOCATOR,20);
        Assert.assertTrue(result, "Home page was not loaded");
    }

    public String getNameOfTheFirstGif(){
        return getAttributeValue(FIRST_GIF_NAME_ELEMENT_LOCATOR,"alt");
    }

}
