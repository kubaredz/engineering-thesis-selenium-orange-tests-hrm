package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import steps.options.DirectoryPanelSteps;


import static org.testng.Assert.assertTrue;

public class DirectoryPanelTests extends TestBase{

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Directory' dziala prawidlowo oraz czy sekcja 'Directory' jest widoczna")
    @Severity(SeverityLevel.NORMAL)
    public void asAdminDirectoryScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        DirectoryPanelSteps directoryPanelSteps = new DirectoryPanelSteps();
        directoryPanelSteps.clickDirectorySection();

        assertTrue(directoryPanelSteps.isDirectoryDisplayed());
    }
}
