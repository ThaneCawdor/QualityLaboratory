package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProfilePage extends BasePage {

    Actions actions = new Actions(wd);
    @FindBy(xpath = "//span[@class='compose-button__txt']")
    private WebElement writeALetter;
    @FindBy(xpath = "//input[@type='text' and @tabindex='100']")
    private WebElement address;
    @FindBy(xpath = "//div[@data-cke-widget-id='0']/preceding-sibling::div[2]")
    private WebElement fieldInputText;
    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement buttonSend;
    @FindBy(xpath = "//a[@class='layer__link']")
    private WebElement confirmation;
    @FindBy(xpath = "//img[starts-with(@class, \"ph-avatar-img\")]")
    private WebElement avatar;
    @FindBy(xpath = "//div[text()='Выйти']")
    private WebElement buttonLogout;
    @FindBy(xpath = "//span[@title='Закрыть']")
    private WebElement close;

    public ProfilePage() {
        PageFactory.initElements(wd, this);
    }

    public void toSendALetter(String addressRecipient, String letter) {
        writeALetter.click();
        address.sendKeys(addressRecipient);
        new WebDriverWait(wd, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(fieldInputText));
        actions.moveToElement(fieldInputText).click().sendKeys(letter).build().perform();
        buttonSend.click();
    }

    public String getTextConf() {
        return confirmation.getText();
    }

    public void logout() {
        close.click();
        avatar.click();
        buttonLogout.click();
    }
}
