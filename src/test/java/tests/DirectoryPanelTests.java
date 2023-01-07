package tests;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.options.DirectoryPanelSteps;

import static org.testng.Assert.assertTrue;

public class DirectoryPanelTests extends TestNgSteps {
    private CommonTests commonTests;
    private DirectoryPanelSteps directoryPanelSteps;

    @BeforeMethod
    public void directoryPanelTestsSetup() {
        commonTests = new CommonTests();
        directoryPanelSteps = new DirectoryPanelSteps();
    }

    @Test
    @Story("PI-34")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-34")
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Directory' dziala prawidlowo oraz czy sekcja 'Directory' jest widoczna")
    @Parameters({"login", "password"})
    public void asAdminDirectoryScreenIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        directoryPanelSteps.clickPanelSection();
        assertTrue(directoryPanelSteps.isHeaderTextDisplayed());
    }
}