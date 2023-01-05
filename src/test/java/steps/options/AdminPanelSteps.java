package steps.options;

import builders.options.AdminPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;
import utils.RepeatedActions;

import java.util.logging.Level;

import static waits.Wait.waitTillElementIsClickableByWebElement;
import static waits.Wait.waitTillElementIsPresent;
import static waits.Wait.waitSleep;

public class AdminPanelSteps extends AdminPanelBuilder implements DefaultSteps, CommonSteps {

    public AdminPanelSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Override
    @Step("Sekcja: 'User Management' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"User Management\" zostala wyswietlona");
        return headerTextAddition.isDisplayed();
    }

    @Override
    @Step("Przycisk dla panelu: 'Admin' zostal wcisniety")
    public AdminPanelSteps clickPanelSection() {
        adminPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Admin\" zostal wcisniety");
        return new AdminPanelSteps();
    }

    @Override
    @Step("Przycisk: 'Add' zostal wcisniety")
    public AdminPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" zostal wcisniety");
        return new AdminPanelSteps();
    }

    @Override
    @Step("Przycisk: 'Save' zostal wcisniety")
    public AdminPanelSteps clickSaveButton() {
        waitSleep();
        Actions action = new Actions(DriverPicker.driverSetup());
        action.moveToElement(saveButton).doubleClick().build().perform();
        logger.log(Level.INFO, "Wciskam przycisk: \"Save\"");
        return new AdminPanelSteps();
    }

    @Step("Tekst: 'Add user' zostal wyswietlony")
    public boolean isAddUserTextDisplayed() {
        waitTillElementIsPresent(addText);
        logger.log(Level.INFO, "Tekst \"Add user\" zostal wyswietlony");
        return addText.isDisplayed();
    }

    @Step("Dropdown: 'User Role' zostal wcisniety")
    public AdminPanelSteps clickUserRoleDropdown() {
        userRoleDropdown.click();
        logger.log(Level.INFO, "Dropdown: \"User Role\" zostal wcisniety");
        return new AdminPanelSteps();
    }

    @Step("Rola 'Admin' zostala wybrana")
    public AdminPanelSteps clickAdminUserRoleButton() {
        adminUserRole.click();
        logger.log(Level.INFO, "Wybranie roli: \"Admin\"");
        return new AdminPanelSteps();
    }

    @Step("Rola 'Ess' zostala wybrana")
    public AdminPanelSteps clickEssUserRoleButton() {
        waitTillElementIsClickableByWebElement(essUserRole);
        essUserRole.click();
        logger.log(Level.INFO, "Wybranie roli: \"Ess\"");
        return new AdminPanelSteps();
    }

    @Step("Imie pracownika: {employeeName} zostalo wpisane")
    public AdminPanelSteps setEmployeeNameLabel(String employeeName) {
        RepeatedActions.deletingAndAddingContentToLabel(employeeNameLabel, employeeName);
        logger.log(Level.INFO, "Wprowadzam imie pracownika: {0}", employeeName);
        return new AdminPanelSteps();
    }

    @Step("Imie pracownika: zostalo wybrane z listy")
    public AdminPanelSteps clickEmployeeNameFromList() {
        employeeNameFromList.click();
        logger.log(Level.INFO, "Imie pracownika: zostalo wybrane z listy");
        return new AdminPanelSteps();
    }

    @Step("Haslo pracownika: {password} zostalo wpisane")
    public AdminPanelSteps setEmployeePasswordLabel(String password) {
        RepeatedActions.deletingAndAddingContentToLabel(passwordLabel, password);
        logger.log(Level.INFO, "Wprowadzam haslo pracownika: {0}", password);
        return new AdminPanelSteps();
    }

    @Step("Potwierdzenie hasla: {confirmPassword} zostalo wpisane")
    public AdminPanelSteps setRepeatedPasswordLabel(String repeatedPassword) {
        RepeatedActions.deletingAndAddingContentToLabel(confirmPasswordLabel, repeatedPassword);
        logger.log(Level.INFO, "Wprowadzam potwierdzenie hasla pracownika: {0}", repeatedPassword);
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
        logger.log(Level.INFO, "Status: \"Enabled\" zostal wybrany");
        return new AdminPanelSteps();
    }

    @Step("Status: 'Enabled' zostal wybrany")
    public AdminPanelSteps clickDisabledStatus() {
        statusDisabled.click();
        logger.log(Level.INFO, "Status: \"Disabled\" zostal wybrany");
        return new AdminPanelSteps();
    }

    @Step("Nazwa uzytkownika: {username} zostala wpisana")
    public AdminPanelSteps setUsernameLabel(String username) {
        RepeatedActions.deletingAndAddingContentToLabel(usernameLabel, username);
        logger.log(Level.INFO, "Nazwa uzytkownika to: \"{0}\"", username);
        return new AdminPanelSteps();
    }

    @Step("Alert: 'Positive Alert' zostal wyswietlony")
    public boolean isPositiveAlertDisplayed() {
        positiveAlert.isDisplayed();
        logger.log(Level.INFO, "Alert: \"Positive\" zostal wyswietlony");
        return positiveAlert.isDisplayed();

    }

    @Step("Text: 'System Users' zostal wyswietlony")
    public boolean isSystemUsersTextDisplayed() {
        logger.log(Level.INFO, "Tekst: \"System Users\" zostal wyswietlony");
        return systemUsersText.isDisplayed();
    }

    @Step("Wybranie roli dla nowego uzytkownika")
    public AdminPanelSteps chooseUserRole(String role) {
        if (role.equals("Admin")) {
            clickAdminUserRoleButton();
        }
        if (role.equals("ESS")) {
            clickEssUserRoleButton();
        }
        return new AdminPanelSteps();
    }

    @Step("Wybranie statusu dla nowego uzytkownika")
    public AdminPanelSteps choseStatus(String status) {
        if (status.equals("Enabled")) {
            clickEnabledStatus();
        }
        if (status.equals("Disabled")) {
            clickDisabledStatus();
        }
        return new AdminPanelSteps();
    }
}
