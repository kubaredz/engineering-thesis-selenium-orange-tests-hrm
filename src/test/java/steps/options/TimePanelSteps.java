package steps.options;

import builders.TimePanelBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class TimePanelSteps extends TimePanelBuilder {

    public TimePanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public TimePanelSteps clickTimePanelSection() {
        timePanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Time\" został wciśnięty");
        return new TimePanelSteps();
    }

    public boolean isTimesheetSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Timesheet\" została wyświetlona");
        return timesheetSection.isDisplayed();
    }

    public TimePanelSteps setEmployeeName(String name) {
        employeeNameLabel.sendKeys(name);
        logger.log(Level.INFO, "Imię: \"{0}\" zostało wpisane", name);
        return new TimePanelSteps();
    }

    public TimePanelSteps pickPromptedEmployeeName() {
        promptedEmployeeName.click();
        logger.log(Level.INFO, "Wybranie wyświetlonego imienia");
        return new TimePanelSteps();
    }

    public TimePanelSteps clickViewButton() {
        viewButton.click();
        logger.log(Level.INFO, "kliknięcie przycisku: \"view\"");
        return new TimePanelSteps();
    }

    public boolean isTimeSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Time\" jest widoczna");
        return timeSection.isDisplayed();
    }

    public boolean isAlertInfoDisplayed() {
        logger.log(Level.INFO, "Alert: \"Info\" jest widoczny");
        return infoAlert.isDisplayed();
    }
}
