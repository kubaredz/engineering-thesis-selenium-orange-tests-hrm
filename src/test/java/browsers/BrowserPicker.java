package browsers;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserPicker {

    public static WebDriver chooseBrowser(BrowserType type) {
        if (type == BrowserType.CHROME) {
            setPropertyOfSystem("webdriver.chrome.driver", LocalWebDriverProperties.getChromeWebDriverLocation());
            return new ChromeDriver();
        }
        if (type == BrowserType.FIREFOX) {
            setPropertyOfSystem("webdriver.gecko.driver", LocalWebDriverProperties.getFirefoxWebDriverLocation());
            return new FirefoxDriver();
        } else
            throw new IllegalStateException("Invalid browser");
    }

    private static void setPropertyOfSystem(String driverType, String driverPath) {
        System.setProperty(driverType, driverPath);
    }
}
