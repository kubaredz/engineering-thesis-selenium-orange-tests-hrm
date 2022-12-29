package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.options.DirectoryPanelSteps;


import static org.testng.Assert.assertTrue;

public class DirectoryPanelTests extends TestBase {
    private CommonTests commonTests;
    private DirectoryPanelSteps directoryPanelSteps;

    @BeforeMethod
    public void directoryPanelTestsSetup() {
        commonTests = new CommonTests();
        directoryPanelSteps = new DirectoryPanelSteps();
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Directory' dziala prawidlowo oraz czy sekcja 'Directory' jest widoczna")
    @Severity(SeverityLevel.NORMAL)
    @Parameters({"login", "password"})
    public void asAdminDirectoryScreenIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        directoryPanelSteps.clickPimPanelSection();
        assertTrue(directoryPanelSteps.isHeaderTextDisplayed());
    }
}
