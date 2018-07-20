package page_object;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.DriverSet;

public class MainPage {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = ".//*[@class='logo']")
    private WebElement logo;

    @FindBy(xpath ="//*[@class='language-link']")
    private WebElement englSwitcher;

    @FindBy(xpath = "//*[@id='block-block-9']")
    private WebElement credo;


    private WebElement getLogo() {
        return logo;
    }

    public WebElement getEnglSwitcher() {
        return englSwitcher;
    }

    public boolean isLogVisible() {

        getLogo().isEnabled();
        return true;
    }

    public MainPage clickEngSwitcher(){
        englSwitcher.click();
        return this;
    }

    public WebElement getCredo() {
        return credo;
    }

    public static void highlightElement(WebElement element) {
        WebDriver driver = DriverSet.getDriver();
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='5px solid green'", element);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }
}
