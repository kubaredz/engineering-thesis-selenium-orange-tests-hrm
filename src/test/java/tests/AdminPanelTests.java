package tests;

import helpers.PasswordGenerator;
import helpers.UserDataGenerator;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.AdminPanelSteps;

import static org.junit.Assert.assertTrue;

public class AdminPanelTests extends TestBase {
    private CommonTests commonTests;
    private AdminPanelSteps adminPanelSteps;
    private HeaderSteps headerSteps;

    @BeforeMethod
    public void adminPanelTestsSetup() {
        commonTests = new CommonTests();
        adminPanelSteps = new AdminPanelSteps();
        headerSteps = new HeaderSteps();
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Admin' dziala prawidlowo oraz czy sekcja 'User Management' jest widoczna")
    @Severity(SeverityLevel.CRITICAL)
    @Story("PI-30")
    @Parameters({"login", "password"})
    public void asAdminUserManagementScreenIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        adminPanelSteps.clickPimPanelSection();
        assertTrue(adminPanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Jako zalogowany administrator, weryfikacja dodania nowego konta administratora")
    @Story("PI-30")
    @Parameters({"login", "password"})
    public void asAdminAddNewAdministratorProfileTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        String loggedUserData = headerSteps.getLoggedUser();

        adminPanelSteps
                .clickPimPanelSection()
                .clickAddButton();

        assertTrue(adminPanelSteps.isAddUserTextDisplayed());

        String generatedPassword = PasswordGenerator.generate(15);

        adminPanelSteps
                .setEmployeeNameLabel(loggedUserData)
                .clickEmployeeNameFromList()
                .setUsernameLabel(UserDataGenerator.generateUsername())
                .setEmployeePasswordLabel(generatedPassword)
                .setEmployeeConfirmPasswordLabel(generatedPassword)
                .clickStatusList()
                .clickEnabledStatus()
                .clickUserRoleDropdown()
                .clickAdminUserRoleButton()
                .clickSaveButton();

        assertTrue(adminPanelSteps.isPositiveAlertDisplayed());
        assertTrue(adminPanelSteps.isSystemUsersTextDisplayed());
    }
}
