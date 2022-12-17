package tests;

import org.testng.annotations.Test;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;

import static org.testng.Assert.assertTrue;


public class DashboardTests extends TestBase {

    @Test
    public void loginWithExistingUserTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.setUserNameField("Admin");
        loginPageSteps.setPasswordField("admin123");
        loginPageSteps.clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.getHrmLogoAfterLogin().isDisplayed());
    }

    @Test
    public void checkThatTimeAtWorkSectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.getTimeAtWorkSection().isDisplayed());
    }

    @Test
    public void checkThatMyActionsSectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.getMyActionsSection().isDisplayed());
    }

    @Test
    public void checkThatQuickLaunchSectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.getQuickLaunchSection().isDisplayed());
    }

    @Test
    public void checkThatEmployeesOnLeaveTodaySectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.getEmployeesOnLeaveSection().isDisplayed());
    }

    @Test
    public void checkThatEmployeeDistributionBySubUnitTodaySectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.getEmployeeDistributionBySubUnitLeaveSection().isDisplayed());
    }

    @Test
    public void checkThatEmployeeDistributionByLocationTodaySectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.getEmployeeDistributionByLocationSection().isDisplayed());
    }
}
