package tests;

import io.qameta.allure.*;
import org.testng.annotations.*;
import org.testng.xml.dom.Tag;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class LoginPageTests extends TestNgSteps {
    private LoginPageSteps loginPageSteps;
    private DashboardSteps dashboardSteps;

    @Test
    @Story("PI-37")
    @Tag(name = "FUNCTIONAL")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-37")
    @Description("Weryfikacja tytulu strony OrangeHRM")
    public void verifyPageTitleTest() {
        loginPageSteps = new LoginPageSteps();
        assertEquals(loginPageSteps.getPageTitle(), "OrangeHRM");
    }

    @Test
    @Story("PI-37")
    @Tag(name = "FUNCTIONAL")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-37")
    @Description("Weryfikacja ze wpisany login uzytkownika jest widoczny w polu username")
    public void verifyLoginIsDisplayedInUserNameFieldTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps.setUserNameField("Admin");

        String userNameField = loginPageSteps.getUserNameField();
        assertEquals(userNameField, "Admin");
    }

    @Test
    @Story("PI-37")
    @Tag(name = "FUNCTIONAL")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-37")
    @Description("Weryfikacja ze wpisane haslo jest widoczne w polu password")
    public void verifyPasswordIsDisplayedInPassowrdFieldTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps.setPasswordField("admin123");

        String passwordField = loginPageSteps.getPasswordField();
        assertEquals(passwordField, "admin123");
    }

    @Test
    @Story("PI-37")
    @Tag(name = "FUNCTIONAL")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-37")
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM baner z logo jest widoczny")
    public void verifyBannerOfOrangeHrmIsPresentTest() {
        loginPageSteps = new LoginPageSteps();

        assertTrue(loginPageSteps.isHrmBannerDisplayed());
    }

    @Test
    @Story("PI-37")
    @Tag(name = "FUNCTIONAL")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-37")
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM logo aplikacji jest widoczne")
    public void verifyLogoOfOrangeHrmIsPresentTest() {
        loginPageSteps = new LoginPageSteps();

        assertTrue(loginPageSteps.isHrmLogoDisplayed());
    }

    @Test
    @Story("PI-37")
    @Tag(name = "FUNCTIONAL")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-37")
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM hyperlink 'Forgot your password?' jest widoczny")
    public void verifyHyperlinkForgotYourPasswordIsVisibleTest() {
        loginPageSteps = new LoginPageSteps();

        assertEquals(loginPageSteps.getHyperlinkForgotYourPassword(), "Forgot your password?");
    }

    @Test
    @Story("PI-37")
    @Tag(name = "FUNCTIONAL")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-37")
    @Description("Weryfikacja ze po wcisnieciu hyperlinku 'Forgot your password?' strona przekierowuje na strone z resetowaniem hasla")
    public void verifyHyperlinkForgotYourPasswordTransfersToResetPasswordPageTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps.
                clickForgotYourPasswordHyperlink();

        String forgotYourPasswordPageUrl = loginPageSteps.getCurrentPageUrl();
        assertEquals(forgotYourPasswordPageUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
    }

    @Test
    @Story("PI-37")
    @Tag(name = "FUNCTIONAL")
    @Severity(SeverityLevel.MINOR)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-37")
    @Description("Weryfikacja ze po wcisnieciu hyperlinku 'Redirects To The Orange HRM' zostajemy przekierowani na strone producenta")
    public void verifyHyperlinkRedirectsToTheOrangeHrmProducerPageTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps
                .clickProducerPageHyperlink()
                .switchHandledTab(1);

        String currentPageUrl = loginPageSteps.getCurrentPageUrl();
        assertEquals(currentPageUrl, "https://www.orangehrm.com/");
    }

    @Test
    @Story("PI-37")
    @Severity(SeverityLevel.BLOCKER)
    @Tag(name = "FUNCTIONAL & INTEGRATION")
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-37")
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM a nastepnie podaniu: 'loginu', 'hasla' " +
            "oraz wcisnieciu przycisku 'login' strona przekieruje na ekran glowny aplikacji")
    public void asAdministratorTryToLoginWithCorrectLoginAndPasswordTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isHrmLogoAfterLoginDisplayed());
    }

    @Test
    @Story("PI-37")
    @Severity(SeverityLevel.NORMAL)
    @Tag(name = "FUNCTIONAL & INTEGRATION")
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-37")
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM a nastepnie podaniu nieprawidlowego: 'loginu' i 'hasla'" +
            " a nastepnie wcisnieciu przycisku 'login' strona wyswietla informacje o podaniu nieprawidlowych danych")
    public void asUserTryToLoginWithIncorrectLoginAndPasswordTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps
                .setUserNameField("IncorrectLogin")
                .setPasswordField("password")
                .clickLoginButton();

        String invalidCredentialsAlert = loginPageSteps.getInvalidCredentialsAlertText();
        assertEquals(invalidCredentialsAlert, "Invalid credentials");
    }
}