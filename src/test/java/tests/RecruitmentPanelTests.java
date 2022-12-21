package tests;

import helpers.UserDataGenerator;
import org.testng.annotations.Test;
import steps.options.RecruitmentPanelSteps;

import static org.testng.Assert.assertTrue;

public class RecruitmentPanelTests extends TestBase {

    @Test
    public void asAdminRecruitmentScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps.clickRecruitmentPanelSection();

        assertTrue(recruitmentPanelSteps.isRecruitmentSectionDisplayed());
    }

    @Test
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
