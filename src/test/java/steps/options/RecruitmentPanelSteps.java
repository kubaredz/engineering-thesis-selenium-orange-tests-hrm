package steps.options;

import builders.RecruitmentPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class RecruitmentPanelSteps extends RecruitmentPanelBuilder {

    public RecruitmentPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Step("Sekcja: 'Recruitment' zostala otwarta")
    public RecruitmentPanelSteps clickRecruitmentPanelSection() {
        recruitmentPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Recruitment\" został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    @Step("Sekcja 'Recruitment' zostala wyswietlona")
    public boolean isRecruitmentSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Recruitment\" została wyświetlona");
        return recruitmentSection.isDisplayed();
    }

    @Step("Przycisk: 'Add' zostal wcisniety")
    public RecruitmentPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    @Step("Sekcja: 'Add Candidate' zostala wyswietlona")
    public boolean isAddCandidateSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Add Candidate\" została wyświetlona");
        return addCandidateSectionText.isDisplayed();
    }

    @Step("Imie kandydata: {name} zostalo wpisane")
    public RecruitmentPanelSteps setFirstNameLabel(String name) {
        firstNameLabel.sendKeys(name);
        logger.log(Level.INFO, "First name: \"{0}\" zostało wpisane", name);
        return new RecruitmentPanelSteps();
    }

    @Step("Drugie imie kandydata: {secondName} zostalo wpisane")
    public RecruitmentPanelSteps setSecondNameLabel(String secondName) {
        secondNameLabel.sendKeys(secondName);
        logger.log(Level.INFO, "Second name: \"{0}\" zostało wpisane", secondName);
        return new RecruitmentPanelSteps();
    }

    @Step("Nazwisko kandydata: {lastName} zostalo wpisane")
    public RecruitmentPanelSteps setLastNameLabel(String lastName) {
        lastNameLabel.sendKeys(lastName);
        logger.log(Level.INFO, "Last name: \"{0}\" zostało wpisane", lastName);
        return new RecruitmentPanelSteps();
    }

    @Step("Lista: 'vacancy' zostala wcisnieta")
    public RecruitmentPanelSteps clickVacancySelect() {
        vacancySelect.click();
        logger.log(Level.INFO, "Select vacancy: został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    @Step("Stanowisko pracy: 'Associate IT Manager' zostalo wybrane")
    public RecruitmentPanelSteps setVacancyAsAssociateItManager() {
        vacancyAssociateItManager.click();
        logger.log(Level.INFO, "Vacancy: \"Associate IT Manager\" zostało wybrane");
        return new RecruitmentPanelSteps();
    }

    @Step("Email kandydata: {email} zostal wpisany")
    public RecruitmentPanelSteps setEmailLabel(String email) {
        emailLabel.sendKeys(email);
        logger.log(Level.INFO, "Email: \"{0}\" został wpisany", email);
        return new RecruitmentPanelSteps();
    }

    @Step("Numer kontraktu kandydata: {number} zostal wpisany")
    public RecruitmentPanelSteps setContactNumberLabel(String number) {
        contactNumberLabel.sendKeys(number);
        logger.log(Level.INFO, "Numer telefonu: \"{0}\" został wpisany", number);
        return new RecruitmentPanelSteps();
    }

    @Step("Przycisk: 'save' zostal wcisniety")
    public RecruitmentPanelSteps clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Przycisk save: \"{0}\" został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    @Step("Alert: 'Positive Alert' zostal wyswietlony")
    public boolean isPositiveAlertVisible(){
        logger.log(Level.INFO, "Alert: \"Positive\" został wyświetlony");
        return positiveAlert.isDisplayed();
    }
}
