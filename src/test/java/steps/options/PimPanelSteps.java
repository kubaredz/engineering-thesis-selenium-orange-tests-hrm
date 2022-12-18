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

    public void clickPimPanelSection() {
        pimPanelSection.click();
        LOGGER.log(Level.INFO, "Przycisk dla sekcji: \"PIM\" został wciśnięty");
    }

    public boolean isPimSectionDisplayed() {
        LOGGER.log(Level.INFO, "Sekcja: \"PIM\" została wyświetlona");
        return pimSection.isDisplayed();
    }

    public void clickAddButton() {
        addButton.click();
        LOGGER.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
    }

    public boolean isAddEmployeeTextDisplayed() {
        LOGGER.log(Level.INFO, "Tekst \"Add employee\" został wyświetlony");
        return addEmployeeText.isDisplayed();
    }

    public String getAddEmployeeText() {
        LOGGER.log(Level.INFO, "Tekst: \"Add Employee\" został wyświetlony");
        return addEmployeeText.getText();
    }

    public void setFirstNameLabel(String firstName) {
        firstNameLabel.sendKeys(firstName);
        LOGGER.log(Level.INFO, "Wprowadzam imię pracownika: {0}", firstName);
    }


    public WebElement getUploadImageButton() {
        LOGGER.log(Level.INFO, "Przycisk: \"Add image\" został wyświetlony");
        return uploadImageButton;
    }

    public void setUploadImageButton(String imgPath) {
        uploadImageButton.sendKeys(imgPath);
        LOGGER.log(Level.INFO, "Lokalizacja zdjęcia: {0} została przekazana", imgPath);
    }


    public void setMiddleNameLabel(String middleName) {
        middleNameLabel.sendKeys(middleName);
        LOGGER.log(Level.INFO, "Wprowadzam drugię imię pracownika: {0}", middleName);

    }


    public void setLastNameLabel(String lastName) {
        lastNameLabel.sendKeys(lastName);
        LOGGER.log(Level.INFO, "Wprowadzam nazwisko pracownika: {0}", lastName);
    }

    public void clickLoginDetailsCheckBox() {
        loginDetailsCheckBox.click();
        LOGGER.log(Level.INFO, "Checkbox: \"Create Login Details\" został zaznaczony");
    }


    public void setUsernameLabel(String username) {
        usernameLabel.sendKeys(username);
        LOGGER.log(Level.INFO, "Wprowadzam login pracownika: {0}", username);
    }


    public void clickStatusEnabledRadioButton() {
        statusEnabledRadioButton.click();
        LOGGER.log(Level.INFO, "Radio button: \"Status - Enabled\" został zaznaczony");
    }


    public void setPasswordLabel(String password) {
        passwordLabel.sendKeys(password);
        LOGGER.log(Level.INFO, "Wprowadzam hasło pracownika: {0}", password);
    }


    public void setConfirmPasswordLabel(String confirmPassword) {
        confirmPasswordLabel.sendKeys(confirmPassword);
        LOGGER.log(Level.INFO, "Wprowadzam hasło ponownie: {0}", confirmPassword);
    }

    public void clickSaveButton() {
        saveButton.click();
        LOGGER.log(Level.INFO, "Wciskam przycisk: \"Save\"");
    }

    public boolean isSuccessPopupDisplayed() {
        LOGGER.log(Level.INFO, "Popup \"Success\" został wyświetlony");
        return successPopup.isDisplayed();
    }
}
