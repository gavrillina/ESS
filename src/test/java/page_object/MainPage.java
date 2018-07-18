package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath ="")
    private WebElement label;

    public WebElement getLogo() {
        return logo;
    }

    public boolean isLogVisible() {
        getLogo().isEnabled();
        return true;
    }
}
