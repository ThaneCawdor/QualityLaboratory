package core;

import configuration.DriverConfiguration;
import constants.Constants;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static WebDriver wd;


    @BeforeAll
    public static void setUp() {
        wd = DriverConfiguration.createWebDriver(Constants.CHROME);
        BasePage.setDriver(wd);

    }


    @AfterAll
    public static void closeBrowser() {
        wd.quit();
    }
}
