package setup;

import properties.PropertiesReader;
import org.openqa.selenium.WebDriver;

public class DriverPicker {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverPicker.driver = driver;
    }

    public static WebDriver driverSetup() {
        if (driver == null) {
            driver = PropertiesReader.chooseBrowser(PropertiesReader.getBrowserType());
        }
        return driver;
    }
}