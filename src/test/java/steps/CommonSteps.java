package steps;

import builders.CommonBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;
import steps.options.TimePanelSteps;

import java.util.logging.Level;

public class CommonSteps extends CommonBuilder {

    public CommonSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Step("Zaladowanie adresu strony")
    public String getSectionUrlAddress() {
        String sectionUrlAddress = DriverPicker.driverSetup().getCurrentUrl();
        logger.log(Level.INFO, "Zaladowanie adresu strony");
        return sectionUrlAddress;
    }

    @Step("Utworzenie selektora dla sekcji {section}")
    public CommonSteps generateAndClickSelectorForAllSections(String section) {
        String selector = "a[href='/web/index.php/" + section.toLowerCase() + "/view" + section + "Module']";
        generatedSection = DriverPicker.driverSetup().findElement(By.cssSelector(selector));
        generatedSection.click();
        logger.log(Level.INFO, "Utworzenie selektora dla sekcji: {0}", section);
        return new CommonSteps();
    }

    @Step("Wcisniecie przycisku: {button}'")
    public TimePanelSteps clickButtonWithNormalizeSpace(String selectedButton) {
        String selector = "//button[normalize-space()='selectedButton']";
        pickedButton = DriverPicker.driverSetup().findElement(By.xpath(selector.replace("selectedButton", selectedButton)));
        logger.log(Level.INFO, "Wybranie przycisku do wcisniecia: {0} ", selectedButton);
        pickedButton.click();
        logger.log(Level.INFO, "Wcisniecie przycisku: {0} ", selectedButton);
        return new TimePanelSteps();
    }
}