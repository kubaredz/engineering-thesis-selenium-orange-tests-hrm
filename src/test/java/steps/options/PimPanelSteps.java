package steps.options;

import builders.PimPanelBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

public class PimPanelSteps extends PimPanelBuilder {

    public PimPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public WebElement getPimPanelSection() {
        return pimPanelSection;
    }

    public void clickPimPanelSection() {
        pimPanelSection.click();
    }

    public WebElement getPimSection() {
        return pimSection;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public void clickAddButton() {
        addButton.click();
    }

    public WebElement getAddEmployeeText() {
        return addEmployeeText;
    }


    public WebElement getFirstNameLabel() {
        return firstNameLabel;
    }

    public void setFirstNameLabel(String firstName) {
        firstNameLabel.sendKeys(firstName);
    }


    public WebElement getAddEmployeeButton() {
        return addEmployeeButton;
    }

    public void setAddEmployeeButton(String button) {
        addEmployeeButton.sendKeys(button);
    }


    public WebElement getMiddleNameLabel() {
        return middleNameLabel;
    }

    public void setMiddleNameLabel(String middleName) {
        middleNameLabel.sendKeys(middleName);
    }

    public WebElement getLastNameLabel() {
        return lastNameLabel;
    }

    public void setLastNameLabel(String lastName) {
        lastNameLabel.sendKeys(lastName);
    }

    public WebElement getLoginDetailsCheckBox() {
        return loginDetailsCheckBox;
    }

    public void clickLoginDetailsCheckBox() {
        loginDetailsCheckBox.click();
    }

    public WebElement getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(String username) {
        usernameLabel.sendKeys(username);
    }

    public WebElement getStatusEnabledRadioButton() {
        return statusEnabledRadioButton;
    }

    public void clickStatusEnabledRadioButton() {
        statusEnabledRadioButton.click();
    }

    public WebElement getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(String password) {
        passwordLabel.sendKeys(password);
    }

    public WebElement getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }

    public void setConfirmPasswordLabel(String confirmPassword) {
        confirmPasswordLabel.sendKeys(confirmPassword);
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public WebElement getSuccessPopup() {
        return successPopup;
    }
}
