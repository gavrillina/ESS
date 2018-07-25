package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends MainPage {

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='first expanded']")
    private WebElement aboutCompany;

    @FindBy(xpath = "//*[contains(text(),'Услуги')]")
    private WebElement Services;

    @FindBy(xpath = "//*[@class='collapsed']")
    private WebElement Project;

    @FindBy(xpath = "//*[contains(text(),'Партнеры')]")
    private WebElement Partners;

    @FindBy(xpath = "//*[contains(text(),'Вакансии')]")
    private WebElement Vacancy;

    @FindBy(xpath = "//*[contains(text(),'Контакты')]")
    private WebElement Contacts;

    public WebElement getAboutCompany() {
        return aboutCompany;
    }

    public WebElement getServices() {
        return Services;
    }

    public WebElement getProject() {
        return Project;
    }

    public WebElement getPartners() {
        return Partners;
    }

    public WebElement getVacancy() {
        return Vacancy;
    }

    public WebElement getContacts() {
        return Contacts;
    }
}
