package utils;

import org.openqa.selenium.By;
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

    public static WebElement prepareWebElementWithDynamicXpath (String xpathValue, String substitutionValue ) {
        return DriverPicker.driverSetup().findElement(By.xpath(xpathValue.replace("criteria", substitutionValue)));
    }
}