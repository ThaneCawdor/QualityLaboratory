package tests;

import core.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProfilePage;

import static constants.Constants.*;

public class SendLetterTest extends BaseTest {
    ProfilePage profilePage = new ProfilePage();

    @BeforeEach
    public void preconditions() {
        MainPage mainPage = new MainPage();
        mainPage.initAuth()
                .fillFormLogin(login)
                .fillFormPass(password);
    }

    @Test
    public void sendMail() {
        profilePage.toSendALetter(toWhom, textLetter);
        Assertions.assertEquals(expectedText, profilePage.getTextConf());
    }

    @AfterEach
    public void logout() {
        profilePage.logout();
    }

}
