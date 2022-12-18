package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;

import static org.testng.Assert.assertTrue;


public class DashboardTests extends TestBase {

    private LoginPageSteps loginPageSteps;

    @BeforeSuite
    public void setUpDashboardTests() {
        loginPageSteps = new LoginPageSteps();
    }

    @Test
    public void loginWithExistingUserTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isHrmLogoAfterLoginDisplayed());
    }

    @Test
    public void checkThatTimeAtWorkSectionIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isTimeAtWorkSectionPresent());
    }

    @Test
    public void checkThatMyActionsSectionIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isMyActionsSectionDisplayed());
    }

    @Test
    public void checkThatQuickLaunchSectionIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isQuickLaunchSectionDisplayed());
    }

    @Test
    public void checkThatEmployeesOnLeaveTodaySectionIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isEmployeesOnLeaveSectionDisplayed());
    }

    @Test
    public void checkThatEmployeeDistributionBySubUnitTodaySectionIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isEmployeeDistributionBySubUnitLeaveSectionDisplayed());
    }

    @Test
    public void checkThatEmployeeDistributionByLocationTodaySectionIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isEmployeeDistributionByLocationSectionDisplayed());
    }
}
