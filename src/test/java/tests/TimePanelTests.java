package tests;

import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.TimePanelSteps;

import static org.testng.Assert.assertTrue;

public class TimePanelTests extends TestBase {

    @Test
    public void asAdminUserTimesheetScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.clickTimePanelSection();

        assertTrue(timePanelSteps.isTimesheetSectionDisplayed());
    }

    @Test
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
