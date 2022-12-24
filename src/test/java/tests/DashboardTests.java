package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;

import static org.testng.Assert.assertTrue;


public class DashboardTests extends TestBase {

    //TODO
//    private LoginPageSteps loginPageSteps;
//
//    @BeforeSuite
//    public void setUpDashboardTests() {
//        loginPageSteps = new LoginPageSteps();
//    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Time at Work' dziala prawidlowo")
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
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'My Actions' jest widoczna")
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
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Quick Launch' jest widoczna")
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
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Employees On Leave Today' jest widoczna")
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
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Distribution By Sub Unit Today' jest widoczna")
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
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Distribution By Location Today' jest widoczna")
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
