package tests;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;

import static org.testng.Assert.assertTrue;

public class DashboardTests extends TestNgSteps {
    private LoginPageSteps loginPageSteps;
    private DashboardSteps dashboardSteps;

    @BeforeMethod
    public void dashboardTestsSetup() {
        loginPageSteps = new LoginPageSteps();
        dashboardSteps = new DashboardSteps();
    }

    @Test
    @Story("PI-33")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-33")
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Time at Work' jest widoczny")
    @Parameters({"Admin", "admin123"})
    public void checkThatTimeAtWorkSectionIsPresentTest(String login, String password) {
        loginPageSteps
                .setUserNameField(login)
                .setPasswordField(password)
                .clickLoginButton();

        assertTrue(dashboardSteps.isTimeAtWorkSectionPresent());
    }

    @Test
    @Story("PI-33")
    @Severity(SeverityLevel.TRIVIAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-33")
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'My Actions' jest widoczna")
    public void checkThatMyActionsSectionIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isMyActionsSectionDisplayed());
    }

    @Test
    @Story("PI-33")
    @Severity(SeverityLevel.TRIVIAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-33")
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Quick Launch' jest widoczna")
    public void checkThatQuickLaunchSectionIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isQuickLaunchSectionDisplayed());
    }

    @Test
    @Story("PI-33")
    @Severity(SeverityLevel.TRIVIAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-33")
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Employees On Leave Today' jest widoczna")
    public void checkThatEmployeesOnLeaveTodaySectionIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isEmployeesOnLeaveSectionDisplayed());
    }

    @Test
    @Story("PI-33")
    @Severity(SeverityLevel.TRIVIAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-33")
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Distribution By Sub Unit Today' jest widoczna")
    public void checkThatEmployeeDistributionBySubUnitTodaySectionIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isEmployeeDistributionBySubUnitLeaveSectionDisplayed());
    }

    @Test
    @Story("PI-33")
    @Severity(SeverityLevel.TRIVIAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-33")
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Distribution By Location Today' jest widoczna")
    public void checkThatEmployeeDistributionByLocationTodaySectionIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isEmployeeDistributionByLocationSectionDisplayed());
    }
}