package steps.options;

import builders.LeavePanelBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class LeavePanelSteps extends LeavePanelBuilder {
    public LeavePanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public LeavePanelSteps clickLeavePanelSection() {
        leavePanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Leave\" został wciśnięty");
        return new LeavePanelSteps();
    }

    public boolean isLeaveSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Leave\" została wyświetlona");
        return userManagementSection.isDisplayed();
    }

    public LeavePanelSteps clickAssignLeaveButton() {
        assignLeaveButton.click();
        logger.log(Level.INFO, "Przycisk: \"Assign Leave\" został wciśnięty");
        return new LeavePanelSteps();
    }

    public LeavePanelSteps setEmployeeName(String name) {
        employeeNameLabel.sendKeys(name);
        logger.log(Level.INFO, "Imię i nazwisko pracownika: \"{0}\" zostało wpisane", name);
        return new LeavePanelSteps();
    }

    public LeavePanelSteps pickPromptedEmployee() {
        promptedEmployeeData.click();
        logger.log(Level.INFO, "Imię i nazwisko pracownika zostało wybrane z listy");
        return new LeavePanelSteps();
    }

    public LeavePanelSteps clickLeaveTypeSection() {
        leaveTypeSection.click();
        logger.log(Level.INFO, "Lista: \"Leave type\" została kliknięta");
        return new LeavePanelSteps();
    }

    public LeavePanelSteps pickVacationLeave() {
        vacationOption.click();
        logger.log(Level.INFO, "Leave type: \"Vacation\" został wybrany");
        return new LeavePanelSteps();
    }

    public LeavePanelSteps pickFromDate(String dateFrom) {
        fromDateLabel.sendKeys(dateFrom);
        logger.log(Level.INFO, "Data od: \"{0}\" została wybrana", dateFrom);
        return new LeavePanelSteps();
    }

    public LeavePanelSteps pickToDate() {
        toDateLabel.click();
        logger.log(Level.INFO, "Data do została dodana automatycznie");
        return new LeavePanelSteps();
    }

    public LeavePanelSteps writeComment(String comment) {
        commentsTextArea.sendKeys(comment);
        logger.log(Level.INFO, "Komentarz został napisany: {0}", comment);
        return new LeavePanelSteps();
    }

    public LeavePanelSteps clickAssignButton() {
        assignButton.click();
        logger.log(Level.INFO, "Przycisk: \"Assign\" został wciśnięty");
        return new LeavePanelSteps();
    }

    public boolean isConfirmLeaveAssignmentPopupDisplayed() {
        logger.log(Level.INFO, "Popup \"Confirm Leave Assignment\"został wyświetlony");
        return confirmLeaveAssignmentPopup.isDisplayed();
    }

    public LeavePanelSteps clickConfirmLeaveAssignmentButton() {
        confirmLeaveAssignmentButton.click();
        logger.log(Level.INFO, "Przycisk: \"Confirm Leave Assignment - Ok\" został wciśnięty");
        return new LeavePanelSteps();
    }
}

