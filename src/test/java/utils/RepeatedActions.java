package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.DriverPicker;

public class RepeatedActions {

    public static void deletingAndAddingContentToLabel(WebElement webElement, String content) {
        new Actions(DriverPicker.driverSetup()).click(webElement)
                .pause(100).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .pause(100).sendKeys(Keys.BACK_SPACE)
                .pause(100).sendKeys(content).perform();
    }

    public static void scrollToElement(WebElement webElement) {
        Actions actions = new Actions(DriverPicker.driverSetup());
        actions.scrollToElement(webElement).perform();
    }

    public static void doubleClickElement(WebElement webElement) {
        Actions actions = new Actions(DriverPicker.driverSetup());
        actions.moveToElement(webElement).doubleClick().build().perform();
    }
}