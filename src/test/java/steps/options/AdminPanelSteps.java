package steps.options;

import builders.AdminPanelBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

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

    public void setEmployeeNameLabel(String employeeName) {
        employeeNameLabel.sendKeys(employeeName);
        logger.log(Level.INFO, "Wprowadzam imię pracownika: {0}", employeeName);
    }

    public void clickStatusDropdown() {
        statusDropdown.click();
        logger.log(Level.INFO, "Dropdown: \"status\" został wciśnięty");
    }
}
