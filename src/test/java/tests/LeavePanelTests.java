package tests;

import helpers.DateGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.LeavePanelSteps;

import static org.testng.Assert.assertTrue;

public class LeavePanelTests extends TestBase {

    @Test
    public void checkThatLeaveListIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        LeavePanelSteps leavePanelSteps = new LeavePanelSteps();
        leavePanelSteps.clickLeavePanelSection();

        assertTrue(leavePanelSteps.isLeaveSectionDisplayed());
    }

    @Test
    public void addVacationLeaveForLoggedEmployee() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        HeaderSteps headerSteps = new HeaderSteps();
        String loggedUserData = headerSteps.getLoggedUser();

        LeavePanelSteps leavePanelSteps = new LeavePanelSteps();
        leavePanelSteps
                .clickLeavePanelSection()
                .clickAssignLeaveButton()
                .setEmployeeName(loggedUserData)
                .pickPromptedEmployee()
                .clickLeaveTypeSection()
                .pickVacationLeave()
                .pickFromDate(DateGenerator.getTodayData())
                .pickToDate()
                .writeComment("Dzień urlopu zaakceptowany przez przełożonego")
                .clickAssignButton();

        Assert.assertTrue(leavePanelSteps.isConfirmLeaveAssignmentPopupDisplayed());
        leavePanelSteps.clickConfirmLeaveAssignmentButton();
    }
}
