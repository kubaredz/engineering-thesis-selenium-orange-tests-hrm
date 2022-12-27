package steps.options;

import builders.options.PimPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class PimPanelSteps extends PimPanelBuilder implements CommonSteps, CommonGenericSteps<PimPanelSteps>{

    public PimPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'PIM' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"PIM\" została wyświetlona");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'PIM' zostala otwarta")
    public <T> PimPanelSteps clickPanelSection() {
        pimPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"PIM\" został wciśnięty");
        return new PimPanelSteps();
    }

    @Step("Przycisk: 'Add' zostal wcisniety")
    public PimPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
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
        usernameLabel.sendKeys(username);
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
        passwordLabel.sendKeys(password);
        logger.log(Level.INFO, "Wprowadzam hasło pracownika: {0}", password);
        return new PimPanelSteps();
    }

    @Step("Potwierdzenie hasla: {confirmPassword} zostalo wpisane")
    public PimPanelSteps setConfirmPasswordLabel(String confirmPassword) {
        confirmPasswordLabel.sendKeys(confirmPassword);
        logger.log(Level.INFO, "Wprowadzam hasło ponownie: {0}", confirmPassword);
        return new PimPanelSteps();
    }

    @Step("Przycisk 'save' zostal nacisniety")
    public PimPanelSteps clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Wciskam przycisk: \"Save\"");
        return new PimPanelSteps();
    }

    @Step("Popup 'Success' zostal wyswietlony")
    public boolean isSuccessPopupDisplayed() {
        logger.log(Level.INFO, "Popup \"Success\" został wyświetlony");
        return successPopup.isDisplayed();
    }
}
