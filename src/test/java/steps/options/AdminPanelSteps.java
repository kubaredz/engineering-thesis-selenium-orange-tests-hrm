package steps.options;

import builders.AdminPanelBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

public class AdminPanelSteps extends AdminPanelBuilder {

    public AdminPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public void clickAdminPanelSection() {
        adminPanelSection.click();
    }

    public boolean isUserManagementSectionDisplayed() {
        return userManagementSection.isDisplayed();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public boolean isAddUserTextDisplayed() {
        return addUserText.isDisplayed();
    }

    public void clickUserRoleDropdown() {
        userRoleDropdown.click();
    }

    public void setEmployeeNameLabel(String employeeName) {
        employeeNameLabel.sendKeys(employeeName);
    }

    public void clickStatusDropdown() {
        statusDropdown.click();
    }
}
