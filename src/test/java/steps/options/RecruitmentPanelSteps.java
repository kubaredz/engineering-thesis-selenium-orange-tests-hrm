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
        logger.log(Level.INFO, "Sekcja: \"Recruitment\" zostala wyswietlona");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Recruitment' zostala otwarta")
    public RecruitmentPanelSteps clickPanelSection() {
        recruitmentPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Recruitment\" zostal wcisniety");
        return new RecruitmentPanelSteps();
    }

    @Override
    @Step("Przycisk: 'Add' zostal wcisniety")
    public RecruitmentPanelSteps clickAddButton() {
        addButton.click();
        logger.log(Level.INFO, "Przycisk: \"Add\" zostal wcisniety");
        return new RecruitmentPanelSteps();
    }

    @Override
    @Step("Przycisk: 'save' zostal wcisniety")
    public RecruitmentPanelSteps clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Przycisk: \"Save\" zostal wcisniety");
        return new RecruitmentPanelSteps();
    }

    @Step("Sekcja: 'Add Candidate' zostala wyswietlona")
    public boolean isAddCandidateSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Add Candidate\" zostala wyswietlona");
        return addText.isDisplayed();
    }

    @Step("Imie kandydata: {name} zostalo wpisane")
    public RecruitmentPanelSteps setFirstNameLabel(String name) {
        RepeatedActions.deletingAndAddingContentToLabel(firstNameLabel, name);
        logger.log(Level.INFO, "Imie kandydata: \"{0}\" zostalo wpisane", name);
        return new RecruitmentPanelSteps();
    }

    @Step("Drugie imie kandydata: {secondName} zostalo wpisane")
    public RecruitmentPanelSteps setSecondNameLabel(String secondName) {
        RepeatedActions.deletingAndAddingContentToLabel(secondNameLabel, secondName);
        logger.log(Level.INFO, "Drugie imie kandydata: \"{0}\" zostalo wpisane", secondName);
        return new RecruitmentPanelSteps();
    }

    @Step("Nazwisko kandydata: {lastName} zostalo wpisane")
    public RecruitmentPanelSteps setLastNameLabel(String lastName) {
        RepeatedActions.deletingAndAddingContentToLabel(lastNameLabel, lastName);
        logger.log(Level.INFO, "Nazwisko kandydata: \"{0}\" zostalo wpisane", lastName);
        return new RecruitmentPanelSteps();
    }

    @Step("Lista: 'wakatow' zostala wcisnieta")
    public RecruitmentPanelSteps clickVacancySelect() {
        vacancySelect.click();
        logger.log(Level.INFO, "Lista select dla: \"wakatow\" zostala wcisnieta");
        return new RecruitmentPanelSteps();
    }

    @Step("Stanowisko pracy: 'Associate IT Manager' zostalo wybrane")
    public RecruitmentPanelSteps setVacancyAsAssociateItManager() {
        vacancyAssociateItManager.click();
        logger.log(Level.INFO, "Stanowisko pracy: \"Associate IT Manager\" zostalo wybrane");
        return new RecruitmentPanelSteps();
    }

    @Step("Email kandydata: {email} zostal wpisany")
    public RecruitmentPanelSteps setEmailLabel(String email) {
        RepeatedActions.deletingAndAddingContentToLabel(emailLabel, email);
        logger.log(Level.INFO, "Email kandydata: \"{0}\" zostal wpisany", email);
        return new RecruitmentPanelSteps();
    }

    @Step("Numer kontraktu kandydata: {number} zostal wpisany")
    public RecruitmentPanelSteps setContactNumberLabel(String number) {
        RepeatedActions.deletingAndAddingContentToLabel(contactNumberLabel, number);
        logger.log(Level.INFO, "Numer kontraktu kandydata: \"{0}\" zostal wpisany", number);
        return new RecruitmentPanelSteps();
    }

    @Step("Alert: 'Positive Alert' zostal wyswietlony")
    public boolean isPositiveAlertVisible() {
        logger.log(Level.INFO, "Alert: \"Positive\" zostal wyswietlony");
        return positiveAlert.isDisplayed();
    }

    @Step("Ustawienie nazwy wakatu}")
    public RecruitmentPanelSteps setVacancyNameLabel() {
        String vacancyGenerateData = String.valueOf(int_random);
        vacancyNameLabel.sendKeys(vacancyGenerateData);
        logger.log(Level.INFO, "Ustawienie nazwy wakatu: {0}", vacancyGenerateData);
        return new RecruitmentPanelSteps();
    }

    @Step("Wcisniecie listy select: 'Job title'")
    public RecruitmentPanelSteps clickJobTitleSelect() {
        jobTitleSelect.click();
        logger.log(Level.INFO, "Wcisniecie listy: \"Job title\"");
        return new RecruitmentPanelSteps();
    }

    @Step("Wybranie opisu stanowiska pracy: {jobTitle}")
    public RecruitmentPanelSteps setJobType(String jobTitle) {
        String jobTitleSelector = "//span[normalize-space()='" + jobTitle + "']";
        System.out.println(jobTitleSelector);
        WebElement pickedJob = DriverPicker.driverSetup().findElement(By.xpath(jobTitleSelector));
        Actions actions = new Actions(DriverPicker.driverSetup());
        actions.scrollToElement(pickedJob).perform();
        pickedJob.click();
        logger.log(Level.INFO, "Wybranie opisu stanowiska pracy: {0}", jobTitle);
        return new RecruitmentPanelSteps();
    }

    @Step("Dodanie opisu stanowiska: {jobDescription}")
    public RecruitmentPanelSteps setDescription(String jobDescription) {
        jobDescriptionLabel.sendKeys(jobDescription);
        logger.log(Level.INFO, "Dodanie opisu stanowiska: {0}", jobDescription);
        return new RecruitmentPanelSteps();
    }

    @Step("Wybranie polecajacego uzytkownika jako aktualnie zalogowany uzytkownik")
    public RecruitmentPanelSteps setHiringManager() {
        HeaderSteps headerSteps = new HeaderSteps();
        String loggedUserData = headerSteps.getLoggedUser();
        hiringManagerLabel.sendKeys(loggedUserData);
        logger.log(Level.INFO, "Wybranie polecajacego uzytkownika jako aktualnie zalogowany uzytkownik");
        Wait.waitTillElementIsPresent(promptedHiringManager);
        promptedHiringManager.click();
        return new RecruitmentPanelSteps();
    }

    @Step("Numer ogloszenia to: {positionNumber}")
    public RecruitmentPanelSteps setPositionNumber(String positionNumber) {
        numberOfPositionLabel.sendKeys(positionNumber);
        logger.log(Level.INFO, "Numer ogloszenia to: {0}", positionNumber);
        return new RecruitmentPanelSteps();
    }
}
