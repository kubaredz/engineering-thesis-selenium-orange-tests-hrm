package steps.options;

import builders.options.TimePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;
import utils.RepeatedActions;

import java.util.logging.Level;

public class TimePanelSteps extends TimePanelBuilder implements CommonSteps, CommonGenericSteps<TimePanelSteps> {

    public TimePanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'Timesheet' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Timesheet\" została wyświetlona");
        return headerTextAddition.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Time' zostala otwarta")
    public <T> TimePanelSteps clickPimPanelSection() {
        timePanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Time\" został wciśnięty");
        return new TimePanelSteps();
    }

    @Override
    public <T> CommonGenericSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> CommonGenericSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }

    @Step("Imie pracownika: {name} zostalo wpisane")
    public TimePanelSteps setEmployeeName(String name) {
        RepeatedActions.deletingAndAddingContentToLabel(employeeNameLabel, name);
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
