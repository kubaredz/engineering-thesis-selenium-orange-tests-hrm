package setup;

import browsers.BrowserPicker;
import browsers.BrowserType;
import properties.ConfigurationProperties;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver driverSetup() {
        if (driver == null) {
            driver = BrowserPicker.chooseBrowser(BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser.type")));
        }
        return driver;
    }

    public static void extinctionDriver() {
        DriverManager.driver.close();
        if (!ConfigurationProperties.getProperties().getProperty("browser.type").equals(BrowserType.FIREFOX)){
            DriverManager.driver.quit();
        }
        driver = null;
    }
}