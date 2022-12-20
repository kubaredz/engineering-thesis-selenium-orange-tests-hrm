package steps.options;

import builders.AdminPanelBuilder;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;
import waits.Wait;

import java.util.logging.Level;

public class AdminPanelSteps extends AdminPanelBuilder {

    public AdminPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public AdminPanelSteps clickAdminPanelSection() {
        adminPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Admin\" został wciśnięty");
        return new AdminPanelSteps();
    }

    public boolean isUserManagementSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"User Management\" została wyświetlona");
        return userManagementSection.isDisplayed();
    }

    public AdminPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
        return new AdminPanelSteps();
    }

    public boolean isAddUserTextDisplayed() {
        logger.log(Level.INFO, "Tekst \"Add user\" został wyświetlony");
        return addUserText.isDisplayed();
    }

    public AdminPanelSteps clickUserRoleDropdown() {
        userRoleDropdown.click();
        logger.log(Level.INFO, "Dropdown: \"user role\" został wciśnięty");
        return new AdminPanelSteps();
    }

    public AdminPanelSteps setAdminUserRole() {
        adminUserRole.click();
        return new AdminPanelSteps();
    }

    public AdminPanelSteps setEmployeeNameLabel(String employeeName) {
        employeeNameLabel.sendKeys(employeeName);
        logger.log(Level.INFO, "Wprowadzam imię pracownika: {0}", employeeName);
        return new AdminPanelSteps();
    }

    public AdminPanelSteps clickEmployeeNameFromList() {
        employeeNameFromList.click();
        logger.log(Level.INFO, "Dane pracownika zostały wybrane");
        return new AdminPanelSteps();
    }

    public AdminPanelSteps setEmployeePasswordLabel(String password) {
        passwordLabel.sendKeys(password);
        logger.log(Level.INFO, "Wprowadzam hasło pracownika: {0}", password);
        return new AdminPanelSteps();
    }

    public AdminPanelSteps setEmployeeConfirmPasswordLabel(String confirmPassword) {
        confirmPasswordLabel.sendKeys(confirmPassword);
        logger.log(Level.INFO, "Wprowadzam potwierdzenie hasła pracownika: {0}", confirmPassword);
        return new AdminPanelSteps();
    }

    public AdminPanelSteps clickStatusList() {
        statusList.click();
        logger.log(Level.INFO, "Lista: \"Status\" ");
        return new AdminPanelSteps();
    }

    public AdminPanelSteps clickEnabledStatus() {
        statusEnabled.click();
        logger.log(Level.INFO, "Status: \"Enabled\" został wybrany");
        return new AdminPanelSteps();
    }

    public AdminPanelSteps setUsernameLabel(String username) {
        usernameLabel.sendKeys(username);
        logger.log(Level.INFO, "Nazwa użytkownika to: \"{0}\"", username);
        return new AdminPanelSteps();
    }

    public AdminPanelSteps clickSaveButton() {
        Wait.waitSleep();
        Actions action = new Actions(DriverManager.driverSetup());
        action.moveToElement(saveButton).doubleClick().build().perform();
        logger.log(Level.INFO, "Wciskam przycisk: \"Save\"");
        return new AdminPanelSteps();
    }

    public boolean isPositiveAlertDisplayed() {
        positiveAlert.isDisplayed();
        logger.log(Level.INFO, "Alert: \"Positive\" został wyświetlony");
        return systemUsersText.isDisplayed();
    }

    public boolean isSystemUsersTextDisplayed() {
        userManagementSection.isDisplayed();
        logger.log(Level.INFO, "Tekst: \"System Users\" został wyświetlony");
        return systemUsersText.isDisplayed();
    }
}
