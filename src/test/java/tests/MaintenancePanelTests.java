package tests;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
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
    @Story("PI-38")
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-38")
    @Parameters({"login", "password"})
    public void asAdminMaintenanceScreenIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        maintenancePanelSteps.clickPanelSection();

        assertEquals(maintenancePanelSteps.getMaintenancePageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/maintenance/purgeEmployee");
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy administrator moze zalogowac sie do panelu 'Administrator Access'")
    @Severity(SeverityLevel.NORMAL)
    @Story("PI-38")
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-38")
    @Parameters({"login", "password"})
    public void asAdminLoginToMaintenanceAdministratorAccessPageTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);
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
