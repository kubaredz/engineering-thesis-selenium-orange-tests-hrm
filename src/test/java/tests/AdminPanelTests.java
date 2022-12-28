package tests;

import helpers.PasswordGenerator;
import helpers.UserDataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
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
    public void asAdminUserManagementScreenIsPresentTest() {
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        adminPanelSteps.clickPimPanelSection();
        assertTrue(adminPanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Jako zalogowany administrator, weryfikacja dodania nowego konta administratora")
    public void asAdminAddNewAdministratorProfileTest() {
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        String loggedUserData = headerSteps.getLoggedUser();

        adminPanelSteps
                .clickPimPanelSection()
                .clickAddButton();

        assertTrue(adminPanelSteps.isAddUserTextDisplayed());

        String password = PasswordGenerator.generate(15);

        adminPanelSteps
                .setEmployeeNameLabel(loggedUserData)
                .clickEmployeeNameFromList()
                .setUsernameLabel(UserDataGenerator.generateUsername())
                .setEmployeePasswordLabel(password)
                .setEmployeeConfirmPasswordLabel(password)
                .clickStatusList()
                .clickEnabledStatus()
                .clickUserRoleDropdown()
                .clickAdminUserRoleButton()
                .clickSaveButton();

        assertTrue(adminPanelSteps.isPositiveAlertDisplayed());
        assertTrue(adminPanelSteps.isSystemUsersTextDisplayed());
    }
}
