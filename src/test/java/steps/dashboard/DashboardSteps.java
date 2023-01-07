package steps.dashboard;

import builders.dashboard.DashboardPageBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import static setup.DriverPicker.driverSetup;
import static waits.Wait.waitTillElementIsClickableByWebElement;

public class DashboardSteps extends DashboardPageBuilder {

    public DashboardSteps() {
        PageFactory.initElements(driverSetup(), this);
    }

    @Step("Logo strony Orange HRM zostalo wyswietlone")
    public boolean isHrmLogoAfterLoginDisplayed() {
        logger.log(Level.INFO, "Logo: \"OrangeHRM\" po zalogowaniu zostalo wyswietlone");
        return hrmLogoAfterLogin.isDisplayed();
    }

    @Step("Sekcja: 'Time at Work' zostala wyswietlona")
    public boolean isTimeAtWorkSectionPresent() {
        logger.log(Level.INFO, "Sekcja: \"Time at Work\" zostala wyswietlona");
        return timeAtWorkSection.isDisplayed();
    }

    @Step("Sekcja: 'My Actions' zostala wyswietlona")
    public boolean isMyActionsSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"My Actions\" zostala wyswietlona");
        return myActionsSection.isDisplayed();
    }

    @Step("Sekcja: 'Quick Launch' zostala wyswietlona")
    public boolean isQuickLaunchSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Quick Launch\" zostala wyswietlona");
        return quickLaunchSection.isDisplayed();
    }

    @Step("Sekcja: 'Employees On Leave' zostala wyswietlona")
    public boolean isEmployeesOnLeaveSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Employees On Leave\" zostala wyswietlona");
        return employeesOnLeaveSection.isDisplayed();
    }

    @Step("Sekcja: 'Employee Distribution By Sub Unit Leave' zostala wyswietlona")
    public boolean isEmployeeDistributionBySubUnitLeaveSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Employee Distribution By Sub Unit Leave\" zostala wyswietlona");
        return employeeDistributionBySubUnitLeaveSection.isDisplayed();
    }

    @Step("Sekcja: 'Employee Distribution By Location' zostala wyswietlona")
    public boolean isEmployeeDistributionByLocationSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Employee Distribution By Location\" zostala wyswietlona");
        return employeeDistributionByLocationSection.isDisplayed();
    }

    @Step("Pobranie url-a dla danej sekcji z panelu quick launch: {section} i wcisniecie tej sekcji")
    public DashboardSteps clickQuickLaunchSectionOption(String section) {
        String selector = "button[title='section']";
        quickLaunchButton = driverSetup().findElement(By.cssSelector(selector.replace("section", section)));
        waitTillElementIsClickableByWebElement(quickLaunchButton);
        quickLaunchButton.click();
        logger.log(Level.INFO, "Pobranie url-a dla danej sekcji z panelu quick launch: {0} i wcisniecie tej sekcji", section);
        return new DashboardSteps();
    }
}