package steps.dashboard;

import builders.DashboardPageBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

public class DashboardSteps extends DashboardPageBuilder {

    public DashboardSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public WebElement getHrmLogoAfterLogin() {
        return hrmLogoAfterLogin;
    }

    public WebElement getTimeAtWorkSection() {
        return timeAtWorkSection;
    }

    public WebElement getMyActionsSection() {
        return myActionsSection;
    }

    public WebElement getQuickLaunchSection() {
        return quickLaunchSection;
    }

    public WebElement getEmployeesOnLeaveSection() {
        return employeesOnLeaveSection;
    }

    public WebElement getEmployeeDistributionBySubUnitLeaveSection() {
        return employeeDistributionBySubUnitLeaveSection;
    }

    public WebElement getEmployeeDistributionByLocationSection() {
        return employeeDistributionByLocationSection;
    }
}
