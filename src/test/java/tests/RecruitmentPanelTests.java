package tests;

import helpers.UserDataGenerator;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.options.RecruitmentPanelSteps;

import static org.testng.Assert.assertTrue;

public class RecruitmentPanelTests extends TestBase {

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'Recruitment' przekierowuje do strony 'Recrutiment' z lista osob w trakcie rekrutacji")
    public void asAdminRecruitmentScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps.clickRecruitmentPanelSection();

        assertTrue(recruitmentPanelSteps.isRecruitmentSectionDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja dodania nowego kandydata do systemu rekrutacyjnego")
    public void asAdminAddNewCandidate() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .clickRecruitmentPanelSection()
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
        assertTrue(recruitmentPanelSteps.isRecruitmentSectionDisplayed());
    }
}
