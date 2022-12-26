package steps.options;

import builders.AdminPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;
import waits.Wait;

import java.util.logging.Level;

public class AdminPanelSteps extends AdminPanelBuilder {

    public AdminPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Step("Przycisk dla panelu: 'Admin' zostal wcisniety")
    public AdminPanelSteps clickAdminPanelSection() {
        adminPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Admin\" został wciśnięty");
        return new AdminPanelSteps();
    }

    @Step("Sekcja: 'User Management' zostala wyswietlona")
    public boolean isUserManagementSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"User Management\" została wyświetlona");
        return headerTextAddition.isDisplayed();
    }

    @Step("Przycisk: 'Add' zostal wcisniety")
    public AdminPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
        return new AdminPanelSteps();
    }

    @Step("Tekst: 'Add user' zostal wyswietlony")
    public boolean isAddUserTextDisplayed() {
        logger.log(Level.INFO, "Tekst \"Add user\" został wyświetlony");
        return addUserText.isDisplayed();
    }

    @Step("Dropdown: 'User Role' zostal wcisniety")
    public AdminPanelSteps clickUserRoleDropdown() {
        userRoleDropdown.click();
        logger.log(Level.INFO, "Dropdown: \"user role\" został wciśnięty");
        return new AdminPanelSteps();
    }

    @Step("Przycisk: 'User Role' zostal wcisniety")
    public AdminPanelSteps clickAdminUserRoleButton() {
        adminUserRole.click();
        return new AdminPanelSteps();
    }

    @Step("Imie pracownika: {employeeName} zostalo wpisane")
    public AdminPanelSteps setEmployeeNameLabel(String employeeName) {
        employeeNameLabel.sendKeys(employeeName);
        logger.log(Level.INFO, "Wprowadzam imię pracownika: {0}", employeeName);
        return new AdminPanelSteps();
    }

    @Step("Imie pracownika: zostalo wybrane z listy")
    public AdminPanelSteps clickEmployeeNameFromList() {
        employeeNameFromList.click();
        logger.log(Level.INFO, "Dane pracownika zostały wybrane");
        return new AdminPanelSteps();
    }

    @Step("Haslo pracownika: {password} zostalo wpisane")
    public AdminPanelSteps setEmployeePasswordLabel(String password) {
        passwordLabel.sendKeys(password);
        logger.log(Level.INFO, "Wprowadzam hasło pracownika: {0}", password);
        return new AdminPanelSteps();
    }

    @Step("Potwierdzenie hasla: {confirmPassword} zostalo wpisane")
    public AdminPanelSteps setEmployeeConfirmPasswordLabel(String confirmPassword) {
        confirmPasswordLabel.sendKeys(confirmPassword);
        logger.log(Level.INFO, "Wprowadzam potwierdzenie hasła pracownika: {0}", confirmPassword);
        return new AdminPanelSteps();
    }

    @Step("Lista: 'status' zostala wcisnieta")
    public AdminPanelSteps clickStatusList() {
        statusList.click();
        logger.log(Level.INFO, "Lista: \"Status\" ");
        return new AdminPanelSteps();
    }

    @Step("Status: 'Enabled' zostal wybrany")
    public AdminPanelSteps clickEnabledStatus() {
        statusEnabled.click();
        logger.log(Level.INFO, "Status: \"Enabled\" został wybrany");
        return new AdminPanelSteps();
    }

    @Step("Nazwa uzytkownika: {username} zostala wpisana")
    public AdminPanelSteps setUsernameLabel(String username) {
        usernameLabel.sendKeys(username);
        logger.log(Level.INFO, "Nazwa użytkownika to: \"{0}\"", username);
        return new AdminPanelSteps();
    }

    @Step("Przycisk: 'Save' zostal wcisniety")
    public AdminPanelSteps clickSaveButton() {
        Wait.waitSleep();
        Actions action = new Actions(DriverManager.driverSetup());
        action.moveToElement(saveButton).doubleClick().build().perform();
        logger.log(Level.INFO, "Wciskam przycisk: \"Save\"");
        return new AdminPanelSteps();
    }

    @Step("Alert: 'Positive Alert' zostal wyswietlony")
    public boolean isPositiveAlertDisplayed() {
        positiveAlert.isDisplayed();
        logger.log(Level.INFO, "Alert: \"Positive\" został wyświetlony");
        return positiveAlert.isDisplayed();

    }

    @Step("Text: 'System Users' zostal wyswietlony")
    public boolean isSystemUsersTextDisplayed() {
        logger.log(Level.INFO, "Tekst: \"System Users\" został wyświetlony");
        return systemUsersText.isDisplayed();
    }
}
