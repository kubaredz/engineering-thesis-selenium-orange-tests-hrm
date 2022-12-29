package tests;

import helpers.DateGenerator;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.LeavePanelSteps;

import static org.testng.Assert.assertTrue;

public class LeavePanelTests extends TestBase {
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
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Leave' dziala prawidlowo oraz czy sekcja 'Leave' jest widoczna")
    @Severity(SeverityLevel.CRITICAL)
    @Story("PI-36")
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-36")
    @Parameters({"login", "password"})
    public void checkThatLeaveListIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        leavePanelSteps.clickPimPanelSection();

        assertTrue(leavePanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Description("Jako zalogowany administrator, dodanie urlopu dla zalogowanego uzytkownika")
    @Severity(SeverityLevel.CRITICAL)
    @Story("PI-36")
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-36")
    @Parameters({"login", "password"})
    public void addVacationLeaveForLoggedEmployee(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        String loggedUserData = headerSteps.getLoggedUser();

        leavePanelSteps
                .clickPimPanelSection()
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
