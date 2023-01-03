package steps;

import builders.CommonBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;
import steps.options.TimePanelSteps;

import java.util.logging.Level;

public class CommonSteps extends CommonBuilder {

    public CommonSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Step("Utworzenie selektora dla sekcji {section}")
    public CommonSteps generateAndClickSelectorForAllSections(String section) {
        String cssSelector = "a[href='/web/index.php/" + section.toLowerCase() + "/view" + section + "Module']";
        WebElement generatedSection = DriverPicker.driverSetup().findElement(By.cssSelector(cssSelector));
        generatedSection.click();
        logger.log(Level.INFO, "Utworzenie selektora dla sekcji: {0}", section);
        return new CommonSteps();
    }

    @Step("Zaladowanie adresu strony")
    public String getSectionUrlAddress() {
        String sectionUrlAddress = DriverPicker.driverSetup().getCurrentUrl();
        logger.log(Level.INFO, "Zaladowanie adresu strony");
        return sectionUrlAddress;
    }

    @Step("Wcisniecie przycisku: {button}'")
    public TimePanelSteps clickButtonWithNormalizeSpace(String button) {
        String fieldGroupSelector = "//button[normalize-space()='" + button + "']";
        System.out.println(fieldGroupSelector);
        WebElement pickedButton = DriverPicker.driverSetup().findElement(By.xpath(fieldGroupSelector));
        logger.log(Level.INFO, "Wybranie przycisku do wcisniecia: {0} ", button);
        pickedButton.click();
        logger.log(Level.INFO, "Wcisniecie przycisku: {0} ", button);
        return new TimePanelSteps();
    }
}
