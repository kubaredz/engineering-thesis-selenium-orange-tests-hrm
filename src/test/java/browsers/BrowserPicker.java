package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserPicker {
    private final static String PREFIX = "resources";

    public static WebDriver chooseBrowser(BrowserType type) {
        if (type == BrowserType.CHROME) {
            setPropertyOfSystem("webdriver.chrome.driver", "/chromedriver.exe");
            return new ChromeDriver();
        }
        if (type == BrowserType.FIREFOX) {
            setPropertyOfSystem("webdriver.gecko.driver", "/geckodriver.exe");
            return new FirefoxDriver();
        } else
            throw new IllegalStateException("Invalid browser");
    }

    private static void setPropertyOfSystem(String driverType, String driverPath) {
        String resPath = PREFIX + driverPath;
        System.setProperty(driverType, resPath);
    }
}
