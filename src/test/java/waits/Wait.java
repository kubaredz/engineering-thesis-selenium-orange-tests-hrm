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

    private static WebDriverWait setWaitDuration() {
        webDriverWait = new WebDriverWait(DriverPicker.driverSetup(), Duration.ofSeconds(propertiesReader.getImplicitlyWait()));
        return webDriverWait;
    }

    public static void waitTillElementIsPresent(WebElement webElement) {
        webDriverWait = setWaitDuration();
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitTillElementIsClickableByWebElement(WebElement webElement) {
        webDriverWait = setWaitDuration();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitTillElementIsClickableByLocator(By locator) {
        webDriverWait = setWaitDuration();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitSleep() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}