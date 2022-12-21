package tests;

import org.testng.annotations.Test;
import steps.options.MaintenancePanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MaintenancePanelTests extends TestBase {

    @Test
    public void asAdminDirectoryScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        MaintenancePanelSteps maintenancePanelSteps = new MaintenancePanelSteps();
        maintenancePanelSteps.clickMaintenanceSection();

        assertEquals(maintenancePanelSteps.getMaintenancePageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/maintenance/purgeEmployee");
    }

    @Test
    public void asAdminLoginToMaintenanceAdministratorAccessPageTest(){
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        MaintenancePanelSteps maintenancePanelSteps = new MaintenancePanelSteps();
            maintenancePanelSteps
                    .clickMaintenanceSection()
                    .setPasswordLabel("admin123")
                    .clickConfirmButton();

        assertTrue(maintenancePanelSteps.isMaintenanceTextDisplayed());
        assertEquals(maintenancePanelSteps.getMaintenanceText(), "Maintenance");

        assertTrue(maintenancePanelSteps.isPurgeRecordsTextDisplayed());
        assertEquals(maintenancePanelSteps.getPurgeRecordsText(), "Purge Records");


    }
}
