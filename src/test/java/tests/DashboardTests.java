package tests;

import org.testng.annotations.Test;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;
import static org.testng.Assert.assertTrue;


public class DashboardTests extends TestBase {

    @Test
    public void loginWithExistingUser() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.setUserNameField("Admin");

        loginPageSteps.setPasswordField("admin123");

        loginPageSteps.loginButton.click();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.getHrmLogoAfterLogin().isDisplayed());
    }

    @Test
    public void checkThatTimeAtWorkSectionIsPresent() {
        loginWithExistingUser();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.getTimeAtWorkSection().isDisplayed());
    }

    @Test
    public void checkThatMyActionsSectionIsPresent() {
        loginWithExistingUser();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.getMyActionsSection().isDisplayed());
    }

    @Test
    public void checkThatQuickLaunchSectionIsPresent() {
        loginWithExistingUser();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.getQuickLaunchSection().isDisplayed());
    }

    @Test
    public void checkThatEmployeesOnLeaveTodaySectionIsPresent() {
        loginWithExistingUser();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.getEmployeesOnLeaveSection().isDisplayed());
    }

    @Test
    public void checkThatEmployeeDistributionBySubUnitTodaySectionIsPresent() {
        loginWithExistingUser();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.getEmployeeDistributionBySubUnitLeaveSection().isDisplayed());
    }

    @Test
    public void checkThatEmployeeDistributionByLocationTodaySectionIsPresent() {
        loginWithExistingUser();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.getEmployeeDistributionByLocationSection().isDisplayed());
    }
}
