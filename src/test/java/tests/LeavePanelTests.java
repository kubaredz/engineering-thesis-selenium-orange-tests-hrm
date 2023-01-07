package tests;

import helpers.DateGenerator;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.LeavePanelSteps;

import static org.testng.Assert.assertTrue;

public class LeavePanelTests extends TestNgSteps {
    private CommonTests commonTests;
    private LeavePanelSteps leavePanelSteps;
    private HeaderSteps headerSteps;

    @BeforeMethod
    public void leavePanelTestsSetup() {
        commonTests = new CommonTests();
        leavePanelSteps = new LeavePanelSteps();
        headerSteps = new HeaderSteps();
    }

    @Test
    @Story("PI-36")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-36")
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Leave' dziala prawidlowo oraz czy sekcja 'Leave' jest widoczna")
    @Parameters({"login", "password"})
    public void checkLeaveListIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        leavePanelSteps.clickPanelSection();

        assertTrue(leavePanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Story("PI-36")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-36")
    @Description("Jako zalogowany administrator, dodanie urlopu dla zalogowanego uzytkownika")
    @Parameters({"login", "password"})
    public void checkAddingVacationLeaveForLoggedEmployeeTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        String loggedUserData = headerSteps.getLoggedUser();

        leavePanelSteps
                .clickPanelSection()
                .clickAssignLeaveButton()
                .setEmployeeName(loggedUserData)
                .pickPromptedEmployee()
                .clickLeaveTypeSection()
                .pickVacationLeave()
                .pickFromDate(DateGenerator.getTodayData())
                .pickToDate(DateGenerator.getTodayData())
                .writeComment("Dzien urlopu zaakceptowany przez przelozonego")
                .clickAssignButton();

        assertTrue(leavePanelSteps.isConfirmLeaveAssignmentPopupDisplayed());
        leavePanelSteps.clickConfirmLeaveAssignmentButton();
    }
}