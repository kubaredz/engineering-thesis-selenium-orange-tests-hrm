package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.DriverPicker;

import java.time.Duration;

public class Wait {

    private static WebDriverWait setWaitDuration() {
        WebDriverWait wait = new WebDriverWait(DriverPicker.driverSetup(), Duration.ofSeconds(10));
        return wait;
    }

    public static void waitTillElementIsPresent(WebElement element) {
        WebDriverWait webDriverWait = setWaitDuration();
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitTillElementIsClickableByWebElement(WebElement element) {
        WebDriverWait webDriverWait = setWaitDuration();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitTillElementIsClickableByLocator(By locator) {
        WebDriverWait webDriverWait = setWaitDuration();
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
