package steps.options;

import builders.options.PimPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;
import utils.RepeatedActions;

import java.util.logging.Level;

public class PimPanelSteps extends PimPanelBuilder implements DefaultSteps, CommonGenericSteps<PimPanelSteps> {

    public PimPanelSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'PIM' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"PIM\" została wyświetlona");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'PIM' zostala otwarta")
    public <T> PimPanelSteps clickPimPanelSection() {
        pimPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"PIM\" został wciśnięty");
        return new PimPanelSteps();
    }

    @Override
    @Step("Przycisk: 'Add' zostal wcisniety")
    public PimPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
        return new PimPanelSteps();
    }

    @Override
    @Step("Przycisk 'save' zostal nacisniety")
    public PimPanelSteps clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Wciskam przycisk: \"Save\"");
        return new PimPanelSteps();
    }

    @Step("Tekst: 'Add employee' zostal wyswietlony")
    public boolean isAddEmployeeTextDisplayed() {
        logger.log(Level.INFO, "Tekst \"Add employee\" został wyświetlony");
        return addText.isDisplayed();
    }

    @Step("Tekst: 'Add employee' zostal pobrany")
    public String getAddEmployeeText() {
        logger.log(Level.INFO, "Tekst: \"Add Employee\" został pobrany");
        return addText.getText();
    }

    @Step("Lokalizacja zdjecia: {imgPath} zostala przekazana")
    public PimPanelSteps setUploadImageButton(String imgPath) {
        uploadImageButton.sendKeys(imgPath);
        logger.log(Level.INFO, "Lokalizacja zdjęcia: {0} została przekazana", imgPath);
        return new PimPanelSteps();
    }

    @Step("Imie pracownika: {firstName} zostalo wpisane")
    public PimPanelSteps setFirstNameLabel(String firstName) {
        firstNameLabel.sendKeys(firstName);
        logger.log(Level.INFO, "Wprowadzam imię pracownika: {0}", firstName);
        return new PimPanelSteps();
    }

    @Step("Drugie imie: {middleName} zostalo wpisane")
    public PimPanelSteps setMiddleNameLabel(String middleName) {
        middleNameLabel.sendKeys(middleName);
        logger.log(Level.INFO, "Wprowadzam drugię imię pracownika: {0}", middleName);
        return new PimPanelSteps();
    }

    @Step("Nazwisko: {lastName} zostala przekazana")
    public PimPanelSteps setLastNameLabel(String lastName) {
        lastNameLabel.sendKeys(lastName);
        logger.log(Level.INFO, "Wprowadzam nazwisko pracownika: {0}", lastName);
        return new PimPanelSteps();
    }

    @Step("Checkbox: 'Create Login Details' zostal zaznaczony")
    public PimPanelSteps clickLoginDetailsCheckBox() {
        loginDetailsCheckBox.click();
        logger.log(Level.INFO, "Checkbox: \"Create Login Details\" został zaznaczony");
        return new PimPanelSteps();
    }

    @Step("Login pracownika: {username} zostal wpisany")
    public PimPanelSteps setUsernameLabel(String username) {
        RepeatedActions.deletingAndAddingContentToLabel(usernameLabel, username);
        logger.log(Level.INFO, "Wprowadzam login pracownika: {0}", username);
        return new PimPanelSteps();
    }

    @Step("Radio button: 'Status - Enabled' zostal zaznaczony")
    public PimPanelSteps clickStatusEnabledRadioButton() {
        statusEnabledRadioButton.click();
        logger.log(Level.INFO, "Radio button: \"Status - Enabled\" został zaznaczony");
        return new PimPanelSteps();
    }

    @Step("Haslo pracownika: {password} zostalo wpisane")
    public PimPanelSteps setPasswordLabel(String password) {
        RepeatedActions.deletingAndAddingContentToLabel(passwordLabel, password);
        logger.log(Level.INFO, "Wprowadzam hasło pracownika: {0}", password);
        return new PimPanelSteps();
    }

    @Step("Potwierdzenie hasla: {confirmPassword} zostalo wpisane")
    public PimPanelSteps setConfirmPasswordLabel(String confirmPassword) {
        RepeatedActions.deletingAndAddingContentToLabel(confirmPasswordLabel, confirmPassword);
        logger.log(Level.INFO, "Wprowadzam hasło ponownie: {0}", confirmPassword);
        return new PimPanelSteps();
    }

    @Step("Popup 'Success' zostal wyswietlony")
    public boolean isSuccessPopupDisplayed() {
        logger.log(Level.INFO, "Popup \"Success\" został wyświetlony");
        return successPopup.isDisplayed();
    }

    @Step("Wcisniecie przycisku 'reports'")
    public PimPanelSteps clickReportsButton() {
        logger.log(Level.INFO, "Wcisniecie przycisku \"reports\"");
        reportsButton.click();
        return new PimPanelSteps();
    }

    @Step("Wpisanie report name")
    public PimPanelSteps setReportName(String reportName) {
        reportNameLabel.click();
        logger.log(Level.INFO, "Wcisniecie pola nazwy raportu: {0}", reportName);
        reportNameLabel.sendKeys(reportName);
        logger.log(Level.INFO, "Dodanie nazwy raportu: {0}", reportName);
        return new PimPanelSteps();
    }

    @Step("Wcisniecie selecta: 'Selection Criteria'")
    public PimPanelSteps setSelectionCriteria() {
        selectionCriteriaSelect.click();
        logger.log(Level.INFO, "Wcisniecie selecta criteria");
        return new PimPanelSteps();
    }

    @Step("Wybranie kryterium raportu {criteria}")
    public PimPanelSteps pickSelectionCriteria(String criteria) {
        String selector = "//span[normalize-space()='";
        selector = selector + criteria + "']";
        WebElement element = DriverPicker.driverSetup().findElement(By.xpath(selector));
        element.click();
        logger.log(Level.INFO, "Wybranie kryterium raportu: {0}", criteria);
        return new PimPanelSteps();
    }

    @Step("Wcisniecie przycisku plus dla kryterii")
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

    @Step("Wcisniecie selecta dla typu edukacji")
    public PimPanelSteps clickEducationTypeSelect() {
        educationTypeSelect.click();
        logger.log(Level.INFO, "Wcisniecie selecta 'education'");
        return new PimPanelSteps();
    }

    @Step("Wybranie stopnia naukowego {educationDegree}")
    public PimPanelSteps selectEducationDegree(String degree) {
        String degreeSelector = "//span[contains(text(),\"" + degree + "\")]";
        WebElement degreeLabel = DriverPicker.driverSetup().findElement(By.xpath(degreeSelector));
        logger.log(Level.INFO, "Wybranie rodzaju stopnia naukowego: {0} ", degree);
        degreeLabel.click();
        logger.log(Level.INFO, "Wcisniecie stopnia naukowego: {0} ", degree);
        return new PimPanelSteps();
    }

    @Step("Wybranie z selecta typu pol ktore zostana wyswietlone")
    public PimPanelSteps clickDisplayFieldsLabel() {
        displayedFieldGroupSelect.click();
        logger.log(Level.INFO, "Wcisniecie selecta 'display fields'");
        return new PimPanelSteps();
    }

    @Step("Wybranie danych ktore maja zostac wyswietlone")
    public PimPanelSteps selectPersonalDataGroup(String fieldGroup) {
        String fieldGroupSelector = "//span[contains(text(),'" + fieldGroup + "')]";
        WebElement fieldGroupSelect = DriverPicker.driverSetup().findElement(By.xpath(fieldGroupSelector));
        logger.log(Level.INFO, "Wybranie danych ktore maja zostac wyswietlone: {0} ", fieldGroup);
        fieldGroupSelect.click();
        logger.log(Level.INFO, "Wcisniecie selecta: {0} ", fieldGroup);
        return new PimPanelSteps();
    }

    @Step("Wybranie pola ktore zostanie wyswietlone")
    public PimPanelSteps clickDisplayField() {
        displayFieldSelect.click();
        logger.log(Level.INFO, "Wybranie pola ktore zostanie wyswietlone");
        return new PimPanelSteps();
    }

    @Step("Wybranie danych ktore maja zostac wyswietlone")
    public PimPanelSteps selectDisplayField(String displayField) {
        String fieldGroupSelector = "//span[contains(text(),'" + displayField + "')]";
        WebElement displayFieldLabel = DriverPicker.driverSetup().findElement(By.xpath(fieldGroupSelector));
        logger.log(Level.INFO, "Wybranie danych ktore maja zostac wyswietlone: {0} ", displayField);
        displayFieldLabel.click();
        logger.log(Level.INFO, "Wcisniecie selecta: {0} ", displayField);
        return new PimPanelSteps();
    }
}
