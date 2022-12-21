package steps.options;

import builders.MyInfoPanelBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;
import utils.RepeatedActions;
import waits.Wait;

import java.util.logging.Level;

public class MyInfoSteps extends MyInfoPanelBuilder {

    public MyInfoSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public MyInfoSteps clickMyInfoSection() {
        myInfoSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"My Info\" został wciśnięty");
        return new MyInfoSteps();
    }

    public boolean isUserManagementSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"PIM\" została wyświetlona");
        return pimSection.isDisplayed();
    }

    public MyInfoSteps clickPersonalDetailsSection() {
        personalDetailsSection.click();
        logger.log(Level.INFO, "Przycisk dla wewnętrznej sekcji: \"Personal Details\" został wciśnięty");
        return new MyInfoSteps();
    }

    public MyInfoSteps setFirstName(String firstName) {
        Wait.waitSleep();
        RepeatedActions.deletingAndAddingContentToLabel(employeeFirstNameLabel, firstName);
        logger.log(Level.INFO, "Imię: \"{0}\" zostało wpisane", firstName);
        return new MyInfoSteps();
    }

    public MyInfoSteps setMiddleName(String middleName) {
        RepeatedActions.deletingAndAddingContentToLabel(employeeMiddleNameLabel, middleName);
        logger.log(Level.INFO, "Drugie imię: \"{0}\" zostało wpisane", middleName);
        return new MyInfoSteps();
    }

    public MyInfoSteps setLastName(String lastName) {
        RepeatedActions.deletingAndAddingContentToLabel(employeeLastNameLabel, lastName);
        logger.log(Level.INFO, "Nazwisko: \"{0}\" zostało wpisane", lastName);
        return new MyInfoSteps();
    }

    public MyInfoSteps setNicknameLabel(String nickname) {
        RepeatedActions.deletingAndAddingContentToLabel(nicknameLabel, nickname);
        logger.log(Level.INFO, "Nickname: \"{0}\" został wpisany", nickname);
        return new MyInfoSteps();
    }

    public MyInfoSteps setEmployeeIdLabel(String employeeId) {
        RepeatedActions.deletingAndAddingContentToLabel(employeeIdLabel, employeeId);
        logger.log(Level.INFO, "Employee Id: \"{0}\" został wpisany", employeeId);
        return new MyInfoSteps();
    }

    public MyInfoSteps setEmployeeOtherIdLabel(String employeeOtherId) {
        RepeatedActions.deletingAndAddingContentToLabel(otherIdLabel, employeeOtherId);
        logger.log(Level.INFO, "Employee other Id: \"{0}\" został wpisany", employeeOtherId);
        return new MyInfoSteps();
    }

    public MyInfoSteps setDriversLicenseNumberLabel(String driversLicenseNumber) {
        RepeatedActions.deletingAndAddingContentToLabel(driversLicenseNumberLabel, driversLicenseNumber);
        logger.log(Level.INFO, "Driver's License Number: \"{0}\" został wpisany", driversLicenseNumber);
        return new MyInfoSteps();
    }

    public MyInfoSteps setLicenseExpiryDateLabel(String date) {
        RepeatedActions.deletingAndAddingContentToLabel(licenseExpiryDateLabel, date);
        logger.log(Level.INFO, "Data przeterminowania prawo jazdy to: \"{0}\"", date);
        return new MyInfoSteps();
    }

    public MyInfoSteps setSsnNumberLabel(String ssn) {
        RepeatedActions.deletingAndAddingContentToLabel(ssnNumberLabel, ssn);
        logger.log(Level.INFO, "SSN to: \"{0}\"", ssn);
        return new MyInfoSteps();
    }

    public MyInfoSteps setSinNumberLabel(String sinNumber) {
        RepeatedActions.deletingAndAddingContentToLabel(sinNumberLabel, sinNumber);
        logger.log(Level.INFO, "Sin to: \"{0}\"", sinNumber);
        return new MyInfoSteps();
    }

    public MyInfoSteps clickNationalitySelect() {
        nationalitySelect.click();
        logger.log(Level.INFO, "Nationality select wybrany");
        return new MyInfoSteps();
    }

    public MyInfoSteps clickNationality() {
        nationalityLabel.click();
        logger.log(Level.INFO, "Nationality to: \"Africa\"");
        return new MyInfoSteps();
    }

    public MyInfoSteps setMaritalStatusList() {
        maritalStatusList.click();
        logger.log(Level.INFO, "Lista marital status została wciśnięta");
        return new MyInfoSteps();
    }

    public MyInfoSteps setMaritalStatusMarriedLabel() {
        maritalStatusMarriedLabel.click();
        logger.log(Level.INFO, "Marital status: \"Married\" został ustawiony");
        return new MyInfoSteps();
    }

    public MyInfoSteps setDateOfBirthLabel(String date) {
        dateOfBirthLabel.click();
        RepeatedActions.deletingAndAddingContentToLabel(dateOfBirthLabel, date);
        logger.log(Level.INFO, "Data urodzenia to: \"{0}\"", dateOfBirthLabel.getText());
        return new MyInfoSteps();
    }

    public MyInfoSteps clickFemaleGenderRadioButton() {
        genderFemaleRadioButton.click();
        logger.log(Level.INFO, "Radio button female został wciśnięty");
        return new MyInfoSteps();
    }

    public MyInfoSteps setMilitaryServiceLabel(String militaryService) {
        RepeatedActions.deletingAndAddingContentToLabel(militaryServiceLabel, militaryService);
        logger.log(Level.INFO, "Military service to: \"{0}\"", militaryService);
        return new MyInfoSteps();
    }

    public MyInfoSteps isSmokerCheckBox() {
        smokerCheckBox.click();
        logger.log(Level.INFO, "Ustawienie statusu: palacz");
        return new MyInfoSteps();
    }

    public MyInfoSteps clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Przycisk save został wciśnięty");
        return new MyInfoSteps();
    }

    public boolean isPositiveAlertDisplayed() {
        logger.log(Level.INFO, "Alert positive został wyświetlony");
        return positiveAlert.isDisplayed();
    }

    public MyInfoSteps clickBloodTypeSection() {
        bloodTypeSection.click();
        logger.log(Level.INFO, "Blood type select został wciśnięty");
        return new MyInfoSteps();
    }

    public MyInfoSteps clickBloodTypeBPlusLabel() {
        bloodTypeBPlusLabel.click();
        logger.log(Level.INFO, "Typ krwi b+ został wybrany");
        return new MyInfoSteps();
    }

    public MyInfoSteps clickSecondSaveButton() {
        secondSaveButton.click();
        logger.log(Level.INFO, "Przycisk save został wciśnięty");
        return new MyInfoSteps();
    }

}