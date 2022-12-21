package steps.options;

import builders.RecruitmentPanelBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class RecruitmentPanelSteps extends RecruitmentPanelBuilder {

    public RecruitmentPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public RecruitmentPanelSteps clickRecruitmentPanelSection() {
        recruitmentPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Recruitment\" został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    public boolean isRecruitmentSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Recruitment\" została wyświetlona");
        return recruitmentSection.isDisplayed();
    }

    public RecruitmentPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    public boolean isAddCandidateSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Add Candidate\" została wyświetlona");
        return addCandidateSectionText.isDisplayed();
    }

    public RecruitmentPanelSteps setFirstNameLabel(String name) {
        firstNameLabel.sendKeys(name);
        logger.log(Level.INFO, "First name: \"{0}\" zostało wpisane", name);
        return new RecruitmentPanelSteps();
    }

    public RecruitmentPanelSteps setSecondNameLabel(String secondName) {
        secondNameLabel.sendKeys(secondName);
        logger.log(Level.INFO, "Second name: \"{0}\" zostało wpisane", secondName);
        return new RecruitmentPanelSteps();
    }

    public RecruitmentPanelSteps setLastNameLabel(String lastName) {
        lastNameLabel.sendKeys(lastName);
        logger.log(Level.INFO, "Last name: \"{0}\" zostało wpisane", lastName);
        return new RecruitmentPanelSteps();
    }

    public RecruitmentPanelSteps clickVacancySelect() {
        vacancySelect.click();
        logger.log(Level.INFO, "Select vacancy: został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    public RecruitmentPanelSteps setVacancyAsAssociateItManager() {
        vacancyAssociateItManager.click();
        logger.log(Level.INFO, "Vacancy: \"Associate IT Manager\" zostało wybrane");
        return new RecruitmentPanelSteps();
    }

    public RecruitmentPanelSteps setEmailLabel(String email) {
        emailLabel.sendKeys(email);
        logger.log(Level.INFO, "Email: \"{0}\" został wpisany", email);
        return new RecruitmentPanelSteps();
    }

    public RecruitmentPanelSteps setContactNumberLabel(String number) {
        contactNumberLabel.sendKeys(number);
        logger.log(Level.INFO, "Numer telefonu: \"{0}\" został wpisany", number);
        return new RecruitmentPanelSteps();
    }

//    public RecruitmentPanelSteps setResumeLabel(String number) {
//        resumeLabel.click();
//        resumeLabel.sendKeys(number);
//        logger.log(Level.INFO, "Cv: \"{0}\" zostało dodane", number);
//        return new RecruitmentPanelSteps();
//    }

    public RecruitmentPanelSteps clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Przycisk save: \"{0}\" został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    public boolean isPositiveAlertVisible(){
        logger.log(Level.INFO, "Alert: \"Positive\" został wyświetlony");
        return positiveAlert.isDisplayed();
    }
}
