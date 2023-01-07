package steps.options;

import builders.options.MyInfoPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import static setup.DriverPicker.driverSetup;
import static utils.RepeatedActions.deletingAndAddingContentToLabel;
import static waits.Wait.waitSleep;

public class MyInfoSteps extends MyInfoPanelBuilder implements DefaultSteps, CommonSteps {

    public MyInfoSteps() {
        PageFactory.initElements(driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'PIM' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"PIM\" zostala wyswietlona");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'My Info' zostala otwarta")
    public MyInfoSteps clickPanelSection() {
        myInfoSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"My Info\" zostal wcisniety");
        return new MyInfoSteps();
    }

    @Override
    public CommonSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    @Step("Wcisniecie przycisku 'Save'")
    public MyInfoSteps clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Przycisk: \"save\" zostal wcisniety");
        return new MyInfoSteps();
    }

    @Step("Przycisk dla wewnetrznej sekcji: 'Personal Details' zostal wcisniety")
    public MyInfoSteps clickPersonalDetailsSection() {
        personalDetailsSection.click();
        logger.log(Level.INFO, "Przycisk dla wewnetrznej sekcji: \"Personal Details\" zostal wcisniety");
        return new MyInfoSteps();
    }

    @Step("Imie: {firstName} zostalo wpisane")
    public MyInfoSteps setFirstName(String firstName) {
        waitSleep();
        deletingAndAddingContentToLabel(employeeFirstNameLabel, firstName);
        logger.log(Level.INFO, "Imie: \"{0}\" zostalo wpisane", firstName);
        return new MyInfoSteps();
    }

    @Step("Drugie imie: {middleName} zostalo wpisane")
    public MyInfoSteps setMiddleName(String middleName) {
        deletingAndAddingContentToLabel(employeeMiddleNameLabel, middleName);
        logger.log(Level.INFO, "Drugie imie: \"{0}\" zostalo wpisane", middleName);
        return new MyInfoSteps();
    }

    @Step("Nazwisko: {lastName} zostalo wpisane")
    public MyInfoSteps setLastName(String lastName) {
        deletingAndAddingContentToLabel(employeeLastNameLabel, lastName);
        logger.log(Level.INFO, "Nazwisko: \"{0}\" zostalo wpisane", lastName);
        return new MyInfoSteps();
    }

    @Step("Nazwisko: {lastName} zostalo wpisane")
    public MyInfoSteps setNicknameLabel(String nickname) {
        deletingAndAddingContentToLabel(nicknameLabel, nickname);
        logger.log(Level.INFO, "Nickname: \"{0}\" zostal wpisany", nickname);
        return new MyInfoSteps();
    }

    @Step("Id pracownika: {employeeId} zostalo wpisane")
    public MyInfoSteps setEmployeeIdLabel(String employeeId) {
        deletingAndAddingContentToLabel(employeeIdLabel, employeeId);
        logger.log(Level.INFO, "Employee Id: \"{0}\" zostal wpisany", employeeId);
        return new MyInfoSteps();
    }

    @Step("Dodatkowe id pracownika: {employeeOtherId} zostalo wpisane")
    public MyInfoSteps setEmployeeOtherIdLabel(String employeeOtherId) {
        deletingAndAddingContentToLabel(otherIdLabel, employeeOtherId);
        logger.log(Level.INFO, "Employee other Id: \"{0}\" zostal wpisany", employeeOtherId);
        return new MyInfoSteps();
    }

    @Step("Numer prawo jazdy pracownika: {driversLicenseNumber} zostal wpisany")
    public MyInfoSteps setDriversLicenseNumberLabel(String driversLicenseNumber) {
        deletingAndAddingContentToLabel(driversLicenseNumberLabel, driversLicenseNumber);
        logger.log(Level.INFO, "Driver's License Number: \"{0}\" zostal wpisany", driversLicenseNumber);
        return new MyInfoSteps();
    }

    @Step("Data konca waznosci prawo jazdy pracownika: {date} zostal wpisany")
    public MyInfoSteps setLicenseExpiryDateLabel(String date) {
        deletingAndAddingContentToLabel(licenseExpiryDateLabel, date);
        logger.log(Level.INFO, "Data przeterminowania prawo jazdy to: \"{0}\"", date);
        return new MyInfoSteps();
    }

    @Step("Ssn pracownika: {date} zostal wpisany")
    public MyInfoSteps setSsnNumberLabel(String ssn) {
        deletingAndAddingContentToLabel(ssnNumberLabel, ssn);
        logger.log(Level.INFO, "Podany SSN to: \"{0}\"", ssn);
        return new MyInfoSteps();
    }

    @Step("Sin pracownika: {sinNumber} zostal wpisany")
    public MyInfoSteps setSinNumberLabel(String sinNumber) {
        deletingAndAddingContentToLabel(sinNumberLabel, sinNumber);
        logger.log(Level.INFO, "Podany sin to: \"{0}\"", sinNumber);
        return new MyInfoSteps();
    }

    @Step("Select: 'Narodowosc' zostal wcisniety")
    public MyInfoSteps clickNationalitySelect() {
        nationalitySelect.click();
        logger.log(Level.INFO, "Select: \"Narodowosc\" zostal wcisniety");
        return new MyInfoSteps();
    }

    @Step("Narodowosc pracownika zostala wybrana")
    public MyInfoSteps clickNationality() {
        nationalityLabel.click();
        logger.log(Level.INFO, "Narodowosc: \"Africa\" zostala wybrana");
        return new MyInfoSteps();
    }

    @Step("Lista: 'marital status' zostala otwarta")
    public MyInfoSteps setMaritalStatusList() {
        maritalStatusList.click();
        logger.log(Level.INFO, "Lista: \"Stan cywilny\" zostala wcisnieta");
        return new MyInfoSteps();
    }

    @Step("Marital status: 'Married' zostal wybrany")
    public MyInfoSteps setMaritalStatusMarriedLabel() {
        maritalStatusMarriedLabel.click();
        logger.log(Level.INFO, "Stan cywilny: \"W zwiazku malzenskim\" zostal wybrany");
        return new MyInfoSteps();
    }

    @Step("Data urodzenia: {date} zostala wybrana")
    public MyInfoSteps setDateOfBirthLabel(String date) {
        dateOfBirthLabel.click();
        deletingAndAddingContentToLabel(dateOfBirthLabel, date);
        logger.log(Level.INFO, "Data urodzenia to: \"{0}\"", dateOfBirthLabel.getText());
        return new MyInfoSteps();
    }

    @Step("Radio button female zostal wcisniety")
    public MyInfoSteps clickFemaleGenderRadioButton() {
        genderFemaleRadioButton.click();
        logger.log(Level.INFO, "Radio button: \"Female\" zostal wcisniety");
        return new MyInfoSteps();
    }

    @Step("Pracownik byl w sluzbie wojskowej: {militaryService}")
    public MyInfoSteps setMilitaryServiceLabel(String militaryService) {
        deletingAndAddingContentToLabel(militaryServiceLabel, militaryService);
        logger.log(Level.INFO, "Status sluzby wojskowej to: \"{0}\"", militaryService);
        return new MyInfoSteps();
    }

    @Step("Ustawienie statusu: palacz")
    public MyInfoSteps clickSmokerCheckBox() {
        smokerCheckBox.click();
        logger.log(Level.INFO, "Ustawienie statusu: \"palacz\"");
        return new MyInfoSteps();
    }

    @Step("Alert: 'Positive Alert' zostal wyswietlony")
    public boolean isPositiveAlertDisplayed() {
        logger.log(Level.INFO, "Alert: \"positive\" zostal wyswietlony");
        return positiveAlert.isDisplayed();
    }

    @Step("Blood type select zostal wcisniety")
    public MyInfoSteps clickBloodTypeSection() {
        bloodTypeSection.click();
        logger.log(Level.INFO, "Select: \"Typ krwi\" zostal wcisniety");
        return new MyInfoSteps();
    }

    @Step("Typ krwi b+ zostal wybrany")
    public MyInfoSteps clickBloodTypeBPlusLabel() {
        bloodTypeBPlusLabel.click();
        logger.log(Level.INFO, "Typ krwi: \"B+\" zostal wybrany");
        return new MyInfoSteps();
    }

    @Step("Przycisk save zostal wcisniety")
    public MyInfoSteps clickSecondSaveButton() {
        secondSaveButton.click();
        logger.log(Level.INFO, "Przycisk: \"Save\" zostal wcisniety");
        return new MyInfoSteps();
    }
}