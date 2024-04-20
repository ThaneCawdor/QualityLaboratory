package core;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver wd;

    public static void setDriver(WebDriver webDriver) {
        wd = webDriver;
    }

    public static void open(String url) {
        wd.get(url);
    }
}
