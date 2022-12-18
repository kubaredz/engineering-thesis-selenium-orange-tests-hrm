package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import setup.DriverManager;
import steps.options.AdminPanelSteps;

import static org.testng.Assert.assertTrue;

public class AdminPanelTests extends TestBase {

    @Test
    public void asAdminUserManagementScreenIsPresentTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();

        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps.clickAdminPanelSection();

        assertTrue(adminPanelSteps.isUserManagementSectionDisplayed());
    }

    @Test
    public void asAdminAddNewUserTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();

        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps.clickAdminPanelSection();
        adminPanelSteps.clickAddButton();

        assertTrue(adminPanelSteps.isAddUserTextDisplayed());

        adminPanelSteps.clickUserRoleDropdown();

        Actions actions = new Actions(DriverManager.driverSetup());
        actions.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        adminPanelSteps.setEmployeeNameLabel("Jakub");

        // TODO: 17/12/2022
        adminPanelSteps.clickStatusDropdown();
        actions.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
    }
}
