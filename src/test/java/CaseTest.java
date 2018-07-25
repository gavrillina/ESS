import buisness_object.Site;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page_object.MainMenu;
import page_object.MainPage;
import page_object.Services;
import utility.DriverSet;
import utility.RollingLogger;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static page_object.MainPage.highlightElement;

public class CaseTest {


   private static final String CREDO = "PROVIDING ENERGY,\n" +
           "SAFE SOLUTIONS";
   private static final String LABEL = "УСЛУГИ";
   private WebDriver driver;
   private MainPage mainPage;
   private MainMenu mainMenu;
   private Services services;
   private Site energySite;
   private Logger logger  = Logger.getLogger(RollingLogger.class);

    @Test
    public void openBrowser() {
        logger.info("prepare driver");
        driver = DriverSet.getDriver();
        logger.info("create site");
        energySite = new Site("ESS","http://energy-ss.com");
        logger.info("open site");
        driver.get(energySite.getURL());
        mainPage = new MainPage(driver);
        logger.info("check working...");
        Assert.assertTrue(mainPage.isLogVisible());
    }

    @Test(dependsOnMethods = "openBrowser")
    public void switchLanuage() {
        mainPage = new MainPage(driver);
        highlightElement(mainPage.getEnglSwitcher());
        mainPage.clickEngSwitcher();
        Assert.assertEquals(mainPage.getCredo().getText(),CREDO);
        mainPage.getRussionSwitcher().click();
    }

    @Test(dependsOnMethods = "switchLanuage")
    public void openServicesPage(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainMenu = new MainMenu(driver);
        mainMenu.getServices().click();
        services = new Services(driver);
        Assert.assertEquals(services.getLabel().getText(),LABEL);

    }

    @AfterMethod
    public void writeLog(ITestResult result, Method method){
        mainPage.getLogo().click();
        logger = Logger.getLogger(CaseTest.class);
        String methodName = result.getName();
        logger.info("[RUN]" +  methodName);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
