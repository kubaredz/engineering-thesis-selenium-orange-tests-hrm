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
    public void stepEnterOrangeHrmPage() {
        setPropertiesFromFileInSystem();
        DriverPicker.driverSetup();
        PageSetup.setMaximizeOfWindow();
        PageSetup.setImplicitWait();
        PageSetup.setPageUrl();
    }

    @Given("Zalogowanie uzytkownika do strony OrangeHRM")
    public void stepLoginRegisteredUserToOrangeHrm() {
        CommonTests commonTests = new CommonTests();
        commonTests
                .loginAsAdministratorToOrangeHrmAppTest("Admin", "admin123");
    }

    @Given("Wcisniecie przycisku Add")
    public void stepClickAddButton() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickAddButton();
    }

    @Given("Wybranie User Role: ([^\"]*)$")
    public void stepSetUserRole(String role) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickUserRoleDropdown()
                .chooseUserRole(role);
    }

    @Given("Imie zalogowanego uzytkownika zostaje zaladowane")
    public void stepSetUsernameLabel() {
        HeaderSteps headerSteps = new HeaderSteps();
        String loggedUserData = headerSteps.getLoggedUser();

        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setEmployeeNameLabel(loggedUserData)
                .clickEmployeeNameFromList();
    }

    @Given("Login pracownika zostanie wygenerowany")
    public void stepSetUsernameLabelWithGeneratedData() {
        String generatedUsername = UserDataGenerator.generateUsername();
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setUsernameLabel(generatedUsername);
    }

    @Given("Haslo pracownika to: ([^\"]*)$")
    public void stepSetPasswordLabel(String password) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setEmployeePasswordLabel(password);
    }

    @Given("Wpisanie ponownie hasla: ([^\"]*)$")
    public void stepSetRepeatedPasswordLabel(String repeatedPassword) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .setRepeatedPasswordLabel(repeatedPassword);
    }

    @Given("Status pracownika to: ([^\"]*)$")
    public void stepSetEmployeeStatus(String status) {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickStatusList()
                .choseStatus(status);
    }

    @Given("Podanie loginu uzytkownika: \"([^\"]*)\"$")
    public void stepSetUserNameField(String username) {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField(username);
    }

    @Given("Podanie hasla uzytkownika: \"([^\"]*)\"$")
    public void stepSetUserPasswordField(String password) {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setPasswordField(password);
    }

    @Given("Wcisniecie przycisku przechodzacego do sekcji PIM-Reports")
    public void stepClickReportButton() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickReportButton();
    }

    @Given("Podanie nazwy raportu: ([^\"]*)$")
    public void stepSetReportName(String reportName) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickGeneratedReportName()
                .setReportName(reportName);
    }

    @Given("Wybranie kryterium raportu: ([^\"]*)$")
    public void stepSelectReportCriterion(String selectedCriteria) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .setSelectionCriteria()
                .pickSelectionCriteria(selectedCriteria);
    }

    @Given("Przycisk plus dla selection criteria zostal wcisniety")
    public void stepClickPlusButtonForCriterion() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickPlusButtonForCriteria();
    }

    @Given("Przycisk plus dla display fields zostal wcisniety")
    public void stepClickPlusButtonForDisplayFields() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickPlusButtonForDisplayFields();
    }

    @Given("Wybranie stopnia naukowego: ([^\"]*)$")
    public void stepSetEducationDegree(String degree) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickEducationTypeSelect()
                .selectEducationDegree(degree);
    }

    @Given("Pola z sekcji które mają zostać wyświetlone w raporcie to: ([^\"]*)$")
    public void stepSetOptionDataGroup(String dataGroup) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickDisplayFieldsLabel()
                .selectPersonalDataGroup(dataGroup);
    }

    @Given("Wybranie dokladnych danych jakie maja zostac wyswietlone: ([^\"]*)$")
    public void stepSetDisplayedField(String displayedField) {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickDisplayField()
                .selectPersonalDataGroup(displayedField);
    }

    @Given("Wcisniecie rozwijanej listy: ([^\"]*)$")
    public void stepClickListFromTimeSection(String timeSectionList) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .selectButtonFromListInTimeAndClick(timeSectionList);
    }

    @Given("Wybranie opcji z listy: ([^\"]*)$")
    public void stepClickPickedOptionFromList(String pickedOption) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps.pickOptionFromList(pickedOption);
    }

    @Given("Wcisniecie przycisku: ([^\"]*)$")
    public void stepClickDecisionButton(String button) {
        CommonSteps commonSteps = new CommonSteps();
        commonSteps
                .clickButtonWithNormalizeSpace(button);
    }

    @Given("Wybranie projektu: ([^\"]*)$")
    public void stepSetProjectName(String projectName) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .setProjectName(projectName)
                .chosePromptedProject();
    }

    @Given("Wybranie rodzaju pracy: ([^\"]*)$")
    public void stepSetActivityType(String activityType) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .clickEmployeeActivity()
                .choseActivity(activityType);
    }

    @Given("Dodanie ([^\"]*) godzin pracy dla ([^\"]*) dni roboczych$")
    public void stepSetWorkedHoursAndDays(String hours, int days) {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .setWorkedHours(hours, days);
    }

    @Given("Zresetowanie raportu")
    public void stepResetTimeReport() {
        TimePanelSteps timePanelSteps = new TimePanelSteps();
        timePanelSteps
                .resetHoursReport();
    }

    @Given("Wygenerowanie nazwy wakatu")
    public void stepGenerateVacancyName() {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setVacancyNameLabel();
    }

    @Given("Podanie typu pracy: ([^\"]*)$")
    public void stepSetJobType(String jobType) {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .clickJobTitleSelect()
                .setJobType(jobType);
    }

    @Given("Dodanie opisu: ([^\"]*)$")
    public void stepSetDescription(String description) {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setDescription(description);
    }

    @Given("Polecajacy uzytkownik to aktualnie zalogowany uzytkownik")
    public void stepSetHiringManagerRecommendation() {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setHiringManager();
    }

    @Given("Ustawienie ilosci ogloszen: ([^\"]*)$")
    public void stepSetPositionNumber(String positionNumber) {
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        recruitmentPanelSteps
                .setPositionNumber(positionNumber);
    }

    @When("Wcisniecie przycisku logowania")
    public void whenClickLoginButton() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .clickLoginButton();
    }

    @When("Wciskam przycisk z sekcji quick launch przekierowywujacy do ([^\"]*)$")
    public void whenClickingButtonFromSectionQuickLaunchRedirectTo(String section) {
        DashboardSteps dashboardSteps = new DashboardSteps();
        dashboardSteps
                .quickLaunchSectionOptionClick(section);
    }

    @When("Przejscie do sekcji: ([^\"]*)$")
    public void whenEnterToTheSection(String section) {
        CommonSteps commonSteps = new CommonSteps();
        commonSteps
                .generateAndClickSelectorForAllSections(section);
    }

    @When("Przycisk save zostaje wcisniety")
    public void whenClickSaveButton() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        adminPanelSteps
                .clickSaveButton();
    }

    @Then("Sekcja z naglowkiem ([^\"]*) zostala wyswietlona$")
    public void assertSectionWithHeaderIsDisplayed(String section) {
        HeaderSteps headerSteps = new HeaderSteps();
        assertEquals(headerSteps.getSectionHeaderText(), section);
    }

    @Then("Ekran glowny aplikacji z logo OrangeHRM zostal wyswietlony")
    public void assertThatOrangeHrmLogoIsPresent() {
        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isHrmLogoAfterLoginDisplayed());
    }

    @Then("Strona z ([^\"]*) zostala zaladowana$")
    public void assertPageWithUrlIsDisplayed(String url) {
        CommonSteps commonSteps = new CommonSteps();
        String actualAddress = commonSteps.getSectionUrlAddress();
        assertTrue(actualAddress.contains(url));
    }

    @Then("Alert sukces zostal wyswietlony")
    public void assertAlertSuccessIsDisplayed() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        assertTrue(adminPanelSteps.isPositiveAlertDisplayed());
    }

    @Then("Alert sukces zostal wyswietlony lub strona edit zostala zaladowana")
    public void assertAlertSuccessIsDisplayedOrEditPageIsLoaded() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        RecruitmentPanelSteps recruitmentPanelSteps = new RecruitmentPanelSteps();
        if (recruitmentPanelSteps.isEditVacancyTextVisible()) {
            assertTrue(recruitmentPanelSteps.isEditVacancyTextVisible());
        } else {
            assertTrue(adminPanelSteps.isPositiveAlertDisplayed());
        }
    }

    @Then("Strona User Management zostala zaladowana")
    public void assertUserManagementIsPresent() {
        AdminPanelSteps adminPanelSteps = new AdminPanelSteps();
        Assert.assertTrue(adminPanelSteps.isSystemUsersTextDisplayed());
    }

    @Then("Strona po przeladowaniu wyswietla informacje \"Invalid credentials\"")
    public void assertPageAfterReloadIsDisplayingInformationInvalidCredentials() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();

        String invalidCredentialsAlert = loginPageSteps.getInvalidCredentialsAlertText();
        assertEquals(invalidCredentialsAlert, "Invalid credentials");
    }

    @Then("Zamkniecie przegladarki")
    public void closeBrowser() {
        DriverPicker.getDriver().close();
        DriverPicker.setDriver(null);
    }
}