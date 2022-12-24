package setup;

import browsers.BrowserPicker;
import browsers.BrowserType;
import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver driverSetup() {
        if (driver == null) {
            driver = BrowserPicker.chooseBrowser(LocalWebDriverProperties.getLocalBrowser());
        }
        return driver;
    }

    public static void extinctionDriver() {
        driver.close();
        if (!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)){
            driver.quit();
        }
        driver = null;
    }
}