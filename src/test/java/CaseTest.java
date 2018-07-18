import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import page_object.MainPage;
import utility.DriverSet;


public class CaseTest {

    WebDriver driver;
    MainPage mainPage;

    @Test
    public void openBrowser() {
        driver = DriverSet.getDriver();
        driver.get("http://energy-ss.com");
        mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isLogVisible());
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
