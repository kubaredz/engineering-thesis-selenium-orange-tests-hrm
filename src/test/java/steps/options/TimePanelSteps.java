package steps.options;

import builders.options.TimePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;
import utils.RepeatedActions;
import waits.Wait;

import java.util.logging.Level;

public class TimePanelSteps extends TimePanelBuilder implements DefaultSteps, CommonGenericSteps<TimePanelSteps> {

    public TimePanelSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'Timesheet' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Timesheet\" została wyświetlona");
        return headerTextAddition.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Time' zostala otwarta")
    public <T> TimePanelSteps clickPimPanelSection() {
        timePanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Time\" został wciśnięty");
        return new TimePanelSteps();
    }

    @Override
    public <T> CommonGenericSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> CommonGenericSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }

    @Step("Imie pracownika: {name} zostalo wpisane")
    public TimePanelSteps setEmployeeName(String name) {
        RepeatedActions.deletingAndAddingContentToLabel(employeeNameLabel, name);
        logger.log(Level.INFO, "Imię: \"{0}\" zostało wpisane", name);
        return new TimePanelSteps();
    }

    @Step("Wybranie wyswietlonego pracownika")
    public TimePanelSteps pickPromptedEmployeeName() {
        promptedEmployeeName.click();
        logger.log(Level.INFO, "Wybranie wyświetlonego imienia");
        return new TimePanelSteps();
    }

    @Step("Przycisk: 'view' zostal wcisniety")
    public TimePanelSteps clickViewButton() {
        viewButton.click();
        logger.log(Level.INFO, "kliknięcie przycisku: \"view\"");
        return new TimePanelSteps();
    }

    @Step("Sekcja: 'Time' zostala wyswietlona")
    public boolean isTimeSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Time\" jest widoczna");
        return headerTextPrefix.isDisplayed();
    }

    @Step("Alert: 'Info' zostal wyswietlony")
    public boolean isAlertInfoDisplayed() {
        logger.log(Level.INFO, "Alert: \"Info\" jest widoczny");
        return infoAlert.isDisplayed();
    }

    @Step("Wcisniecie przycisku z listy w sekcji Time: {listButton}")
    public TimePanelSteps selectButtonFromListInTimeAndClick(String listButton) {
        String fieldGroupSelector = "//span[normalize-space()='" + listButton + "']";
        WebElement buttonFromList = DriverPicker.driverSetup().findElement(By.xpath(fieldGroupSelector));
        logger.log(Level.INFO, "Wybranie przycisku z listy w sekcji Time: {0} ", listButton);
        buttonFromList.click();
        logger.log(Level.INFO, "Wcisniecie przycisku z listy: {0} ", listButton);
        return new TimePanelSteps();
    }

    @Step("Wybranie opcji z listy: {option}")
    public TimePanelSteps pickOptionFromList(String option) {
        String fieldGroupSelector = "//a[contains(text(),'" + option + "')]";
        WebElement pickedOption = DriverPicker.driverSetup().findElement(By.xpath(fieldGroupSelector));
        logger.log(Level.INFO, "Wybranie opcji z listy: {0} ", pickedOption);
        pickedOption.click();
        logger.log(Level.INFO, "Wcisniecie opcji z listy: {0} ", pickedOption);
        return new TimePanelSteps();
    }

    @Step("Wcisniecie przycisku: {button}'")
    public TimePanelSteps clickButtonWithNormalizeSpace(String button) {
        String fieldGroupSelector = "//button[normalize-space()='" + button + "']";
        System.out.println(fieldGroupSelector);
        WebElement pickedButton = DriverPicker.driverSetup().findElement(By.xpath(fieldGroupSelector));
        pickedButton.click();
        logger.log(Level.INFO, "Wcisniecie przycisku: {0} ", button);
        return new TimePanelSteps();
    }

    @Step("Wpisany projekt to: {projectName}")
    public TimePanelSteps setProjectName(String projectName) {
        RepeatedActions.deletingAndAddingContentToLabel(projectNameLabel, projectName);
        logger.log(Level.INFO, "Wpisany projekt to: {0}", projectName);
        return new TimePanelSteps();
    }

    @Step("Wybranie podpowiedzianego projektu'")
    public TimePanelSteps chosePromptedProject() {
        pickedProject.click();
        logger.log(Level.INFO, "Wybranie projektu");
        return new TimePanelSteps();
    }

    @Step("Wybranie rodzaju pracy")
    public TimePanelSteps choseActivity(String activityType) {
        activitySelect.click();
        String fieldGroupSelector = "//span[contains(text(),'" + activityType + "')]";
        WebElement chosenActivity = DriverPicker.driverSetup().findElement(By.xpath(fieldGroupSelector));
        Wait.waitTillElementIsPresent(chosenActivity);
        logger.log(Level.INFO, "Wybranie rodzaju pracy: {0} ", activityType);
        chosenActivity.click();
        logger.log(Level.INFO, "Wcisniecie pracy: {0} ", activityType);
        return new TimePanelSteps();
    }

    @Step("Dodanie {hours} godzin pracy dla {days} dni roboczych")
    public TimePanelSteps setWorkedHours(String hours, int days) {
        for (int i = 3; i < 3 + days; i++) {
            String dayLabelSelector = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr[1]/td[" + i + "]/div[1]/div[2]/input[1]";
            logger.log(Level.INFO, "Dodanie godzin pracy: {0} ", hours);
            logger.log(Level.INFO, "Dodanie godzin pracy dla: {0} dni roboczych", days);
            WebElement dayLabel = DriverPicker.driverSetup().findElement(By.xpath(dayLabelSelector));
            RepeatedActions.deletingAndAddingContentToLabel(dayLabel, hours);
        }
        return new TimePanelSteps();
    }

    @Step("Zresetowanie raportu")
    public TimePanelSteps clickDeleteReportButton() {
        logger.log(Level.INFO, "Zresetowanie raportu godzin");
        deleteReportButton.click();
        return new TimePanelSteps();
    }
}
