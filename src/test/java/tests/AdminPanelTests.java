package tests;

import helpers.PasswordGenerator;
import helpers.UserDataGenerator;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;
import steps.options.AdminPanelSteps;

import static org.testng.Assert.assertTrue;

public class AdminPanelTests extends TestBase {

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Admin' dziala prawidlowo oraz czy sekcja 'User Management' jest widoczna")
    public void asAdminUserManagementScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps.clickAdminPanelSection();

        assertTrue(adminPanelSteps.isUserManagementSectionDisplayed());
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja dodania nowego konta administratora")
    public void asAdminAddNewAdministratorProfileTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        HeaderSteps headerSteps = new HeaderSteps();
        String loggedUserData = headerSteps.getLoggedUser();

        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickAdminPanelSection()
                .clickAddButton();

        assertTrue(adminPanelSteps.isAddUserTextDisplayed());

        String password = PasswordGenerator.generate(10);
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
