package steps.options;

import builders.TimePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class TimePanelSteps extends TimePanelBuilder {

    public TimePanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Step("Sekcja: 'Time' zostala otwarta")
    public TimePanelSteps clickTimePanelSection() {
        timePanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Time\" został wciśnięty");
        return new TimePanelSteps();
    }

    @Step("Sekcja 'Timesheet' zostala wyswietlona")
    public boolean isTimesheetSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Timesheet\" została wyświetlona");
        return headerTextAddition.isDisplayed();
    }

    @Step("Imie pracownika: {name} zostalo wpisane")
    public TimePanelSteps setEmployeeName(String name) {
        employeeNameLabel.sendKeys(name);
        logger.log(Level.INFO, "Imię: \"{0}\" zostało wpisane", name);
        return new TimePanelSteps();
    }

    @Step("Wybranie wyswietlonego pracownika")
    public TimePanelSteps pickPromptedEmployeeName() {
        promptedEmployeeName.click();
        logger.log(Level.INFO, "Wybranie wyświetlonego imienia");
        return new TimePanelSteps();
    }

    @Step("Przycisk: 'view' zostal wcisniety")
    public TimePanelSteps clickViewButton() {
        viewButton.click();
        logger.log(Level.INFO, "kliknięcie przycisku: \"view\"");
        return new TimePanelSteps();
    }

    @Step("Sekcja: 'Time' zostala wyswietlona")
    public boolean isTimeSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Time\" jest widoczna");
        return headerTextPrefix.isDisplayed();
    }

    @Step("Alert: 'Info' zostal wyswietlony")
    public boolean isAlertInfoDisplayed() {
        logger.log(Level.INFO, "Alert: \"Info\" jest widoczny");
        return infoAlert.isDisplayed();
    }
}
