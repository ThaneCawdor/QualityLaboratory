package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.Constants.BASE_URI;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@data-click-counter='75068996']")
    private WebElement authButton;
    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement iframe;


    public MainPage() {
        PageFactory.initElements(wd, this);
        open(BASE_URI);
    }

    public LoginToAccountIframePage initAuth() {
        authButton.click();
        wd.switchTo().frame(iframe);
        return new LoginToAccountIframePage();
    }


}
