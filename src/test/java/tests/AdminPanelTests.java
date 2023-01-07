package tests;

import helpers.PasswordGenerator;
import helpers.UserDataGenerator;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.PageSetup;
import steps.dashboard.HeaderSteps;
import steps.options.AdminPanelSteps;

import static org.junit.Assert.assertTrue;

public class AdminPanelTests extends TestNgSteps {
    private CommonTests commonTests;
    private AdminPanelSteps adminPanelSteps;
    private HeaderSteps headerSteps;
    private PageSetup pageSetup;

    @BeforeMethod
    public void adminPanelTestsSetup() {
        commonTests = new CommonTests();
        adminPanelSteps = new AdminPanelSteps();
        headerSteps = new HeaderSteps();
    }

    @Test
    @Story("PI-30")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-30")
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Admin' dziala prawidlowo oraz czy sekcja 'User Management' jest widoczna")
    public void asAdminUserManagementScreenIsPresentTest() {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(pageSetup.setLogin(), pageSetup.setPassword());

        adminPanelSteps.clickPanelSection();
        assertTrue(adminPanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Story("PI-30")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-30")
    @Description("Jako zalogowany administrator, weryfikacja dodania nowego konta administratora")
    @Parameters({"login", "password"})
    public void asAdminAddNewAdministratorAccountTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        String loggedUserData = headerSteps.getLoggedUser();

        adminPanelSteps
                .clickPanelSection()
                .clickAddButton();

        assertTrue(adminPanelSteps.isAddUserTextDisplayed());

        String generatedPassword = PasswordGenerator.generatePassword(15);

        adminPanelSteps
                .setEmployeeNameLabel(loggedUserData)
                .clickEmployeeNameFromList()
                .setUsernameLabel(UserDataGenerator.generateUsername())
                .setEmployeePasswordLabel(generatedPassword)
                .setRepeatedPasswordLabel(generatedPassword)
                .clickStatusList()
                .clickEnabledStatus()
                .clickUserRoleDropdown()
                .clickAdminUserRoleButton()
                .clickSaveButton();

        assertTrue(adminPanelSteps.isPositiveAlertDisplayed());
        assertTrue(adminPanelSteps.isSystemUsersTextDisplayed());
    }
}