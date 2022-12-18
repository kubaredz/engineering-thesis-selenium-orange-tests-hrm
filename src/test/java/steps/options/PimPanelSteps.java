package steps.options;

import builders.PimPanelBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class PimPanelSteps extends PimPanelBuilder {

    public PimPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public PimPanelSteps clickPimPanelSection() {
        pimPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"PIM\" został wciśnięty");
        return new PimPanelSteps();
    }

    public boolean isPimSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"PIM\" została wyświetlona");
        return pimSection.isDisplayed();
    }

    public PimPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
        return new PimPanelSteps();
    }

    public boolean isAddEmployeeTextDisplayed() {
        logger.log(Level.INFO, "Tekst \"Add employee\" został wyświetlony");
        return addEmployeeText.isDisplayed();
    }

    public String getAddEmployeeText() {
        logger.log(Level.INFO, "Tekst: \"Add Employee\" został wyświetlony");
        return addEmployeeText.getText();
    }

    public PimPanelSteps setFirstNameLabel(String firstName) {
        firstNameLabel.sendKeys(firstName);
        logger.log(Level.INFO, "Wprowadzam imię pracownika: {0}", firstName);
        return new PimPanelSteps();
    }


    public WebElement getUploadImageButton() {
        logger.log(Level.INFO, "Przycisk: \"Add image\" został wyświetlony");
        return uploadImageButton;
    }

    public PimPanelSteps setUploadImageButton(String imgPath) {
        uploadImageButton.sendKeys(imgPath);
        logger.log(Level.INFO, "Lokalizacja zdjęcia: {0} została przekazana", imgPath);
        return new PimPanelSteps();
    }


    public PimPanelSteps setMiddleNameLabel(String middleName) {
        middleNameLabel.sendKeys(middleName);
        logger.log(Level.INFO, "Wprowadzam drugię imię pracownika: {0}", middleName);
        return new PimPanelSteps();
    }


    public PimPanelSteps setLastNameLabel(String lastName) {
        lastNameLabel.sendKeys(lastName);
        logger.log(Level.INFO, "Wprowadzam nazwisko pracownika: {0}", lastName);
        return new PimPanelSteps();
    }

    public PimPanelSteps clickLoginDetailsCheckBox() {
        loginDetailsCheckBox.click();
        logger.log(Level.INFO, "Checkbox: \"Create Login Details\" został zaznaczony");
        return new PimPanelSteps();
    }


    public PimPanelSteps setUsernameLabel(String username) {
        usernameLabel.sendKeys(username);
        logger.log(Level.INFO, "Wprowadzam login pracownika: {0}", username);
        return new PimPanelSteps();
    }


    public PimPanelSteps clickStatusEnabledRadioButton() {
        statusEnabledRadioButton.click();
        logger.log(Level.INFO, "Radio button: \"Status - Enabled\" został zaznaczony");
        return new PimPanelSteps();
    }


    public PimPanelSteps setPasswordLabel(String password) {
        passwordLabel.sendKeys(password);
        logger.log(Level.INFO, "Wprowadzam hasło pracownika: {0}", password);
        return new PimPanelSteps();
    }


    public PimPanelSteps setConfirmPasswordLabel(String confirmPassword) {
        confirmPasswordLabel.sendKeys(confirmPassword);
        logger.log(Level.INFO, "Wprowadzam hasło ponownie: {0}", confirmPassword);
        return new PimPanelSteps();
    }

    public PimPanelSteps clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Wciskam przycisk: \"Save\"");
        return new PimPanelSteps();
    }

    public boolean isSuccessPopupDisplayed() {
        logger.log(Level.INFO, "Popup \"Success\" został wyświetlony");
        return successPopup.isDisplayed();
    }
}
