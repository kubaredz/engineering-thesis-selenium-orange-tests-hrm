package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;

import static org.testng.Assert.assertTrue;

public class DashboardTests extends TestBase {
    private LoginPageSteps loginPageSteps;
    private DashboardSteps dashboardSteps;

    @BeforeMethod
    public void dashboardTestsSetup() {
        loginPageSteps = new LoginPageSteps();
        dashboardSteps = new DashboardSteps();
    }


    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Time at Work' dziala prawidlowo")
    @Severity(SeverityLevel.CRITICAL)
    @Story("PI-33")
    @Parameters({"Admin", "admin123"})
    public void checkThatTimeAtWorkSectionIsPresentTest(String login, String password) {
        loginPageSteps
                .setUserNameField(login)
                .setPasswordField(password)
                .clickLoginButton();

        assertTrue(dashboardSteps.isTimeAtWorkSectionPresent());
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'My Actions' jest widoczna")
    @Story("PI-33")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkThatMyActionsSectionIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isMyActionsSectionDisplayed());
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Quick Launch' jest widoczna")
    @Story("PI-33")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkThatQuickLaunchSectionIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isQuickLaunchSectionDisplayed());
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Employees On Leave Today' jest widoczna")
    @Story("PI-33")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkThatEmployeesOnLeaveTodaySectionIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isEmployeesOnLeaveSectionDisplayed());
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Distribution By Sub Unit Today' jest widoczna")
    @Story("PI-33")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkThatEmployeeDistributionBySubUnitTodaySectionIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isEmployeeDistributionBySubUnitLeaveSectionDisplayed());
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy sekcja 'Distribution By Location Today' jest widoczna")
    @Story("PI-33")
    @Severity(SeverityLevel.TRIVIAL)
    public void checkThatEmployeeDistributionByLocationTodaySectionIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isEmployeeDistributionByLocationSectionDisplayed());
    }
}
