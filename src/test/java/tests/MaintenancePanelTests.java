package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.options.MaintenancePanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MaintenancePanelTests extends TestBase {
    private CommonTests commonTests;
    private MaintenancePanelSteps maintenancePanelSteps;

    @BeforeMethod
    public void maintenancePanelTestsSetup() {
        commonTests = new CommonTests();
        maintenancePanelSteps = new MaintenancePanelSteps();
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Maintenance' przekierowywuje do strony 'purge employee'")
    @Severity(SeverityLevel.CRITICAL)
    public void asAdminMaintenanceScreenIsPresentTest() {
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        maintenancePanelSteps.clickPanelSection();

        assertEquals(maintenancePanelSteps.getMaintenancePageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/maintenance/purgeEmployee");
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy administrator moze zalogowac sie do panelu 'Administrator Access'")
    @Severity(SeverityLevel.NORMAL)
    public void asAdminLoginToMaintenanceAdministratorAccessPageTest() {
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        maintenancePanelSteps
                .clickPanelSection()
                .setPasswordLabel("admin123")
                .clickConfirmButton();

        assertTrue(maintenancePanelSteps.isHeaderTextDisplayed());
        assertEquals(maintenancePanelSteps.getMaintenanceText(), "Maintenance");

        assertTrue(maintenancePanelSteps.isPurgeRecordsTextDisplayed());
        assertEquals(maintenancePanelSteps.getPurgeRecordsText(), "Purge Records");
    }
}
