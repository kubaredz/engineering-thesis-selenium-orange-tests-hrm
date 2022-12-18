package steps.options;

import builders.PimPanelBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

public class PimPanelSteps extends PimPanelBuilder {

    public PimPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public void clickPimPanelSection() {
        pimPanelSection.click();
    }

    public boolean isPimSectionDisplayed() {
        return pimSection.isDisplayed();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public boolean isAddEmployeeTextDisplayed() {
        return addEmployeeText.isDisplayed();
    }

    public String getAddEmployeeText() {
        return addEmployeeText.getText();
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


    public void setMiddleNameLabel(String middleName) {
        middleNameLabel.sendKeys(middleName);
    }


    public void setLastNameLabel(String lastName) {
        lastNameLabel.sendKeys(lastName);
    }

    public void clickLoginDetailsCheckBox() {
        loginDetailsCheckBox.click();
    }


    public void setUsernameLabel(String username) {
        usernameLabel.sendKeys(username);
    }


    public void clickStatusEnabledRadioButton() {
        statusEnabledRadioButton.click();
    }


    public void setPasswordLabel(String password) {
        passwordLabel.sendKeys(password);
    }


    public void setConfirmPasswordLabel(String confirmPassword) {
        confirmPasswordLabel.sendKeys(confirmPassword);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public boolean isSuccessPopupDisplayed() {
        return successPopup.isDisplayed();
    }
}
