package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Services extends MainPage {

    public Services(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='page-title']")
    private WebElement label;

    public WebElement getLabel() {
        return label;
    }
}
