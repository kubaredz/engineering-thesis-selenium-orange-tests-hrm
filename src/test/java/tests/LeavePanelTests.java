package tests;

import helpers.DateGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.LeavePanelSteps;

import static org.testng.Assert.assertTrue;

public class LeavePanelTests extends TestBase {

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Leave' dziala prawidlowo oraz czy sekcja 'Leave' jest widoczna")
    public void checkThatLeaveListIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        LeavePanelSteps leavePanelSteps = new LeavePanelSteps();
        leavePanelSteps.clickPanelSection();

        assertTrue(leavePanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Description("Jako zalogowany administrator, dodanie urlopu dla zalogowanego uzytkownika")
    @Severity(SeverityLevel.CRITICAL)
    public void addVacationLeaveForLoggedEmployee() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        HeaderSteps headerSteps = new HeaderSteps();
        String loggedUserData = headerSteps.getLoggedUser();

        LeavePanelSteps leavePanelSteps = new LeavePanelSteps();
        leavePanelSteps
                .clickPanelSection()
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
