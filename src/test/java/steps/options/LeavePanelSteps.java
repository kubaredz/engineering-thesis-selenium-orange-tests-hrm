package steps.options;

import builders.options.LeavePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class LeavePanelSteps extends LeavePanelBuilder implements CommonSteps, CommonGenericSteps<LeavePanelBuilder> {
    public LeavePanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'Leave' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Leave\" została wyświetlona");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Leave' zostala otwarta")
    public <T> LeavePanelSteps clickPanelSection() {
        leavePanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Leave\" został wciśnięty");
        return new LeavePanelSteps();
    }

    @Step("Przycisk 'Assign' zostal wcisniety")
    public LeavePanelSteps clickAssignLeaveButton() {
        assignLeaveButton.click();
        logger.log(Level.INFO, "Przycisk: \"Assign Leave\" został wciśnięty");
        return new LeavePanelSteps();
    }

    @Step("Imie pracownika: {name} zostalo wpisane")
    public LeavePanelSteps setEmployeeName(String name) {
        employeeNameLabel.sendKeys(name);
        logger.log(Level.INFO, "Imię i nazwisko pracownika: \"{0}\" zostało wpisane", name);
        return new LeavePanelSteps();
    }

    @Step("Podpowiedziane imie zostalo wybrane")
    public LeavePanelSteps pickPromptedEmployee() {
        promptedEmployeeData.click();
        logger.log(Level.INFO, "Imię i nazwisko pracownika zostało wybrane z listy");
        return new LeavePanelSteps();
    }

    @Step("Lista: 'Leave type' zostala wcisnieta")
    public LeavePanelSteps clickLeaveTypeSection() {
        leaveTypeSection.click();
        logger.log(Level.INFO, "Lista: \"Leave type\" została kliknięta");
        return new LeavePanelSteps();
    }

    @Step("Typ Urlopu: 'wakacje' zostal wybrany")
    public LeavePanelSteps pickVacationLeave() {
        vacationOption.click();
        logger.log(Level.INFO, "Leave type: \"Vacation\" został wybrany");
        return new LeavePanelSteps();
    }

    @Step("Data urlopu od: {dateFrom} zostala wybrana")
    public LeavePanelSteps pickFromDate(String dateFrom) {
        fromDateLabel.sendKeys(dateFrom);
        logger.log(Level.INFO, "Data od: \"{0}\" została wybrana", dateFrom);
        return new LeavePanelSteps();
    }

    @Step("Data urlopu do zostala wybrana")
    public LeavePanelSteps pickToDate() {
        toDateLabel.click();
        logger.log(Level.INFO, "Data do została dodana automatycznie");
        return new LeavePanelSteps();
    }

    @Step("Komentarz do urlopu: {comment} zostal wpisany ")
    public LeavePanelSteps writeComment(String comment) {
        commentsTextArea.sendKeys(comment);
        logger.log(Level.INFO, "Komentarz został napisany: {0}", comment);
        return new LeavePanelSteps();
    }

    @Step("Przycisk: 'Assign' zostal wcisniety")
    public LeavePanelSteps clickAssignButton() {
        assignButton.click();
        logger.log(Level.INFO, "Przycisk: \"Assign\" został wciśnięty");
        return new LeavePanelSteps();
    }

    @Step("Popup 'Conifrm Leave Assignment' zostal wyswietlony")
    public boolean isConfirmLeaveAssignmentPopupDisplayed() {
        logger.log(Level.INFO, "Popup \"Confirm Leave Assignment\"został wyświetlony");
        return confirmLeaveAssignmentPopup.isDisplayed();
    }

    @Step("Przycisk 'Confirm Leave Assignment' zostal wcisniety")
    public LeavePanelSteps clickConfirmLeaveAssignmentButton() {
        confirmLeaveAssignmentButton.click();
        logger.log(Level.INFO, "Przycisk: \"Confirm Leave Assignment - Ok\" został wciśnięty");
        return new LeavePanelSteps();
    }
}

