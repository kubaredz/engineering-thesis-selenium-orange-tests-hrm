package steps;

import builders.CommonBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import steps.options.TimePanelSteps;

import java.util.logging.Level;

import static setup.DriverPicker.driverSetup;

public class CommonSteps extends CommonBuilder {

    public CommonSteps() {
        PageFactory.initElements(driverSetup(), this);
    }

    @Step("Zaladowanie adresu strony")
    public String getSectionUrlAddress() {
        String sectionUrlAddress = driverSetup().getCurrentUrl();
        logger.log(Level.INFO, "Zaladowanie adresu strony");
        return sectionUrlAddress;
    }

    @Step("Utworzenie selektora dla sekcji {section}")
    public CommonSteps clickSelectorForAllSections(String section) {
        String selector = "a[href='/web/index.php/" + section.toLowerCase() + "/view" + section + "Module']";
        generatedSection = driverSetup().findElement(By.cssSelector(selector));
        generatedSection.click();
        logger.log(Level.INFO, "Utworzenie selektora dla sekcji: {0}", section);
        return new CommonSteps();
    }

    @Step("Wcisniecie przycisku: {button}'")
    public TimePanelSteps clickButtonWithNormalizedSpace(String selectedButton) {
        String selector = "//button[normalize-space()='selectedButton']";
        pickedButton = driverSetup().findElement(By.xpath(selector.replace("selectedButton", selectedButton)));
        logger.log(Level.INFO, "Wybranie przycisku do wcisniecia: {0} ", selectedButton);
        pickedButton.click();
        logger.log(Level.INFO, "Wcisniecie przycisku: {0} ", selectedButton);
        return new TimePanelSteps();
    }
}