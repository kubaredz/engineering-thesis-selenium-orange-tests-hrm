package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.options.PerformancePanelSteps;

import static org.testng.Assert.assertTrue;

public class PerformancePanelTests extends TestBase {

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'Performance' przekierowuje do strony 'Performance' z rozszerzeniem 'Manage Reviews'")
    public void asAdminPerformanceScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        PerformancePanelSteps performancePanelSteps = new PerformancePanelSteps();
        performancePanelSteps.clickPerformanceSection();

        assertTrue(performancePanelSteps.isPerformanceSectionDisplayed());
        assertTrue(performancePanelSteps.isManageReviewsSectionDisplayed());
    }
}
