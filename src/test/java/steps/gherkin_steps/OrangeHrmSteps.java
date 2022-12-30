package steps.gherkin_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import properties.ConfigurationProperties;
import setup.DriverManager;
import setup.PageSetup;
import steps.dashboard.DashboardSteps;
import steps.dashboard.HeaderSteps;
import steps.login_page.LoginPageSteps;
import tests.CommonTests;

import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class OrangeHrmSteps {

    @Given("Wejscie na strone OrangeHRM")
    public void enter_orange_hrm_page() {
        ConfigurationProperties configurationProperties = new ConfigurationProperties();
        Properties propertiesFromFile = configurationProperties.configurationFileReader();
        ConfigurationProperties.setProperties(propertiesFromFile);
        DriverManager.driverSetup();
        PageSetup.setMaximizeOfWindow();
        PageSetup.setImplicitWait();
        PageSetup.setPageUrl();
    }

    @Given("Zalogowanie uzytkownika do strony OrangeHRM")
    public void login_registered_user_to_orange_hrm() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest("Admin", "admin123");
    }

    @When("Podanie loginu uzytkownika: \"([^\"]*)\"$")
    public void setting_user_name_field(String login) {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.setUserNameField(login);
    }

    @When("Podanie hasla uzytkownika: \"([^\"]*)\"$")
    public void setting_user_password_field(String password) {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.setPasswordField(password);
    }

    @When("Wcisniecie przycisku logowania")
    public void clicking_login_button() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.clickLoginButton();
    }

    @When("Przejscie do wcisnietej sekcji: ([^\"]*)$")
    public void enter_to_the_section(String section) {
        DashboardSteps dashboardSteps = new DashboardSteps();
        dashboardSteps.generateAndClickSelectorForAllSections(section);
    }

    @When("Wciskam przycisk z sekcji quick launch przekierowywujacy do ([^\"]*)$")
    public void step_clicking_button_from_section_quick_launch_redirect_to(String section) {
        DashboardSteps dashboardSteps = new DashboardSteps();
        dashboardSteps.quickLaunchSectionOptionClick(section);
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
        DashboardSteps dashboardSteps = new DashboardSteps();
        String actualAddress = dashboardSteps.getSectionUrlAddress(url);

        assertTrue(actualAddress.contains(url));

    }

    @Then("Zamkniecie przegladarki")
    public void close_browser() {
        DriverManager.extinctionDriver();
    }

}