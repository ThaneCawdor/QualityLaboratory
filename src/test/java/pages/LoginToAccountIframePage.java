package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToAccountIframePage extends BasePage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputName;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@data-test-id='next-button']")
    private WebElement enterPassword;
    @FindBy(xpath = "//button[@data-test-id='submit-button']")
    private WebElement enter;

    public LoginToAccountIframePage() {
        PageFactory.initElements(wd, this);
    }


    public LoginToAccountIframePage fillFormLogin(String login) {
        inputName.sendKeys(login);
        enterPassword.click();
        return this;
    }

    public ProfilePage fillFormPass(String password) {
        inputPassword.sendKeys(password);
        enter.click();
        return new ProfilePage();
    }


}
