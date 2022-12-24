package steps.dashboard;

import builders.DashboardPageBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class DashboardSteps extends DashboardPageBuilder {

    public DashboardSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Step("Logo strony Orange HRM zostalo wyswietlone")
    public boolean isHrmLogoAfterLoginDisplayed() {
        logger.log(Level.INFO, "Logo: \"OrangeHRM\" po zalogowaniu zostało wyświetlone");
        return hrmLogoAfterLogin.isDisplayed();
    }

    @Step("Sekcja: 'Time at Work' zostala wyswietlona")
    public boolean isTimeAtWorkSectionPresent() {
        logger.log(Level.INFO, "Sekcja: \"Time at Work\" została wyświetlona");
        return timeAtWorkSection.isDisplayed();
    }

    @Step("Sekcja: 'My Actions' zostala wyswietlona")
    public boolean isMyActionsSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"My Actions\" została wyświetlona");
        return myActionsSection.isDisplayed();
    }

    @Step("Sekcja: 'Quick Launch' zostala wyswietlona")
    public boolean isQuickLaunchSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Quick Launch\" została wyświetlona");
        return quickLaunchSection.isDisplayed();
    }

    @Step("Sekcja: 'Employees On Leave' zostala wyswietlona")
    public boolean isEmployeesOnLeaveSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Employees On Leave\" została wyświetlona");
        return employeesOnLeaveSection.isDisplayed();
    }

    @Step("Sekcja: 'Employee Distribution By Sub Unit Leave' zostala wyswietlona")
    public boolean isEmployeeDistributionBySubUnitLeaveSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Employee Distribution By Sub Unit Leave\" została wyświetlona");
        return employeeDistributionBySubUnitLeaveSection.isDisplayed();
    }

    @Step("Sekcja: 'Employee Distribution By Location' zostala wyswietlona")
    public boolean isEmployeeDistributionByLocationSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Employee Distribution By Location\" została wyświetlona");
        return employeeDistributionByLocationSection.isDisplayed();
    }
}
