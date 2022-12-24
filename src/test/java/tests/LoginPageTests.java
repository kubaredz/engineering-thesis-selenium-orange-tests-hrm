package tests;

import io.qameta.allure.Description;
import org.testng.annotations.*;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class LoginPageTests extends TestBase {

    @Test
    @Description("Weryfikacja ze tytul strony zawiera: OrangeHRM ")
    public void checkPageTitleTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        assertEquals(loginPageSteps.getPageTitle(), "OrangeHRM");
    }

    @Test
    @Description("Weryfikacja ze po wpisaniu loginu jest on widoczny w polu username")
    public void checkThatLoginIsDisplayedInFieldTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.setUserNameField("Admin");

        String userNameField = loginPageSteps.getUserNameField();
        assertEquals(userNameField, "Admin");
    }

    @Test
    @Description("Weryfikacja ze po wpisaniu hasla jest on widoczny w polu password")
    public void checkThatPasswordIsDisplayedInFieldTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.setPasswordField("admin123");

        String passwordField = loginPageSteps.getPasswordField();
        assertEquals(passwordField, "admin123");
    }

    @Test
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM baner jest widoczny")
    public void checkThatBannerOfOrangeHrmIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        assertTrue(loginPageSteps.isHrmBannerDisplayed());
    }

    @Test
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM logo jest widoczne")
    public void checkThatLogoOfOrangeHrmIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        assertTrue(loginPageSteps.isHrmLogoDisplayed());
    }

    @Test
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM hyperlink 'Forgot your password?' jest widoczny")
    public void checkThatHyperlinkForgotYourPasswordIsVisibleTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        assertEquals(loginPageSteps.getHyperlinkForgotYourPassword(), "Forgot your password?");
    }

    @Test
    @Description("Weryfikacja ze po wcisnieciu hyperlinku 'Forgot your password?' zostajemy przeniesieni na strone z resetowaniem hasla")
    public void checkIfHyperlinkForgotYourPasswordTransferToResetPasswordPageTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.clickForgotYourPasswordHyperlink();

        String forgotYourPasswordPageUrl = loginPageSteps.getCurrentPageUrl();
        assertEquals(forgotYourPasswordPageUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
    }

    @Test
    @Description("Weryfikacja ze po wcisnieciu hyperlinku 'Redirects To The Orange HRM' zostajemy przeniesieni na strone producenta")
    public void checkThatHyperlinkRedirectsToTheOrangeHrmProducerPageTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .clickProducerPageHyperlink()
                .switchHandledTab(1);

        String currentPageUrl = loginPageSteps.getCurrentPageUrl();
        assertEquals(currentPageUrl, "https://www.orangehrm.com/");
    }

    @Test
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM a nastepnie podaniu: 'loginu', 'hasla' " +
            "oraz wcisnieciu przycisku 'login' strona przekieruje nas na ekran glowny aplikacji")
    public void asUserTryToLoginWithCorrectLoginAndPasswordTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isHrmLogoAfterLoginDisplayed());
    }

    @Test
    @Description("Weryfikacja ze po wejsciu na strone Orange HRM a nastepnie podaniu nieprawidlowego: 'loginu' i 'hasla'" +
            " a nastepnie wcisnieciu przycisku 'login; strona wyswietli informacje o podaniu nieprawidlowych danych")
    public void asUserTryToLogInWithIncorrectLoginAndPasswordTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("IncorrectLogin")
                .setPasswordField("password")
                .clickLoginButton();

        String invalidCredentialsAlert = loginPageSteps.getInvalidCredentialsAlertText();
        assertEquals(invalidCredentialsAlert, "Invalid credentials");
    }
}
