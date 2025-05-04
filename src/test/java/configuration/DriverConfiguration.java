package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static constants.Constants.CHROME;
import static constants.Constants.FIREFOX;

public class DriverConfiguration {
    public static WebDriver createWebDriver(String nameDriver) {
        WebDriver wd;
        if (nameDriver.equals(CHROME)) {
            wd = new ChromeDriver(setOptionsForLocalWebDriver());
        } else if (nameDriver.equals(FIREFOX)) {
            wd = new FirefoxDriver(setOptionsForLocalWebDriverFireFox());
        } else throw new IllegalArgumentException("DriverType [" + nameDriver + "] is not supported.");
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return wd;
    }


    private static ChromeOptions setOptionsForLocalWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.setAcceptInsecureCerts(true);
        options.addArguments("--disable-web-security");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--silent");
        //options.addArguments("--headless");
        options.addArguments("--start-maximized");
        return options;
    }

    private static FirefoxOptions setOptionsForLocalWebDriverFireFox() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-web-security");
        options.addArguments("--ignore-certificate-errors");
        //options.addArguments("--headless");
        options.addArguments("--silent");
        return options;
    }

}