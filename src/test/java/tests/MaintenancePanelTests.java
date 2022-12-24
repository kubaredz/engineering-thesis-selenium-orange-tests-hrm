package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.options.MaintenancePanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MaintenancePanelTests extends TestBase {

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Maintenance' przekierowywuje do strony 'purge employee'")
    public void asAdminMaintenanceScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        MaintenancePanelSteps maintenancePanelSteps = new MaintenancePanelSteps();
        maintenancePanelSteps.clickMaintenanceSection();

        assertEquals(maintenancePanelSteps.getMaintenancePageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/maintenance/purgeEmployee");
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy administrator moze zalogowac sie do panelu 'Administrator Access'")
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
