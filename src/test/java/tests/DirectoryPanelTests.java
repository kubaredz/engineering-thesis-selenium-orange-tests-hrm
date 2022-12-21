package tests;

import org.testng.annotations.Test;
import steps.options.DirectoryPanelSteps;


import static org.testng.Assert.assertTrue;

public class DirectoryPanelTests extends TestBase{

    @Test
    public void asAdminDirectoryScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        DirectoryPanelSteps directoryPanelSteps = new DirectoryPanelSteps();
        directoryPanelSteps.clickDirectorySection();

        assertTrue(directoryPanelSteps.isDirectoryDisplayed());
    }
}
