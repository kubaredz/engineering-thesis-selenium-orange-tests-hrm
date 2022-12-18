package steps.dashboard;

import builders.DashboardPageBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

public class DashboardSteps extends DashboardPageBuilder {

    public DashboardSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }


    public boolean isHrmLogoAfterLoginDisplayed() {
        return hrmLogoAfterLogin.isDisplayed();
    }

    public boolean isTimeAtWorkSectionPresent() {
        return timeAtWorkSection.isDisplayed();
    }

    public boolean isMyActionsSectionDisplayed() {
        return myActionsSection.isDisplayed();
    }

    public boolean isQuickLaunchSectionDisplayed() {
        return quickLaunchSection.isDisplayed();
    }

    public boolean isEmployeesOnLeaveSectionDisplayed() {
        return employeesOnLeaveSection.isDisplayed();
    }

    public boolean isEmployeeDistributionBySubUnitLeaveSectionDisplayed() {
        return employeeDistributionBySubUnitLeaveSection.isDisplayed();
    }

    public boolean isEmployeeDistributionByLocationSectionDisplayed() {
        return employeeDistributionByLocationSection.isDisplayed();
    }
}
