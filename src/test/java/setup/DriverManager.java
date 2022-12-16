package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver driverSetup() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void extinctionDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }
}