import buisness_object.Site;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import page_object.MainPage;
import utility.DriverSet;

import static page_object.MainPage.highlightElement;

public class CaseTest {


   private static final String CREDO = "PROVIDING ENERGY,\n" +
           "SAFE SOLUTIONS";
   private WebDriver driver;
   private MainPage mainPage;
   private Site energySite;

    @Test
    public void openBrowser() {
        driver = DriverSet.getDriver();
        energySite = new Site("ESS","http://energy-ss.com");
        driver.get(energySite.getURL());
        mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isLogVisible());
    }

    @Test(dependsOnMethods = "openBrowser")
    public void switchLanuage() throws InterruptedException {
        mainPage = new MainPage(driver);
        highlightElement(mainPage.getEnglSwitcher());
        mainPage.clickEngSwitcher();
        Assert.assertEquals(mainPage.getCredo().getText(),CREDO);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
