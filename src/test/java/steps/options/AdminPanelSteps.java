package steps.options;

import builders.options.AdminPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;
import utils.RepeatedActions;
import waits.Wait;

import java.util.logging.Level;

public class AdminPanelSteps extends AdminPanelBuilder implements CommonSteps, CommonGenericSteps<AdminPanelSteps> {

    public AdminPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Override
    @Step("Sekcja: 'User Management' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"User Management\" została wyświetlona");
        return headerTextAddition.isDisplayed();
    }

    @Override
    @Step("Przycisk dla panelu: 'Admin' zostal wcisniety")
    public <T> AdminPanelSteps clickPimPanelSection() {
        adminPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Admin\" został wciśnięty");
        return new AdminPanelSteps();
    }

    @Override
    @Step("Przycisk: 'Add' zostal wcisniety")
    public AdminPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
        return new AdminPanelSteps();
    }

    @Override
    @Step("Przycisk: 'Save' zostal wcisniety")
    public AdminPanelSteps clickSaveButton() {
        Wait.waitSleep();
        Actions action = new Actions(DriverManager.driverSetup());
        action.moveToElement(saveButton).doubleClick().build().perform();
        logger.log(Level.INFO, "Wciskam przycisk: \"Save\"");
        return new AdminPanelSteps();
    }

    @Step("Tekst: 'Add user' zostal wyswietlony")
    public boolean isAddUserTextDisplayed() {
        logger.log(Level.INFO, "Tekst \"Add user\" został wyświetlony");
        return addText.isDisplayed();
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
        RepeatedActions.deletingAndAddingContentToLabel(employeeNameLabel, employeeName);
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
        RepeatedActions.deletingAndAddingContentToLabel(passwordLabel, password);
        logger.log(Level.INFO, "Wprowadzam hasło pracownika: {0}", password);
        return new AdminPanelSteps();
    }

    @Step("Potwierdzenie hasla: {confirmPassword} zostalo wpisane")
    public AdminPanelSteps setEmployeeConfirmPasswordLabel(String confirmPassword) {
        RepeatedActions.deletingAndAddingContentToLabel(confirmPasswordLabel, confirmPassword);
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
        RepeatedActions.deletingAndAddingContentToLabel(usernameLabel, username);
        logger.log(Level.INFO, "Nazwa użytkownika to: \"{0}\"", username);
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
