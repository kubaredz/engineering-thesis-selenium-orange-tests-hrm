package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.options.BuzzPanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BuzzPanelTests extends TestBase {
    private CommonTests commonTests;
    private BuzzPanelSteps buzzPanelSteps;

    @BeforeMethod
    public void buzzPanelTestsSetup() {
        commonTests = new CommonTests();
        buzzPanelSteps = new BuzzPanelSteps();
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Buzz' dziala prawidlowo oraz czy sekcja 'Buzz' jest widoczna")
    @Severity(SeverityLevel.CRITICAL)
    @Story("PI-31")
    @Parameters({"login", "password"})
    public void asAdminBuzzScreenIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        buzzPanelSteps.clickPimPanelSection();

        assertTrue(buzzPanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Description("Jako zalogowany administrator, po przejsciu do panelu 'Buzz' weryfikacja czy widoczny jest tekst 'Lanuching Soon'")
    @Severity(SeverityLevel.NORMAL)
    @Story("PI-31")
    @Parameters({"login", "password"})
    public void asAdminOnBuzzScreenIsInformationThatPageLaunchingSoonTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        buzzPanelSteps.clickPimPanelSection();

        assertTrue(buzzPanelSteps.isLaunchingSoonTextDisplayed());
        assertEquals(buzzPanelSteps.getLaunchingSoonText(), "Launching Soon");
    }
}
