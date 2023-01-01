package steps.gherkin_steps;

import browsers.BrowserType;
import helpers.UserDataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import properties.PropertiesReader;
import setup.DriverPicker;
import setup.PageSetup;
import steps.CommonSteps;
import steps.dashboard.DashboardSteps;
import steps.dashboard.HeaderSteps;
import steps.login_page.LoginPageSteps;
import steps.options.AdminPanelSteps;
import steps.options.PimPanelSteps;
import steps.options.RecruitmentPanelSteps;
import steps.options.TimePanelSteps;
import tests.CommonTests;

import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static properties.PropertiesReader.*;


public class OrangeHrmSteps {

    @Given("Wejscie na strone OrangeHRM")
    public void enter_orange_hrm_page() {
        PropertiesReader configurationProperties = new PropertiesReader();
        Properties propertiesFromFile = configurationProperties.configurationFileReader();
        setProperties(propertiesFromFile);
        DriverPicker.driverSetup();
        PageSetup.setMaximizeOfWindow();
        PageSetup.setImplicitWait();
        PageSetup.setPageUrl();
    }

    @Given("Zalogowanie uzytkownika do strony OrangeHRM")
    public void login_registered_user_to_orange_hrm() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest("Admin", "admin123");
    }

    @Given("Wcisniecie przycisku Add")
    public void step_click_add_button() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps.clickAddButton();
    }

    @Given("Wybranie User Role: ([^\"]*)$")
    public void pick_user_role(String role) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickUserRoleDropdown()
                .chooseUserRole(role);
    }

    @Given("Imie zalogowanego uzytkownika zostaje zaladowane")
    public void set_username_label() {
        HeaderSteps headerSteps = new HeaderSteps();
        String loggedUserData = headerSteps.getLoggedUser();

        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setEmployeeNameLabel(loggedUserData)
                .clickEmployeeNameFromList();
    }

    @Given("Login pracownika zostanie wygenerowany")
    public void set_username_login_label() {
        String generatedUsername = UserDataGenerator.generateUsername();
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setUsernameLabel(generatedUsername);
    }

    @Given("Haslo pracownika to: ([^\"]*)$")
    public void set_password_label(String password) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setEmployeePasswordLabel(password);
    }

    @Given("Wpisanie ponownie hasla: ([^\"]*)$")
    public void set_confirm_password_label(String password) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setEmployeeConfirmPasswordLabel(password);
    }

    @Given("Status pracownika to: ([^\"]*)$")
    public void set_status_of_employee(String status) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickStatusList()
                .choseStatus(status);
    }

    @Given("Podanie loginu uzytkownika: \"([^\"]*)\"$")
    public void setting_user_name_field(String login) {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.setUserNameField(login);
    }

    @Given("Podanie hasla uzytkownika: \"([^\"]*)\"$")
    public void setting_user_password_field(String password) {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.setPasswordField(password);
    }

    @Given("Wcisniecie przycisku dla Reports")
    public void click_reports_button() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps.clickReportsButton();
    }

    @Given("Podanie nazwy raportu: ([^\"]*)$")
    public void entering_name_for_report(String reportName) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        String generatedReportName = reportName + UserDataGenerator.generateId();
        pimPanelSteps.setReportName(reportName + generatedReportName);
    }

    @Given("Wybranie kryterium raportu: ([^\"]*)$")
    public void pay_grade_rating_set(String reportName) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps.setSelectionCriteria();
        pimPanelSteps.pickSelectionCriteria(reportName);
    }

    @Given("Przycisk plus dla selection criteria zostal wcisniety")
    public void click_plus_button_for_criteria() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps.clickPlusButtonForCriteria();
    }

    @Given("Przycisk plus dla display fields zostal wcisniety")
    public void click_plus_button_for_display_fields() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps.clickPlusButtonForDisplayFields();
    }

    @Given("Wybranie stopnia naukowego: ([^\"]*)$")
    public void pick_education_degree(String degree) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickEducationTypeSelect()
                .selectEducationDegree(degree);
    }

    @Given("Pola z sekcji które mają zostać wyświetlone w raporcie to: ([^\"]*)$")
    public void pick_select_option_data_group(String fieldGroup) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickDisplayFieldsLabel()
                .selectPersonalDataGroup(fieldGroup);
    }

    @Given("Wybranie dokladnych danych jakie maja zostac wyswietlone: ([^\"]*)$")
    public void pick_displayed_field(String displayedField) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickDisplayField()
                .selectDisplayField(displayedField);
    }

    @Given("Wcisniecie rozwijanej listy: ([^\"]*)$")
    public void click_list_from_time_section(String listButton) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.selectButtonFromListInTimeAndClick(listButton);
    }

    @Given("Wybranie opcji z listy: ([^\"]*)$")
    public void click_picked_option_from_list(String option) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.pickOptionFromList(option);
    }

    @Given("Wcisniecie przycisku: ([^\"]*)$")
    public void click_button_on_my_timesheet_section(String button) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.clickButtonWithNormalizeSpace(button);
    }

    @Given("Wybranie projektu: ([^\"]*)$")
    public void set_project_name(String projectName) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .setProjectName(projectName)
                .chosePromptedProject();
    }

    @Given("Wybranie rodzaju pracy: ([^\"]*)$")
    public void set_activity(String activityType) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.choseActivity(activityType);
    }

    @Given("Dodanie ([^\"]*) godzin pracy dla ([^\"]*) dni roboczych$")
    public void set_worked_hours(String hours, int days) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.setWorkedHours(hours, days);
    }

    @Given("Zresetowanie raportu")
    public void click_delete_report_button() {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.clickDeleteReportButton();
    }

    @Given("Wygenerowanie nazwy wakatu")
    public void set_vacancy_name() {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps.setVacancyNameLabel();
    }

    @Given("Podanie typu pracy: ([^\"]*)$")
    public void set_job_title(String jobTitle) {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .clickJobTitleSelect()
                .pickJobTitle(jobTitle);
    }

    @Given("Dodanie opisu: ([^\"]*)$")
    public void set_description(String description) {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setDescription(description);
    }

    @Given("Polecajacy uzytkownik to aktualnie zalogowany uzytkownik")
    public void set_hiring_manager() {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setHiringManager();
    }

    @Given("Ustawienie ilosci ogloszen: ([^\"]*)$")
    public void set_number_of_position(String positionNumber) {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setNumberOfPosition(positionNumber);
    }

    @When("Wcisniecie przycisku logowania")
    public void click_login_button() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.clickLoginButton();
    }

    @When("Wciskam przycisk z sekcji quick launch przekierowywujacy do ([^\"]*)$")
    public void step_clicking_button_from_section_quick_launch_redirect_to(String section) {
        DashboardSteps dashboardSteps = new DashboardSteps();
        dashboardSteps.quickLaunchSectionOptionClick(section);
    }

    @When("Przejscie do sekcji: ([^\"]*)$")
    public void enter_to_the_section(String section) {
        CommonSteps commonSteps = new CommonSteps();
        commonSteps.generateAndClickSelectorForAllSections(section);
    }

    @When("Przycisk save zostaje wcisniety")
    public void click_save_button() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps.clickSaveButton();
    }

    @Then("Sekcja z naglowkiem ([^\"]*) zostala wyswietlona$")
    public void assert_section_with_header_is_displayed(String section) {
        HeaderSteps headerSteps = new HeaderSteps();
        assertEquals(headerSteps.getSectionHeaderText(), section);
    }

    @Then("Ekran glowny aplikacji z logo OrangeHRM zostal wyswietlony")
    public void assert_that_orange_hrm_logo_is_present() {
        DashboardSteps dashboardSteps = new DashboardSteps();
        dashboardSteps.isHrmLogoAfterLoginDisplayed();
        assertTrue(dashboardSteps.isHrmLogoAfterLoginDisplayed());
    }

    @Then("Strona z ([^\"]*) zostala zaladowana$")
    public void assert_page_with_url_is_displayed(String url) {
        CommonSteps commonSteps = new CommonSteps();
        String actualAddress = commonSteps.getSectionUrlAddress();
        assertTrue(actualAddress.contains(url));
    }

    @Then("Alert sukces zostal wyswietlony")
    public void assert_alert_success_is_displayed() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        Assert.assertTrue(adminPanelSteps.isPositiveAlertDisplayed());
    }

    @Then("Strona User Management zostala zaladowana")
    public void assert_user_management_is_present() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        Assert.assertTrue(adminPanelSteps.isSystemUsersTextDisplayed());
    }

    @Then("Strona po przeladowaniu wyswietla informacje \"Invalid credentials\"")
    public void assert_page_after_reload_is_displaying_information_invalid_credentials() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();

        String invalidCredentialsAlert = loginPageSteps.getInvalidCredentialsAlertText();

        assertEquals(invalidCredentialsAlert, "Invalid credentials");
    }

    @Then("Zamkniecie przegladarki")
    public void close_browser() {
        DriverPicker.getDriver().close();
        if (getProperties().getProperty("browserType").equals(BrowserType.FIREFOX)){
            DriverPicker.getDriver().quit();
        }
        DriverPicker.setDriver(null);
    }

}