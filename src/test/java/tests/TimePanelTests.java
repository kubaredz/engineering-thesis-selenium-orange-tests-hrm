package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.TimePanelSteps;

import static org.testng.Assert.assertTrue;

public class TimePanelTests extends TestBase {

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'Time' przekierowuje do strony 'Timesheets' z lista obecnosci")
    @Severity(SeverityLevel.NORMAL)
    public void asAdminUserTimesheetScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.clickPanelSection();

        assertTrue(timePanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja dodania nowego timesheetu zalogowanemu uzytkownikowi")
    @Severity(SeverityLevel.NORMAL)
    public void asAdminCreateNewTimesheetTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        HeaderSteps headerSteps = new HeaderSteps();
        String loggedUserData = headerSteps.getLoggedUser();

        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .clickPanelSection()
                .setEmployeeName(loggedUserData)
                .pickPromptedEmployeeName()
                .clickViewButton();

        assertTrue(timePanelSteps.isTimeSectionDisplayed());
        assertTrue(timePanelSteps.isAlertInfoDisplayed());
    }
}
