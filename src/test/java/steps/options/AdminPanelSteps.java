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

    public void clickAdminPanelSection() {
        adminPanelSection.click();
    }

    public WebElement getUserManagementSection() {
        return userManagementSection;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public void clickAddButton() {
        addButton.click();
    }

    public WebElement getAddUserText() {
        return addUserText;
    }

    public WebElement getUserRoleDropdown() {
        return userRoleDropdown;
    }

    public void clickUserRoleDropdown() {
        userRoleDropdown.click();
    }

    public WebElement getEmployeeNameLabel() {
        return employeeNameLabel;
    }

    public void setEmployeeNameLabel(String employeeName) {
        employeeNameLabel.sendKeys(employeeName);
    }

    public WebElement getStatusDropdown() {
        return statusDropdown;
    }

    public void clickStatusDropdown() {
        statusDropdown.click();
    }
}
