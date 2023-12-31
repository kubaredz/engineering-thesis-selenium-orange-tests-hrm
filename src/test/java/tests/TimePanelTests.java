package tests;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.TimePanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TimePanelTests extends TestNgSteps {
    private CommonTests commonTests;
    private TimePanelSteps timePanelSteps;
    private HeaderSteps headerSteps;

    @BeforeMethod
    public void timePanelTestsSetup() {
        commonTests = new CommonTests();
        timePanelSteps = new TimePanelSteps();
        headerSteps = new HeaderSteps();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-43")
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'Time' przekierowuje do strony 'Timesheets' z lista obecnosci")
    @Story("PI-43")
    public void asAdminUserTimesheetScreenIsPresentTest() {
        commonTests
                .loginAsAdministratorToOrangeHrmAppTest("Admin", "admin123");

        timePanelSteps
                .clickPanelSection();

        assertTrue(timePanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Story("PI-43")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-43")
    @Description("Jako zalogowany uzytkownik, weryfikacja czy timesheet dla aktualnie zalogowanego uzytkownika jest widoczny")
    @Parameters({"login", "password"})
    public void asAdminCreateNewTimesheetTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        String loggedUserData = headerSteps.getLoggedUser();

        timePanelSteps
                .clickPanelSection()
                .setEmployeeName(loggedUserData)
                .clickPromptedEmployeeName()
                .clickViewButton();

        assertTrue(timePanelSteps.isTimeSectionDisplayed());
        assertTrue(timePanelSteps.isTimesheetForLoggedUserDisplayed());
        assertEquals(timePanelSteps.getTimesheetSectionText(), "Timesheet for " + loggedUserData);
    }
}