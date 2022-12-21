package tests;

import org.testng.annotations.Test;
import steps.options.BuzzPanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BuzzPanelTests extends TestBase {

    @Test
    public void asAdminBuzzScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        BuzzPanelSteps buzzPanelSteps = new BuzzPanelSteps();
        buzzPanelSteps.clickBuzzPanelSection();

        assertTrue(buzzPanelSteps.isBuzzTextDisplayed());
    }

    @Test
    public void asAdminOnBuzzScreenIsInformationThatPageLaunchingSoonTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        BuzzPanelSteps buzzPanelSteps = new BuzzPanelSteps();
        buzzPanelSteps.clickBuzzPanelSection();

        assertTrue(buzzPanelSteps.isLaunchingSoonTextDisplayed());
        assertEquals(buzzPanelSteps.getLaunchingSoonText(), "Launching Soon");
    }
}
