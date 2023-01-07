package tests;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.options.BuzzPanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BuzzPanelTests extends TestNgSteps {
    private CommonTests commonTests;
    private BuzzPanelSteps buzzPanelSteps;

    @BeforeMethod
    public void buzzPanelTestsSetup() {
        commonTests = new CommonTests();
        buzzPanelSteps = new BuzzPanelSteps();
    }

    @Test
    @Story("PI-31")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-31")
    @Description("Jako zalogowany administrator, weryfikacja czy panel 'Buzz' dziala prawidlowo oraz czy sekcja 'Buzz' jest widoczna")
    @Parameters({"login", "password"})
    public void asAdminBuzzScreenIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        buzzPanelSteps.clickPanelSection();
        assertTrue(buzzPanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Story("PI-31")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-31")
    @Description("Jako zalogowany administrator, po przejsciu do panelu 'Buzz' weryfikacja czy widoczny jest tekst 'Lanuching Soon'")
    @Parameters({"login", "password"})
    public void asAdminOnBuzzScreenIsInformationThatPageLaunchingSoonTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        buzzPanelSteps.clickPanelSection();

        assertTrue(buzzPanelSteps.isLaunchingSoonTextDisplayed());
        assertEquals(buzzPanelSteps.getLaunchingSoonText(), "Launching Soon");
    }
}