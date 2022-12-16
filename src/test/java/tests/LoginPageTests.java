package tests;

import org.testng.annotations.*;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class LoginPageTests extends TestBase {

    @Test
    public void checkPageTitleTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();

        assertEquals(loginPageSteps.getPageTitle(), "OrangeHRM");
    }

    @Test
    public void checkThatLoginIsDisplayedInField() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.setUserNameField("Admin");
        String userNameField = loginPageSteps.getUserNameField();
        assertEquals(userNameField, "Admin");

    }

    @Test
    public void checkThatPasswordIsDisplayedInField() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.setPasswordField("admin123");
        String passwordField = loginPageSteps.getPasswordField();
        assertEquals(passwordField, "admin123");
    }

    @Test
    public void checkThatBannerOfOrangeHrmIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        assertTrue(loginPageSteps.isHrmBannerDisplayed());
    }

    @Test
    public void checkThatLogoOfOrangeHrmIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        assertTrue(loginPageSteps.isHrmLogoDisplayed());
    }

    @Test
    public void checkThatHyperlinkForgotYourPasswordIsVisible() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        assertEquals(loginPageSteps.getHyperlinkForgotYourPassword(), "Forgot your password?");
    }

    @Test
    public void checkIfHyperlinkForgotYourPasswordTransferToResetPasswordPage() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.forgotYourPasswordHyperlink.click();
        String forgotYourPasswordPageUrl = loginPageSteps.getCurrentPageUrl();
        assertEquals(forgotYourPasswordPageUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
    }

    @Test
    public void checkThatHyperlinkRedirectsToTheOrangeHrmProducerPage() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();

        loginPageSteps.producerPageHyperlink.click();

        loginPageSteps.switchHandledTab(1);

        String currentPageUrl = loginPageSteps.getCurrentPageUrl();
        assertEquals(currentPageUrl, "https://www.orangehrm.com/");
    }

    @Test
    public void asUserTryToLoginWithCorrectLoginAndPassword() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();

        loginPageSteps.setUserNameField("Admin");

        loginPageSteps.setPasswordField("admin123");

        loginPageSteps.loginButton.click();
        DashboardSteps dashboardSteps = new DashboardSteps();
        dashboardSteps.getHrmLogoAfterLogin();
        assertTrue(dashboardSteps.getHrmLogoAfterLogin().isDisplayed());
    }

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();

        loginPageSteps.setUserNameField("IncorrectLogin");

        loginPageSteps.setPasswordField("password");

        loginPageSteps.loginButton.click();

        String invalidCredentialsAlert = loginPageSteps.getInvalidCredentialsAlert();
        assertEquals(invalidCredentialsAlert, "Invalid credentials");
    }
}
