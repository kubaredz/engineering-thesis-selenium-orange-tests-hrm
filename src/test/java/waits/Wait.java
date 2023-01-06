package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertiesReader;
import setup.DriverPicker;

import java.time.Duration;

public class Wait {
    private static WebDriverWait webDriverWait;
    private static PropertiesReader propertiesReader;

    public Wait() {
        webDriverWait = new WebDriverWait(DriverPicker.driverSetup(), Duration.ofSeconds(propertiesReader.getImplicitlyWait()));
    }

    public static void waitTillElementIsPresent(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitTillElementIsClickableByWebElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitTillElementIsClickableByLocator(By locator) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitSleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}