package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.options.PerformancePanelSteps;

import static org.testng.Assert.assertTrue;

public class PerformancePanelTests extends TestBase {
    private CommonTests commonTests;
    private PerformancePanelSteps performancePanelSteps;

    @BeforeMethod
    public void performancePanelTestsSetup() {
        commonTests = new CommonTests();
        performancePanelSteps = new PerformancePanelSteps();
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'Performance' przekierowuje do strony 'Performance' z rozszerzeniem 'Manage Reviews'")
    @Severity(SeverityLevel.NORMAL)
    @Parameters({"login", "password"})
    public void asAdminPerformanceScreenIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        performancePanelSteps.clickPimPanelSection();

        assertTrue(performancePanelSteps.isPerformanceSectionDisplayed());
        assertTrue(performancePanelSteps.isManageReviewsSectionDisplayed());
    }
}
