package browsers;

import properties.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserPicker {

    public static WebDriver chooseBrowser(BrowserType type) {
        if (type == BrowserType.CHROME) {
            setPropertyOfSystem("webdriver.chrome.driver", PropertiesReader.getProperties().getProperty("chromeDriver"));
            return new ChromeDriver();
        }
        if (type == BrowserType.FIREFOX) {
            setPropertyOfSystem("webdriver.gecko.driver", PropertiesReader.getProperties().getProperty("firefoxDriver"));
            return new FirefoxDriver();
        } else
            throw new IllegalStateException("Przegladarka ktora zostala wybrana, nie jest obslugiwana");
    }

    private static void setPropertyOfSystem(String driverType, String driverPath) {
        System.setProperty(driverType, driverPath);
    }
}