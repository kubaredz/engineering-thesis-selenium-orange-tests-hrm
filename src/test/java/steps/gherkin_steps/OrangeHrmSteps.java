package steps.gherkin_steps;

import helpers.UserDataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static properties.PropertiesReader.*;


public class OrangeHrmSteps {

    @Given("Wejscie na strone OrangeHRM")
    public void step_enter_orange_hrm_page() {
        setPropertiesFromFileInSystem();
        DriverPicker.driverSetup();
        PageSetup.setMaximizeOfWindow();
        PageSetup.setImplicitWait();
        PageSetup.setPageUrl();
    }

    @Given("Zalogowanie uzytkownika do strony OrangeHRM")
    public void step_login_registered_user_to_orange_hrm() {
        CommonTests commonTests = new CommonTests();
        commonTests
                .loginAsAdministratorToOrangeHrmAppTest("Admin", "admin123");
    }

    @Given("Wcisniecie przycisku Add")
    public void step_click_add_button() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickAddButton();
    }

    @Given("Wybranie User Role: ([^\"]*)$")
    public void step_set_user_role(String role) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickUserRoleDropdown()
                .chooseUserRole(role);
    }

    @Given("Imie zalogowanego uzytkownika zostaje zaladowane")
    public void step_set_username_label() {
        HeaderSteps headerSteps = new HeaderSteps();
        String loggedUserData = headerSteps.getLoggedUser();

        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setEmployeeNameLabel(loggedUserData)
                .clickEmployeeNameFromList();
    }

    @Given("Login pracownika zostanie wygenerowany")
    public void step_set_username_label_with_generated_data() {
        String generatedUsername = UserDataGenerator.generateUsername();
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setUsernameLabel(generatedUsername);
    }

    @Given("Haslo pracownika to: ([^\"]*)$")
    public void step_set_password_label(String password) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setEmployeePasswordLabel(password);
    }

    @Given("Wpisanie ponownie hasla: ([^\"]*)$")
    public void step_set_repeated_password_label(String repeatedPassword) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setRepeatedPasswordLabel(repeatedPassword);
    }

    @Given("Status pracownika to: ([^\"]*)$")
    public void step_set_employee_status(String status) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickStatusList()
                .choseStatus(status);
    }

    @Given("Podanie loginu uzytkownika: \"([^\"]*)\"$")
    public void step_set_user_name_field(String username) {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField(username);
    }

    @Given("Podanie hasla uzytkownika: \"([^\"]*)\"$")
    public void step_set_user_password_field(String password) {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setPasswordField(password);
    }

    @Given("Wcisniecie przycisku przechodzacego do sekcji PIM-Reports")
    public void step_click_report_button() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickReportButton();
    }

    @Given("Podanie nazwy raportu: ([^\"]*)$")
    public void step_set_report_name(String reportName) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickGeneratedReportName()
                .setReportName(reportName);
    }

    @Given("Wybranie kryterium raportu: ([^\"]*)$")
    public void step_select_report_criterion(String selectedCriteria) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .setSelectionCriteria()
                .pickSelectionCriteria(selectedCriteria);
    }

    @Given("Przycisk plus dla selection criteria zostal wcisniety")
    public void step_click_plus_button_for_criterion() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickPlusButtonForCriteria();
    }

    @Given("Przycisk plus dla display fields zostal wcisniety")
    public void step_click_plus_button_for_display_fields() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickPlusButtonForDisplayFields();
    }

    @Given("Wybranie stopnia naukowego: ([^\"]*)$")
    public void step_set_education_degree(String degree) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickEducationTypeSelect()
                .selectEducationDegree(degree);
    }

    @Given("Pola z sekcji które mają zostać wyświetlone w raporcie to: ([^\"]*)$")
    public void step_set_option_data_group(String dataGroup) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickDisplayFieldsLabel()
                .selectPersonalDataGroup(dataGroup);
    }

    @Given("Wybranie dokladnych danych jakie maja zostac wyswietlone: ([^\"]*)$")
    public void step_set_displayed_field(String displayedField) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickDisplayField()
                .selectPersonalDataGroup(displayedField);
    }

    @Given("Wcisniecie rozwijanej listy: ([^\"]*)$")
    public void step_click_list_from_time_section(String timeSectionList) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .selectButtonFromListInTimeAndClick(timeSectionList);
    }

    @Given("Wybranie opcji z listy: ([^\"]*)$")
    public void step_click_picked_option_from_list(String pickedOption) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.pickOptionFromList(pickedOption);
    }

    @Given("Wcisniecie przycisku: ([^\"]*)$")
    public void step_click_decision_button(String button) {
        CommonSteps commonSteps = new CommonSteps();
        commonSteps
                .clickButtonWithNormalizeSpace(button);
    }

    @Given("Wybranie projektu: ([^\"]*)$")
    public void step_set_project_name(String projectName) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .setProjectName(projectName)
                .chosePromptedProject();
    }

    @Given("Wybranie rodzaju pracy: ([^\"]*)$")
    public void step_set_activity_type(String activityType) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .choseActivity(activityType);
    }

    @Given("Dodanie ([^\"]*) godzin pracy dla ([^\"]*) dni roboczych$")
    public void step_set_worked_hours_and_days(String hours, int days) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .setWorkedHours(hours, days);
    }

    @Given("Zresetowanie raportu")
    public void step_reset_time_report() {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .resetHoursReport();
    }

    @Given("Wygenerowanie nazwy wakatu")
    public void step_generate_vacancy_name() {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setVacancyNameLabel();
    }

    @Given("Podanie typu pracy: ([^\"]*)$")
    public void step_set_job_type(String jobType) {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .clickJobTitleSelect()
                .setJobType(jobType);
    }

    @Given("Dodanie opisu: ([^\"]*)$")
    public void step_set_description(String description) {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setDescription(description);
    }

    @Given("Polecajacy uzytkownik to aktualnie zalogowany uzytkownik")
    public void step_set_hiring_manager_recommendation() {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setHiringManager();
    }

    @Given("Ustawienie ilosci ogloszen: ([^\"]*)$")
    public void step_set_position_number(String positionNumber) {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setPositionNumber(positionNumber);
    }

    @When("Wcisniecie przycisku logowania")
    public void when_click_login_button() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .clickLoginButton();
    }

    @When("Wciskam przycisk z sekcji quick launch przekierowywujacy do ([^\"]*)$")
    public void when_clicking_button_from_section_quick_launch_redirect_to(String section) {
        DashboardSteps dashboardSteps = new DashboardSteps();
        dashboardSteps
                .quickLaunchSectionOptionClick(section);
    }

    @When("Przejscie do sekcji: ([^\"]*)$")
    public void when_enter_to_the_section(String section) {
        CommonSteps commonSteps = new CommonSteps();
        commonSteps
                .generateAndClickSelectorForAllSections(section);
    }

    @When("Przycisk save zostaje wcisniety")
    public void when_click_save_button() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickSaveButton();
    }

    @Then("Sekcja z naglowkiem ([^\"]*) zostala wyswietlona$")
    public void assert_section_with_header_is_displayed(String section) {
        HeaderSteps headerSteps = new HeaderSteps();
        assertEquals(headerSteps.getSectionHeaderText(), section);
    }

    @Then("Ekran glowny aplikacji z logo OrangeHRM zostal wyswietlony")
    public void assert_that_orange_hrm_logo_is_present() {
        DashboardSteps dashboardSteps = new DashboardSteps();
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
        //TODO Tear down (np. after class?)
        DriverPicker.getDriver().close();
        DriverPicker.setDriver(null);
    }
}