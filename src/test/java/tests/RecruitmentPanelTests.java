package tests;

import helpers.UserDataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.options.RecruitmentPanelSteps;

import static org.testng.Assert.assertTrue;

public class RecruitmentPanelTests extends TestBase {
    private CommonTests commonTests;
    private RecruitmentPanelSteps recruitmentPanelSteps;

    @BeforeMethod
    public void recruitmentPanelTestsSetup() {
        commonTests = new CommonTests();
        recruitmentPanelSteps = new RecruitmentPanelSteps();
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'Recruitment' przekierowuje do strony 'Recrutiment' z lista osob w trakcie rekrutacji")
    public void asAdminRecruitmentScreenIsPresentTest() {
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        recruitmentPanelSteps.clickPanelSection();

        assertTrue(recruitmentPanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja dodania nowego kandydata do systemu rekrutacyjnego")
    @Severity(SeverityLevel.CRITICAL)
    public void asAdminAddNewCandidate() {
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

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
//                .setResumeLabel("C:\\Users\\kubar\\OneDrive\\Pulpit\\praca-inzynierska\\resources\\pdf\\resume-cv.pdf");

        assertTrue(recruitmentPanelSteps.isPositiveAlertVisible());
        assertTrue(recruitmentPanelSteps.isHeaderTextDisplayed());
    }
}
