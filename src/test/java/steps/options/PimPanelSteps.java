package steps.options;

import builders.options.PimPanelBuilder;

import helpers.UserDataGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;
import utils.RepeatedActions;

import java.util.logging.Level;

public class PimPanelSteps extends PimPanelBuilder implements DefaultSteps, CommonSteps {

    public PimPanelSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'PIM' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"PIM\" zostala wyswietlona");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'PIM' zostala otwarta")
    public PimPanelSteps clickPanelSection() {
        pimPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"PIM\" zostal wcisniety");
        return new PimPanelSteps();
    }

    @Override
    @Step("Przycisk: 'Add' zostal wcisniety")
    public PimPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" zostal wcisniety");
        return new PimPanelSteps();
    }

    @Override
    @Step("Przycisk 'save' zostal wcisniety")
    public PimPanelSteps clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Przycisk: \"Save\" zostal wcisniety");
        return new PimPanelSteps();
    }

    @Step("Tekst: 'Add employee' zostal wyswietlony")
    public boolean isAddEmployeeTextDisplayed() {
        logger.log(Level.INFO, "Tekst \"Add employee\" zostal wyswietlony");
        return addText.isDisplayed();
    }

    @Step("Tekst: 'Add employee' zostal pobrany")
    public String getAddEmployeeText() {
        logger.log(Level.INFO, "Tekst: \"Add Employee\" zostal pobrany");
        return addText.getText();
    }

    @Step("Lokalizacja zdjecia: {imgPath} zostala przekazana")
    public PimPanelSteps setUploadImageButton(String imgPath) {
        uploadImageButton.sendKeys(imgPath);
        logger.log(Level.INFO, "Lokalizacja zdjecia: {0} zostala przekazana", imgPath);
        return new PimPanelSteps();
    }

    @Step("Imie pracownika: {firstName} zostalo wpisane")
    public PimPanelSteps setFirstNameLabel(String firstName) {
        firstNameLabel.sendKeys(firstName);
        logger.log(Level.INFO, "Imie pracownika: {0} zostalo wpisane", firstName);
        return new PimPanelSteps();
    }

    @Step("Drugie imie pracownika: {middleName} zostalo wpisane")
    public PimPanelSteps setMiddleNameLabel(String middleName) {
        middleNameLabel.sendKeys(middleName);
        logger.log(Level.INFO, "Drugie imie pracownika: {0} zostalo wpisane", middleName);
        return new PimPanelSteps();
    }

    @Step("Nazwisko: {lastName} zostalo wpisane")
    public PimPanelSteps setLastNameLabel(String lastName) {
        lastNameLabel.sendKeys(lastName);
        logger.log(Level.INFO, "Nazwisko pracownika: {0} zostalo wpisane", lastName);
        return new PimPanelSteps();
    }

    @Step("Checkbox: 'Create Login Details' zostal zaznaczony")
    public PimPanelSteps clickLoginDetailsCheckBox() {
        loginDetailsCheckBox.click();
        logger.log(Level.INFO, "Checkbox: \"Create Login Details\" zostal zaznaczony");
        return new PimPanelSteps();
    }

    @Step("Login pracownika: {username} zostal wpisany")
    public PimPanelSteps setUsernameLabel(String username) {
        RepeatedActions.deletingAndAddingContentToLabel(usernameLabel, username);
        logger.log(Level.INFO, "Login pracownika: {0} zostal wpisany", username);
        return new PimPanelSteps();
    }

    @Step("Radio button: 'Status - Enabled' zostal zaznaczony")
    public PimPanelSteps clickStatusEnabledRadioButton() {
        statusEnabledRadioButton.click();
        logger.log(Level.INFO, "Radio button: \"Status - Enabled\" zostal zaznaczony");
        return new PimPanelSteps();
    }

    @Step("Haslo pracownika: {password} zostalo wpisane")
    public PimPanelSteps setPasswordLabel(String password) {
        RepeatedActions.deletingAndAddingContentToLabel(passwordLabel, password);
        logger.log(Level.INFO, "Haslo pracownika: {0} zostalo wpisane", password);
        return new PimPanelSteps();
    }

    @Step("Potwierdzenie hasla: {confirmPassword} zostalo wpisane")
    public PimPanelSteps setConfirmPasswordLabel(String confirmPassword) {
        RepeatedActions.deletingAndAddingContentToLabel(confirmPasswordLabel, confirmPassword);
        logger.log(Level.INFO, "Haslo pracownika zostalo wpisane ponownie: {0}", confirmPassword);
        return new PimPanelSteps();
    }

    @Step("Popup 'Success' zostal wyswietlony")
    public boolean isSuccessPopupDisplayed() {
        logger.log(Level.INFO, "Popup \"Success\" zostal wyswietlony");
        return successPopup.isDisplayed();
    }

    @Step("Wcisniecie przycisku 'reports'")
    public PimPanelSteps clickReportButton() {
        reportsButton.click();
        logger.log(Level.INFO, "Wcisniecie przycisku \"reports\"");
        return new PimPanelSteps();
    }

    @Step("Wpisanie nazwy raportu")
    public PimPanelSteps generateReportName(String reportName) {
        reportNameLabel.click();
        logger.log(Level.INFO, "Wcisniecie pola \"nazwa raportu\": {0}", reportName);
        reportNameLabel.sendKeys(UserDataGenerator.generateReportName(reportName));
        logger.log(Level.INFO, "Wygenerowanie raportu o nazwie: {0} oraz wpisanie w polu report name", reportName);
        return new PimPanelSteps();
    }

    @Step("Wcisniecie listy select: 'Selection Criteria'")
    public PimPanelSteps setSelectionCriteria() {
        selectionCriteriaSelect.click();
        logger.log(Level.INFO, "Wcisniecie listy select: \"Criteria Criteria\"");
        return new PimPanelSteps();
    }

    @Step("Wybranie kryterium raportu {criteria}")
    public PimPanelSteps pickSelectionCriteria(String criteria) {
        String selector = "//span[normalize-space()='";
        selector = selector + criteria + "']";
        WebElement selectionCriteriaWebElement = DriverPicker.driverSetup().findElement(By.xpath(selector));
        selectionCriteriaWebElement.click();
        logger.log(Level.INFO, "Wybranie kryterium raportu: {0}", criteria);
        return new PimPanelSteps();
    }

    @Step("Wcisniecie przycisku plus dla 'kryterii'")
    public PimPanelSteps clickPlusButtonForCriteria() {
        criteriaButton.click();
        logger.log(Level.INFO, "Wcisniecie przycisku 'plus' dla kryterii");
        return new PimPanelSteps();
    }

    @Step("Wcisniecie przycisku plus dla wyswietlonego pola")
    public PimPanelSteps clickPlusButtonForDisplayFields() {
        displayFieldsButton.click();
        logger.log(Level.INFO, "Wcisniecie przycisku 'plus' dla wyswietlonego pola");
        return new PimPanelSteps();
    }

    @Step("Wcisniecie listy select dla typu edukacji")
    public PimPanelSteps clickEducationTypeSelect() {
        educationTypeSelect.click();
        logger.log(Level.INFO, "Wybranie opcji: 'Education'");
        return new PimPanelSteps();
    }

    @Step("Wybranie stopnia naukowego: {educationDegree}")
    public PimPanelSteps selectEducationDegree(String degree) {
        String degreeSelector = "//span[contains(text(),\"" + degree + "\")]";
        WebElement degreeLabel = DriverPicker.driverSetup().findElement(By.xpath(degreeSelector));
        logger.log(Level.INFO, "Wybranie stopnia naukowego: {0} ", degree);
        degreeLabel.click();
        logger.log(Level.INFO, "Wcisniecie stopnia naukowego: {0} ", degree);
        return new PimPanelSteps();
    }

    @Step("Wybranie z listy select typu pol ktore zostana wyswietlone")
    public PimPanelSteps clickDisplayFieldsLabel() {
        displayedFieldGroupSelect.click();
        logger.log(Level.INFO, "Wcisniecie listy select: 'Display fields'");
        return new PimPanelSteps();
    }

    @Step("Wybranie danych ktore maja zostac wyswietlone w raporcie")
    public PimPanelSteps selectPersonalDataGroup(String fieldGroup) {
        String fieldGroupSelector = "//span[contains(text(),'" + fieldGroup + "')]";
        WebElement fieldGroupSelect = DriverPicker.driverSetup().findElement(By.xpath(fieldGroupSelector));
        logger.log(Level.INFO, "Wybranie danych ktore maja zostac wyswietlone: {0} ", fieldGroup);
        fieldGroupSelect.click();
        logger.log(Level.INFO, "Wcisniecie listy select: {0} ", fieldGroup);
        return new PimPanelSteps();
    }

    @Step("Wybranie pola ktore zostanie wyswietlone")
    public PimPanelSteps clickDisplayField() {
        displayFieldSelect.click();
        logger.log(Level.INFO, "Wybranie pola ktore zostanie wyswietlone");
        return new PimPanelSteps();
    }
}
