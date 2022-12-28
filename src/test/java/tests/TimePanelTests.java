package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.TimePanelSteps;

import static org.testng.Assert.assertTrue;

public class TimePanelTests extends TestBase {
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
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'Time' przekierowuje do strony 'Timesheets' z lista obecnosci")
    @Severity(SeverityLevel.NORMAL)
    public void asAdminUserTimesheetScreenIsPresentTest() {
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        timePanelSteps.clickPanelSection();

        assertTrue(timePanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja dodania nowego timesheetu zalogowanemu uzytkownikowi")
    @Severity(SeverityLevel.NORMAL)
    public void asAdminCreateNewTimesheetTest() {
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        String loggedUserData = headerSteps.getLoggedUser();

        timePanelSteps
                .clickPanelSection()
                .setEmployeeName(loggedUserData)
                .pickPromptedEmployeeName()
                .clickViewButton();

        assertTrue(timePanelSteps.isTimeSectionDisplayed());
        assertTrue(timePanelSteps.isAlertInfoDisplayed());
    }
}
