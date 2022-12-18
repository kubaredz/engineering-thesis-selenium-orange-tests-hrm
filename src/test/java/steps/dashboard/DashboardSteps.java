package steps.dashboard;

import builders.DashboardPageBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class DashboardSteps extends DashboardPageBuilder {

    public DashboardSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }


    public boolean isHrmLogoAfterLoginDisplayed() {
        logger.log(Level.INFO, "Logo: \"OrangeHRM\" po zalogowaniu zostało wyświetlone");
        return hrmLogoAfterLogin.isDisplayed();
    }

    public boolean isTimeAtWorkSectionPresent() {
        logger.log(Level.INFO, "Sekcja: \"Time at Work\" została wyświetlona");
        return timeAtWorkSection.isDisplayed();
    }

    public boolean isMyActionsSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"My Actions\" została wyświetlona");
        return myActionsSection.isDisplayed();
    }

    public boolean isQuickLaunchSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Quick Launch\" została wyświetlona");
        return quickLaunchSection.isDisplayed();
    }

    public boolean isEmployeesOnLeaveSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Employees On Leave\" została wyświetlona");
        return employeesOnLeaveSection.isDisplayed();
    }

    public boolean isEmployeeDistributionBySubUnitLeaveSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Employee Distribution By Sub Unit Leave\" została wyświetlona");
        return employeeDistributionBySubUnitLeaveSection.isDisplayed();
    }

    public boolean isEmployeeDistributionByLocationSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Employee Distribution By Location\" została wyświetlona");
        return employeeDistributionByLocationSection.isDisplayed();
    }
}
