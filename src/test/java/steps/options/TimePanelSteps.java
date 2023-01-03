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
        logger.log(Level.INFO, "Sekcja: \"Timesheet\" zostala wyswietlona");
        return headerTextAddition.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Time' zostala otwarta")
    public TimePanelSteps clickPanelSection() {
        timePanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Time\" zostal wcisniety");
        return new TimePanelSteps();
    }

    @Override
    public CommonGenericSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CommonGenericSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }

    @Step("Imie pracownika: {name} zostalo wpisane")
    public TimePanelSteps setEmployeeName(String name) {
        RepeatedActions.deletingAndAddingContentToLabel(employeeNameLabel, name);
        logger.log(Level.INFO, "Imie pracownika: \"{0}\" zostalo wpisane", name);
        return new TimePanelSteps();
    }

    @Step("Wybranie wyswietlonego pracownika")
    public TimePanelSteps pickPromptedEmployeeName() {
        promptedEmployeeName.click();
        logger.log(Level.INFO, "Wybranie wyswietlonego imienia");
        return new TimePanelSteps();
    }

    @Step("Przycisk: 'view' zostal wcisniety")
    public TimePanelSteps clickViewButton() {
        viewButton.click();
        logger.log(Level.INFO, "Wcisniecie przycisku: \"View\"");
        return new TimePanelSteps();
    }

    @Step("Sekcja: 'Time' zostala wyswietlona")
    public boolean isTimeSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Time\" zostala wyswietlona");
        return headerTextPrefix.isDisplayed();
    }

    @Step("Alert: 'Info' zostal wyswietlony")
    public boolean isAlertInfoDisplayed() {
        logger.log(Level.INFO, "Alert: \"Info\" zostal wyswietlony");
        return infoAlert.isDisplayed();
    }

    @Step("Wybranie oraz wcisniecie przycisku z listy w sekcji Time: {listButton}")
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

    @Step("Wpisany projekt pracownika to: {projectName}")
    public TimePanelSteps setProjectName(String projectName) {
        RepeatedActions.deletingAndAddingContentToLabel(projectNameLabel, projectName);
        logger.log(Level.INFO, "Wpisany projekt pracownika to: {0}", projectName);
        return new TimePanelSteps();
    }

    @Step("Wcisniecie wyswietlonego projektu")
    public TimePanelSteps chosePromptedProject() {
        pickedProject.click();
        logger.log(Level.INFO, "Wcisniecie wyswietlonego projektu");
        return new TimePanelSteps();
    }

    @Step("Wybranie stanowiska pracy pracownika: {activityType}")
    public TimePanelSteps choseActivity(String activityType) {
        activitySelect.click();
        String fieldGroupSelector = "//span[contains(text(),'" + activityType + "')]";
        WebElement chosenActivity = DriverPicker.driverSetup().findElement(By.xpath(fieldGroupSelector));
        Wait.waitTillElementIsPresent(chosenActivity);
        logger.log(Level.INFO, "Wybranie stanowiska pracy pracownika: {0} ", activityType);
        chosenActivity.click();
        logger.log(Level.INFO, "Wcisniecie stanowiska pracy pracownika: {0} ", activityType);
        return new TimePanelSteps();
    }

    @Step("Dodanie {hours} godzin pracy dla {days} dni roboczych")
    public TimePanelSteps setWorkedHours(String hours, int days) {
        for (int i = 3; i < 3 + days; i++) {
            String dayLabelSelector = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr[1]/td[" + i + "]/div[1]/div[2]/input[1]";
            WebElement dayLabel = DriverPicker.driverSetup().findElement(By.xpath(dayLabelSelector));
            RepeatedActions.deletingAndAddingContentToLabel(dayLabel, hours);
            logger.log(Level.INFO, "Dodanie godzin pracy: {0} ", hours);
            logger.log(Level.INFO, "Dodanie godzin pracy dla: {0} dni roboczych", days);
        }
        return new TimePanelSteps();
    }

    @Step("Zresetowanie raportu godzin")
    public TimePanelSteps resetHoursReport() {
        deleteReportButton.click();
        logger.log(Level.INFO, "Zresetowanie raportu godzin");
        return new TimePanelSteps();
    }
}
