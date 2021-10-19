package org.yukhymenko.giphy;
import org.apache.commons.exec.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GiphyTest extends TestBase {

    @BeforeMethod
    public void openHomePage() {
        homePage.openHomePage();
        homePage.assertPageOpened();
    }

    @Test(priority = 1)
    public void trendingSectionExists(){
        boolean result = homePage.isTrendingSectionExists();
        Assert.assertTrue(result, "Trending section doesn't exist. ");
    }

    @Test(priority = 2)
    public void searchBarTest() {
        boolean result = homePage.isSearchBarExists();
        Assert.assertTrue(result, "Search bar doesn't exist. ");
        homePage.enterSearchRequest("Meme");
        homePage.clickSearch();
        searchPage.assertPageOpened();
        result = searchPage.searchResultShown();
        Assert.assertTrue(result, "No search Results were shown. ");
    }

    @Test(priority = 3)
    public void checkOpenedGifSameAsClicked(){
        homePage.assertPageOpened();
        String gifNameOnHomePage = homePage.getNameOfTheFirstGif();
        homePage.clickOnFirstTrendingGif();
        singleGifPage.assertPageOpened();
        String openedGifName = singleGifPage.getNameOfTheGif();
        Assert.assertEquals(gifNameOnHomePage, openedGifName, "Clicked gif and opened gif are not the same");
    }

    @Test(priority = 4)
    public void checkGifIdSameAsCopiedLinkGifID(){
        boolean result = homePage.isTrendingSectionExists();
        Assert.assertTrue(result, "Trending section doesn't exist. ");
        homePage.clickOnFirstTrendingGif();
        singleGifPage.assertPageOpened();
        String gifId = singleGifPage.getGifId();
        singleGifPage.clickOnShareButton();
        singleGifPage.clickOnCopyGifLinkButton();
        singleGifPage.goToClipboardContent();
        String gifIdCopiedLink = singleGifPage.getGifIdCopiedLink();
        Assert.assertEquals(gifId,gifIdCopiedLink, "ID is not the same. ");
    }

}