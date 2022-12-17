package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import setup.DriverManager;
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
    public void asAdminAddNewUser() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPassword();

        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps.getAdminPanelSection().click();

        adminPanelSteps.getAddButton().click();
        assertTrue(adminPanelSteps.getAddUserText().isDisplayed());

        adminPanelSteps.getUserRoleDropdown().click();
        Actions actions = new Actions(DriverManager.driverSetup());

        actions.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        adminPanelSteps.getEmployeeNameLabel().sendKeys("Jakub");

        // TODO: 17/12/2022
        adminPanelSteps.getStatusDropdown().click();
        actions.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        
        sleep();

    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
