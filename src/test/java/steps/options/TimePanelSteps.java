package steps.options;

import builders.options.TimePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;

import java.util.logging.Level;

import static utils.RepeatedActions.deletingAndAddingContentToLabel;
import static waits.Wait.waitTillElementIsPresent;

public class TimePanelSteps extends TimePanelBuilder implements DefaultSteps, CommonSteps {

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
    public CommonSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CommonSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }

    @Step("Imie pracownika: {name} zostalo wpisane")
    public TimePanelSteps setEmployeeName(String name) {
        deletingAndAddingContentToLabel(employeeNameLabel, name);
        logger.log(Level.INFO, "Imie pracownika: \"{0}\" zostalo wpisane", name);
        return new TimePanelSteps();
    }

    @Step("Wybranie wyswietlonego pracownika")
    public TimePanelSteps clickPromptedEmployeeName() {
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

    @Step("Timesheet dla zalogowanego uzytkownika zostal wyswietlony")
    public boolean isTimesheetForLoggedUserDisplayed() {
        logger.log(Level.INFO, "Timesheet dla zalogowanego uzytkownika zostal wyswietlony");
        return timesheetForLoggedUserText.isDisplayed();
    }

    @Step("Pobranie tekstu z naglowka timesheet")
    public String getTimesheetSectionText() {
        String timesheetForLoggedUser = timesheetForLoggedUserText.getText();
        logger.log(Level.INFO, "Pobranie tekstu z naglowka timesheet: {0}", timesheetForLoggedUser);
        return timesheetForLoggedUser;
    }

    @Step("Wybranie oraz wcisniecie przycisku z listy w sekcji Time: {listButton}")
    public TimePanelSteps clickButtonFromListInTimeSection(String listButton) {
        String selector = "//span[normalize-space()='listButton']";
        buttonFromList = DriverPicker.driverSetup().findElement(By.xpath(selector.replace("listButton", listButton)));
        logger.log(Level.INFO, "Wybranie przycisku z listy w sekcji Time: {0} ", listButton);
        buttonFromList.click();
        logger.log(Level.INFO, "Wcisniecie przycisku z listy: {0} ", listButton);
        return new TimePanelSteps();
    }

    @Step("Wybranie opcji z listy: {option}")
    public TimePanelSteps clickOptionFromList(String option) {
        String selector = "//a[contains(text(),'option')]";
        pickedOption = DriverPicker.driverSetup().findElement(By.xpath(selector.replace("option", option)));
        logger.log(Level.INFO, "Wybranie opcji z listy: {0} ", option);
        pickedOption.click();
        logger.log(Level.INFO, "Wcisniecie opcji z listy: {0} ", option);
        return new TimePanelSteps();
    }

    @Step("Wpisany projekt pracownika to: {projectName}")
    public TimePanelSteps setProjectName(String projectName) {
        deletingAndAddingContentToLabel(projectNameLabel, projectName);
        logger.log(Level.INFO, "Wpisany projekt pracownika to: {0}", projectName);
        return new TimePanelSteps();
    }

    @Step("Wcisniecie wyswietlonego projektu")
    public TimePanelSteps clickPromptedProject() {
        pickedProject.click();
        logger.log(Level.INFO, "Wcisniecie wyswietlonego projektu");
        return new TimePanelSteps();
    }

    @Step("Wcisniecie pola dla stanowiska pracy pracownika")
    public TimePanelSteps clickEmployeeActivity() {
        activitySelect.click();
        logger.log(Level.INFO, "Wcisniecie pola dla stanowiska pracy pracownika");
        return new TimePanelSteps();
    }

    @Step("Wybranie stanowiska pracy pracownika: {activityType}")
    public TimePanelSteps chooseActivity(String activityType) {
        String selector = "//span[normalize-space()='activityType']";
        pickedOption = DriverPicker.driverSetup().findElement(By.xpath(selector.replace("activityType", activityType)));
        waitTillElementIsPresent(pickedOption);
        logger.log(Level.INFO, "Wybranie stanowiska pracy pracownika: {0} ", activityType);
        pickedOption.click();
        logger.log(Level.INFO, "Wcisniecie stanowiska pracy pracownika: {0} ", activityType);
        return new TimePanelSteps();
    }

    @Step("Dodanie {hours} godzin pracy dla {days} dni roboczych")
    public TimePanelSteps setWorkedHours(String hours, int days) {
        for (int i = 3; i < 3 + days; i++) {
            String dayLabelSelector = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr[1]/td[index]/div[1]/div[2]/input[1]";
            dayLabel = DriverPicker.driverSetup().findElement((By.xpath(dayLabelSelector.replace("index", Integer.toString(i)))));
            deletingAndAddingContentToLabel(dayLabel, hours);
            logger.log(Level.INFO, "Dodanie godzin pracy: {0} ", hours);
            logger.log(Level.INFO, "Dodanie godzin pracy dla: {0} dni roboczych", days);
        }
        return new TimePanelSteps();
    }

    @Step("Zresetowanie raportu godzin")
    public TimePanelSteps clickResetHoursReportButton() {
        deleteReportButton.click();
        logger.log(Level.INFO, "Zresetowanie raportu godzin");
        return new TimePanelSteps();
    }
}