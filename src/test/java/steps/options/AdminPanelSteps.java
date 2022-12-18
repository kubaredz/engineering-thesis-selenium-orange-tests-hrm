package steps.options;

import builders.AdminPanelBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class AdminPanelSteps extends AdminPanelBuilder {

    public AdminPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public void clickAdminPanelSection() {
        adminPanelSection.click();
        LOGGER.log(Level.INFO, "Przycisk dla sekcji: \"Admin\" został wciśnięty");
    }

    public boolean isUserManagementSectionDisplayed() {
        LOGGER.log(Level.INFO, "Sekcja: \"User Management\" została wyświetlona");
        return userManagementSection.isDisplayed();
    }

    public void clickAddButton() {
        addButton.click();
        LOGGER.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
    }

    public boolean isAddUserTextDisplayed() {
        LOGGER.log(Level.INFO, "Tekst \"Add user\" został wyświetlony");
        return addUserText.isDisplayed();
    }

    public void clickUserRoleDropdown() {
        userRoleDropdown.click();
        LOGGER.log(Level.INFO, "Dropdown: \"user role\" został wciśnięty");
    }

    public void setEmployeeNameLabel(String employeeName) {
        employeeNameLabel.sendKeys(employeeName);
        LOGGER.log(Level.INFO, "Wprowadzam imię pracownika: {0}", employeeName);
    }

    public void clickStatusDropdown() {
        statusDropdown.click();
        LOGGER.log(Level.INFO, "Dropdown: \"status\" został wciśnięty");
    }
}
