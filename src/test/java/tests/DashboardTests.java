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
        assertTrue(dashboardSteps.isHrmLogoAfterLoginDisplayed());
    }

    @Test
    public void checkThatTimeAtWorkSectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.isTimeAtWorkSectionPresent());
    }

    @Test
    public void checkThatMyActionsSectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.isMyActionsSectionDisplayed());
    }

    @Test
    public void checkThatQuickLaunchSectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.isQuickLaunchSectionDisplayed());
    }

    @Test
    public void checkThatEmployeesOnLeaveTodaySectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.isEmployeesOnLeaveSectionDisplayed());
    }

    @Test
    public void checkThatEmployeeDistributionBySubUnitTodaySectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.isEmployeeDistributionBySubUnitLeaveSectionDisplayed());
    }

    @Test
    public void checkThatEmployeeDistributionByLocationTodaySectionIsPresentTest() {
        loginWithExistingUserTest();
        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.isEmployeeDistributionByLocationSectionDisplayed());
    }
}
