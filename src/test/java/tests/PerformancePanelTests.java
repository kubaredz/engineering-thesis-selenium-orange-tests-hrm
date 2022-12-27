package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import steps.options.PerformancePanelSteps;

import static org.testng.Assert.assertTrue;

public class PerformancePanelTests extends TestBase {

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'Performance' przekierowuje do strony 'Performance' z rozszerzeniem 'Manage Reviews'")
    @Severity(SeverityLevel.NORMAL)
    public void asAdminPerformanceScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        PerformancePanelSteps performancePanelSteps = new PerformancePanelSteps();
        performancePanelSteps.clickPanelSection();

        assertTrue(performancePanelSteps.isPerformanceSectionDisplayed());
        assertTrue(performancePanelSteps.isManageReviewsSectionDisplayed());
    }
}
