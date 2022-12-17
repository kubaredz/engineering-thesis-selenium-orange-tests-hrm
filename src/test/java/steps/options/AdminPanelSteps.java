package steps.options;

import builders.AdminPanelBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

public class AdminPanelSteps extends AdminPanelBuilder {

    public AdminPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public WebElement getAdminPanelSection() {
        return adminPanelSection;
    }

    public WebElement getUserManagementSection() {
        return userManagementSection;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getAddUserText() {
        return addUserText;
    }

    public WebElement getUserRoleDropdown() {
        return userRoleDropdown;
    }

    public void setUserRoleDropdown(WebElement userRoleDropdown) {
        this.userRoleDropdown = userRoleDropdown;
    }

    public WebElement getEmployeeNameLabel() {
        return employeeNameLabel;
    }

    public void setEmployeeNameLabel(WebElement employeeNameLabel) {
        this.employeeNameLabel = employeeNameLabel;
    }

    public WebElement getStatusDropdown() {
        return statusDropdown;
    }

    public void setStatusDropdown(WebElement statusDropdown) {
        this.statusDropdown = statusDropdown;
    }
}
