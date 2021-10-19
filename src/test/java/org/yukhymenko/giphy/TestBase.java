package org.yukhymenko.giphy;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public RemoteWebDriver driver;
    public HomePage homePage;
    public SearchPage searchPage;
    public SingleGifPage singleGifPage;

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        singleGifPage = new SingleGifPage(driver);

//        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("username", "oauth-yukhymenko.anton-51ae8");
//        sauceOptions.setCapability("accessKey", "d7994e87-32b1-4c4d-ac70-5cd108ac2729");
//        sauceOptions.setCapability("name", method.getName());
//        sauceOptions.setCapability("browserVersion", "latest");
//        ChromeOptions options = new ChromeOptions();
//        options.setCapability("sauce:options", sauceOptions);
//        URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");
//        driver = new RemoteWebDriver(url, options);
//        homePage = new HomePage(driver);
//        searchPage = new SearchPage(driver);
//        singleGifPage = new SingleGifPage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result){
//        String status = result.isSuccess() ? "passed" : "failed";
//        driver.executeScript("sauce:job-result=" + status);
        driver.quit();
        }
}
