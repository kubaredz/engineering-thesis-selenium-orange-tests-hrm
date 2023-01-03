package steps.options;

import builders.options.LeavePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;
import utils.RepeatedActions;

import java.util.logging.Level;

public class LeavePanelSteps extends LeavePanelBuilder implements DefaultSteps, CommonSteps {
    public LeavePanelSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'Leave' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Leave\" zostala wyswietlona");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Leave' zostala otwarta")
    public LeavePanelSteps clickPanelSection() {
        leavePanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Leave\" zostal wcisniety");
        return new LeavePanelSteps();
    }

    @Override
    public CommonSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CommonSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }

    @Step("Przycisk 'Assign' zostal wcisniety")
    public LeavePanelSteps clickAssignLeaveButton() {
        assignLeaveButton.click();
        logger.log(Level.INFO, "Przycisk: \"Assign Leave\" zostal wcisniety");
        return new LeavePanelSteps();
    }

    @Step("Imie pracownika: {name} zostalo wpisane")
    public LeavePanelSteps setEmployeeName(String name) {
        RepeatedActions.deletingAndAddingContentToLabel(employeeNameLabel, name);
        logger.log(Level.INFO, "Imie i nazwisko pracownika: \"{0}\" zostalo wpisane", name);
        return new LeavePanelSteps();
    }

    @Step("Podpowiedziane imie zostalo wybrane")
    public LeavePanelSteps pickPromptedEmployee() {
        promptedEmployeeData.click();
        logger.log(Level.INFO, "Imie i nazwisko pracownika zostalo wybrane z listy");
        return new LeavePanelSteps();
    }

    @Step("Lista: 'Leave type' zostala wcisnieta")
    public LeavePanelSteps clickLeaveTypeSection() {
        leaveTypeSection.click();
        logger.log(Level.INFO, "Lista: \"Leave type\" zostala kliknieta");
        return new LeavePanelSteps();
    }

    @Step("Typ Urlopu: 'wakacje' zostal wybrany")
    public LeavePanelSteps pickVacationLeave() {
        vacationOption.click();
        logger.log(Level.INFO, "Leave type: \"Vacation\" zostal wybrany");
        return new LeavePanelSteps();
    }

    @Step("Data urlopu od: {dateFrom} zostala wybrana")
    public LeavePanelSteps pickFromDate(String dateFrom) {
        RepeatedActions.deletingAndAddingContentToLabel(fromDateLabel, dateFrom);
        logger.log(Level.INFO, "Data od: \"{0}\" zostala wybrana", dateFrom);
        return new LeavePanelSteps();
    }

    @Step("Data urlopu do zostala wybrana")
    public LeavePanelSteps pickToDate(String dateTo) {
        RepeatedActions.deletingAndAddingContentToLabel(toDateLabel, dateTo);
        logger.log(Level.INFO, "Data do zostala dodana automatycznie");
        return new LeavePanelSteps();
    }

    @Step("Komentarz do urlopu: {comment} zostal wpisany ")
    public LeavePanelSteps writeComment(String comment) {
        RepeatedActions.deletingAndAddingContentToLabel(commentsTextArea, comment);
        logger.log(Level.INFO, "Komentarz zostal napisany: {0}", comment);
        return new LeavePanelSteps();
    }

    @Step("Przycisk: 'Assign' zostal wcisniety")
    public LeavePanelSteps clickAssignButton() {
        assignButton.click();
        logger.log(Level.INFO, "Przycisk: \"Assign\" zostal wcisniety");
        return new LeavePanelSteps();
    }

    @Step("Popup 'Conifrm Leave Assignment' zostal wyswietlony")
    public boolean isConfirmLeaveAssignmentPopupDisplayed() {
        logger.log(Level.INFO, "Popup \"Confirm Leave Assignment\"zostal wyswietlony");
        return confirmLeaveAssignmentPopup.isDisplayed();
    }

    @Step("Przycisk 'Confirm Leave Assignment' zostal wcisniety")
    public LeavePanelSteps clickConfirmLeaveAssignmentButton() {
        confirmLeaveAssignmentButton.click();
        logger.log(Level.INFO, "Przycisk: \"Confirm Leave Assignment - Ok\" zostal wcisniety");
        return new LeavePanelSteps();
    }
}

