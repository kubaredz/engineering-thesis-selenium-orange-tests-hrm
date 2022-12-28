package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class LoginPageTests extends TestBase {
    private LoginPageSteps loginPageSteps;
    private DashboardSteps dashboardSteps;

    @Test
    @Description("Weryfikacja ze tytul strony zawiera: OrangeHRM ")
    @Severity(SeverityLevel.NORMAL)
    public void checkPageTitleTest() {
        loginPageSteps = new LoginPageSteps();
        assertEquals(loginPageSteps.getPageTitle(), "OrangeHRM");
    }

    @Test
    @Description("Weryfikacja ze po wpisaniu loginu jest on widoczny w polu username")
    @Severity(SeverityLevel.NORMAL)
    public void checkThatLoginIsDisplayedInFieldTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps.setUserNameField("Admin");

        String userNameField = loginPageSteps.getUserNameField();
        assertEquals(userNameField, "Admin");
    }

    @Test
    @Description("Weryfikacja ze po wpisaniu hasla jest on widoczny w polu password")
    @Severity(SeverityLevel.NORMAL)
    public void checkThatPasswordIsDisplayedInFieldTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps.setPasswordField("admin123");

        String passwordField = loginPageSteps.getPasswordField();
        assertEquals(passwordField, "admin123");
    }

    @Test
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM baner jest widoczny")
    @Severity(SeverityLevel.NORMAL)
    public void checkThatBannerOfOrangeHrmIsPresentTest() {
        loginPageSteps = new LoginPageSteps();

        assertTrue(loginPageSteps.isHrmBannerDisplayed());
    }

    @Test
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM logo jest widoczne")
    @Severity(SeverityLevel.NORMAL)
    public void checkThatLogoOfOrangeHrmIsPresentTest() {
        loginPageSteps = new LoginPageSteps();

        assertTrue(loginPageSteps.isHrmLogoDisplayed());
    }

    @Test
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM hyperlink 'Forgot your password?' jest widoczny")
    @Severity(SeverityLevel.NORMAL)
    public void checkThatHyperlinkForgotYourPasswordIsVisibleTest() {
        loginPageSteps = new LoginPageSteps();

        assertEquals(loginPageSteps.getHyperlinkForgotYourPassword(), "Forgot your password?");
    }

    @Test
    @Description("Weryfikacja ze po wcisnieciu hyperlinku 'Forgot your password?' zostajemy przeniesieni na strone z resetowaniem hasla")
    @Severity(SeverityLevel.NORMAL)
    public void checkIfHyperlinkForgotYourPasswordTransferToResetPasswordPageTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps.clickForgotYourPasswordHyperlink();

        String forgotYourPasswordPageUrl = loginPageSteps.getCurrentPageUrl();
        assertEquals(forgotYourPasswordPageUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
    }

    @Test
    @Description("Weryfikacja ze po wcisnieciu hyperlinku 'Redirects To The Orange HRM' zostajemy przeniesieni na strone producenta")
    @Severity(SeverityLevel.MINOR)
    public void checkThatHyperlinkRedirectsToTheOrangeHrmProducerPageTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps
                .clickProducerPageHyperlink()
                .switchHandledTab(1);

        String currentPageUrl = loginPageSteps.getCurrentPageUrl();
        assertEquals(currentPageUrl, "https://www.orangehrm.com/");
    }

    @Test
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM a nastepnie podaniu: 'loginu', 'hasla' " +
            "oraz wcisnieciu przycisku 'login' strona przekieruje nas na ekran glowny aplikacji")
    @Severity(SeverityLevel.BLOCKER)
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
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM a nastepnie podaniu nieprawidlowego: 'loginu' i 'hasla'" +
            " a nastepnie wcisnieciu przycisku 'login; strona wyswietli informacje o podaniu nieprawidlowych danych")
    @Severity(SeverityLevel.NORMAL)
    public void asUserTryToLogInWithIncorrectLoginAndPasswordTest() {
        loginPageSteps = new LoginPageSteps();

        loginPageSteps
                .setUserNameField("IncorrectLogin")
                .setPasswordField("password")
                .clickLoginButton();

        String invalidCredentialsAlert = loginPageSteps.getInvalidCredentialsAlertText();
        assertEquals(invalidCredentialsAlert, "Invalid credentials");
    }
}
