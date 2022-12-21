package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.DriverManager;

public class RepeatedActions {

    public static void deletingAndAddingContentToLabel(WebElement webElement, String content) {
        new Actions(DriverManager.driverSetup()).click(webElement)
                .pause(200).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .pause(200).sendKeys(Keys.BACK_SPACE)
                .pause(200).sendKeys(content).perform();
    }
}
