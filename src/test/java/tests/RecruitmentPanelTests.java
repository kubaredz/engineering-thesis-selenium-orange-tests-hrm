package tests;

import helpers.UserDataGenerator;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.options.RecruitmentPanelSteps;

import static org.testng.Assert.assertTrue;

public class RecruitmentPanelTests extends TestNgSteps {
    private CommonTests commonTests;
    private RecruitmentPanelSteps recruitmentPanelSteps;

    @BeforeMethod
    public void recruitmentPanelTestsSetup() {
        commonTests = new CommonTests();
        recruitmentPanelSteps = new RecruitmentPanelSteps();
    }

    @Test
    @Story("PI-42")
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-42")
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'Recruitment' przekierowuje do strony 'Recrutiment' z lista osob w trakcie rekrutacji")
    @Parameters({"login", "password"})
    public void asAdminRecruitmentScreenIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        recruitmentPanelSteps.clickPanelSection();
        assertTrue(recruitmentPanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Story("PI-42")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-42")
    @Description("Jako zalogowany uzytkownik, weryfikacja dodania nowego kandydata do systemu rekrutacyjnego")
    @Parameters({"login", "password"})
    public void asAdminAddNewCandidate(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        recruitmentPanelSteps
                .clickPanelSection()
                .clickAddButton();

        assertTrue(recruitmentPanelSteps.isAddCandidateSectionDisplayed());

        String firstName = UserDataGenerator.generateFirstName();
        String secondName = UserDataGenerator.generateMiddleName();
        String lastName = UserDataGenerator.generateLastName();
        String email = UserDataGenerator.generateEmailAddress();
        String phoneNumber = UserDataGenerator.generatePhoneNumber();

        recruitmentPanelSteps
                .setFirstNameLabel(firstName)
                .setSecondNameLabel(secondName)
                .setLastNameLabel(lastName)
                .clickVacancySelect()
                .setVacancyAsAssociateItManager()
                .setEmailLabel(email)
                .setContactNumberLabel(phoneNumber)
                .clickSaveButton();

        assertTrue(recruitmentPanelSteps.isPositiveAlertVisible());
        assertTrue(recruitmentPanelSteps.isHeaderTextDisplayed());
    }
}