package tests;

import org.testng.annotations.Test;
import steps.options.AdminPanelSteps;

import static org.testng.Assert.assertTrue;

public class AdminPanelTests extends TestBase {

    @Test
    public void asAdminUserManagementScreenIsPresent() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPassword();

        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps.getAdminPanelSection().click();

        assertTrue(adminPanelSteps.getUserManagementSection().isDisplayed());
    }

    @Test
    public void asAdminAddNewUser(){
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPassword();

        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps.getAdminPanelSection().click();

        adminPanelSteps.getAddButton().click();

        assertTrue(adminPanelSteps.getAddUserText().isDisplayed());
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
