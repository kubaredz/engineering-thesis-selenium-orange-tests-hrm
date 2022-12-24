package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.options.BuzzPanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BuzzPanelTests extends TestBase {

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Buzz' dziala prawidlowo oraz czy sekcja 'Buzz' jest widoczna")
    public void asAdminBuzzScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        BuzzPanelSteps buzzPanelSteps = new BuzzPanelSteps();
        buzzPanelSteps.clickBuzzPanelSection();

        assertTrue(buzzPanelSteps.isBuzzTextDisplayed());
    }

    @Test
    @Description("Jako zalogowany administrator, po przejsciu do panelu 'Buzz' weryfikacja czy widoczny jest tekst 'Lanuching Soon'")
    public void asAdminOnBuzzScreenIsInformationThatPageLaunchingSoonTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        BuzzPanelSteps buzzPanelSteps = new BuzzPanelSteps();
        buzzPanelSteps.clickBuzzPanelSection();

        assertTrue(buzzPanelSteps.isLaunchingSoonTextDisplayed());
        assertEquals(buzzPanelSteps.getLaunchingSoonText(), "Launching Soon");
    }
}
