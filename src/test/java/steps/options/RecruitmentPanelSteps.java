package steps.options;

import builders.options.RecruitmentPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;
import steps.dashboard.HeaderSteps;
import utils.RepeatedActions;
import waits.Wait;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RecruitmentPanelSteps extends RecruitmentPanelBuilder implements DefaultSteps, CommonGenericSteps<RecruitmentPanelSteps> {
    private int int_random = ThreadLocalRandom.current().nextInt();

    public RecruitmentPanelSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'Recruitment' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Recruitment\" została wyświetlona");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Recruitment' zostala otwarta")
    public <T> RecruitmentPanelSteps clickPimPanelSection() {
        recruitmentPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Recruitment\" został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    @Override
    @Step("Przycisk: 'Add' zostal wcisniety")
    public RecruitmentPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    @Override
    @Step("Przycisk: 'save' zostal wcisniety")
    public RecruitmentPanelSteps clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Przycisk save: \"{0}\" został wciśnięty");
        return new RecruitmentPanelSteps();
    }

    @Step("Sekcja: 'Add Candidate' zostala wyswietlona")
    public boolean isAddCandidateSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Add Candidate\" została wyświetlona");
        return addText.isDisplayed();
    }

    @Step("Imie kandydata: {name} zostalo wpisane")
    public RecruitmentPanelSteps setFirstNameLabel(String name) {
        RepeatedActions.deletingAndAddingContentToLabel(firstNameLabel, name);
        logger.log(Level.INFO, "First name: \"{0}\" zostało wpisane", name);
        return new RecruitmentPanelSteps();
    }

    @Step("Drugie imie kandydata: {secondName} zostalo wpisane")
    public RecruitmentPanelSteps setSecondNameLabel(String secondName) {
        RepeatedActions.deletingAndAddingContentToLabel(secondNameLabel, secondName);
        logger.log(Level.INFO, "Second name: \"{0}\" zostało wpisane", secondName);
        return new RecruitmentPanelSteps();
    }

    @Step("Nazwisko kandydata: {lastName} zostalo wpisane")
    public RecruitmentPanelSteps setLastNameLabel(String lastName) {
        RepeatedActions.deletingAndAddingContentToLabel(lastNameLabel, lastName);
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
        RepeatedActions.deletingAndAddingContentToLabel(emailLabel, email);
        logger.log(Level.INFO, "Email: \"{0}\" został wpisany", email);
        return new RecruitmentPanelSteps();
    }

    @Step("Numer kontraktu kandydata: {number} zostal wpisany")
    public RecruitmentPanelSteps setContactNumberLabel(String number) {
        RepeatedActions.deletingAndAddingContentToLabel(contactNumberLabel, number);
        logger.log(Level.INFO, "Numer telefonu: \"{0}\" został wpisany", number);
        return new RecruitmentPanelSteps();
    }

    @Step("Alert: 'Positive Alert' zostal wyswietlony")
    public boolean isPositiveAlertVisible() {
        logger.log(Level.INFO, "Alert: \"Positive\" został wyświetlony");
        return positiveAlert.isDisplayed();
    }

    @Step("Ustawienie nazwy wakatu}")
    public RecruitmentPanelSteps setVacancyNameLabel() {
        String vacancyGenerateData = String.valueOf(int_random);
        vacancyNameLabel.sendKeys(vacancyGenerateData);
        logger.log(Level.INFO, "Ustawienie nazwy wakatu: {0}", vacancyGenerateData);
        return new RecruitmentPanelSteps();
    }

    @Step("Wcisniecie selecta job title")
    public RecruitmentPanelSteps clickJobTitleSelect() {
        jobTitleSelect.click();
        logger.log(Level.INFO, "Wcisniecie selecta job title");
        return new RecruitmentPanelSteps();
    }

    @Step("Wybranie job title {jobTitle}")
    public RecruitmentPanelSteps pickJobTitle(String jobTitle) {
        String jobTitleSelector = "//span[normalize-space()='" + jobTitle + "']";
        System.out.println(jobTitleSelector);
        WebElement pickedJob = DriverPicker.driverSetup().findElement(By.xpath(jobTitleSelector));
        Actions actions = new Actions(DriverPicker.driverSetup());
        actions.scrollToElement(pickedJob).perform();
        pickedJob.click();
        logger.log(Level.INFO, "Wybranie job title {0}", jobTitle);
        return new RecruitmentPanelSteps();
    }

    @Step("Dodanie opisu stanowiska {jobDescription}")
    public RecruitmentPanelSteps setDescription(String jobDescription) {
        jobDescriptionLabel.sendKeys(jobDescription);
        logger.log(Level.INFO, "Dodanie opisu stanowiska: {0}", jobDescription);
        return new RecruitmentPanelSteps();
    }

    @Step("Polecajacy uzytkownik to aktualnie zalogowany uzytkownik")
    public RecruitmentPanelSteps setHiringManager() {
        HeaderSteps headerSteps = new HeaderSteps();
        String loggedUserData = headerSteps.getLoggedUser();
        hiringManagerLabel.sendKeys(loggedUserData);
        logger.log(Level.INFO, "Polecajacy uzytkownik to aktualnie zalogowany uzytkownik");
        Wait.waitTillElementIsPresent(promptedHiringManager);
        promptedHiringManager.click();
        return new RecruitmentPanelSteps();
    }

    @Step("Numer ogloszenia to: {jobDescription}")
    public RecruitmentPanelSteps setNumberOfPosition(String positionNumber) {
        numberOfPositionLabel.sendKeys(positionNumber);
        logger.log(Level.INFO, "Numer ogloszenia to: {0}", positionNumber);
        return new RecruitmentPanelSteps();
    }
}
