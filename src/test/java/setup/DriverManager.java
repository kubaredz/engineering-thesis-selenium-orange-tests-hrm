package setup;

import browsers.BrowserPicker;
import browsers.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final BrowserType BROWSER_TYPE = BrowserType.CHROME;
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver driverSetup() {
        if (driver == null) {
            driver = BrowserPicker.chooseBrowser(BROWSER_TYPE);
        }
        return driver;
    }

    public static void extinctionDriver() {
//        driver.close();
//        if (!BROWSER_TYPE.equals(BrowserType.FIREFOX)) {
//            driver.quit();
//        }
//        driver = null;
    }
}