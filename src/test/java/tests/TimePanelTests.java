package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.TimePanelSteps;

import static org.testng.Assert.assertTrue;

public class TimePanelTests extends TestBase {

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'Time' przekierowuje do strony 'Timesheets' z lista obecnosci")
    public void asAdminUserTimesheetScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.clickTimePanelSection();

        assertTrue(timePanelSteps.isTimesheetSectionDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja dodania nowego timesheetu zalogowanemu uzytkownikowi")
    public void asAdminCreateNewTimesheetTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        HeaderSteps headerSteps = new HeaderSteps();
        String loggedUserData = headerSteps.getLoggedUser();

        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .clickTimePanelSection()
                .setEmployeeName(loggedUserData)
                .pickPromptedEmployeeName()
                .clickViewButton();

        assertTrue(timePanelSteps.isTimeSectionDisplayed());
        assertTrue(timePanelSteps.isAlertInfoDisplayed());
    }
}
