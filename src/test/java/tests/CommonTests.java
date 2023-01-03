package tests;

import helpers.PasswordGenerator;
import helpers.UserDataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.dashboard.DashboardSteps;
import steps.dashboard.HeaderSteps;
import steps.login_page.LoginPageSteps;
import steps.options.PimPanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CommonTests extends TestBase {

    @Test
    @Description("Jako administrator zalogowanie sie na stronie: www.opensource-demo.orangehrmlive.com")
    @Severity(SeverityLevel.BLOCKER)
    @Parameters({"login", "password"})
    public void loginAsAdministratorToOrangeHrmAppTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        DashboardSteps dashboardSteps = new DashboardSteps();

        loginPageSteps
                .setUserNameField(login)
                .setPasswordField(password)
                .clickLoginButton();

        assertTrue(dashboardSteps.isHrmLogoAfterLoginDisplayed());
    }

    @Test
    @Description("Jako administrator weryfikacja dodania nowego uzytkownika do systemu Orange HRM")
    @Severity(SeverityLevel.BLOCKER)
    public void addNewUserToOrangeHrmAppTest() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        LoginPageTests loginPageTests = new LoginPageTests();

        loginPageTests.asAdministratorTryToLoginWithCorrectLoginAndPasswordTest();
        String password = PasswordGenerator.generatePassword(15);

        pimPanelSteps
                .clickPanelSection()
                .clickAddButton()
                .setUploadImageButton("C:\\Users\\kubar\\avatar.jpg")
                .setFirstNameLabel(UserDataGenerator.generateFirstName())
                .setMiddleNameLabel(UserDataGenerator.generateMiddleName())
                .setLastNameLabel(UserDataGenerator.generateLastName())
                .clickLoginDetailsCheckBox()
                .setUsernameLabel(UserDataGenerator.generateUsername())
                .clickStatusEnabledRadioButton()
                .setPasswordLabel(password)
                .setConfirmPasswordLabel(password)
                .clickSaveButton();

        assertTrue(pimPanelSteps.isSuccessPopupDisplayed());
    }

    @Test
    @Description("Jako administrator weryfikacja dodania nowego uzytkownika do systemu Orange HRM a nastepnie zalogowanie sie na niego")
    @Severity(SeverityLevel.BLOCKER)
    public void addNewUserToSystemAndLoginOnHimTest() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        LoginPageTests loginPageTests = new LoginPageTests();

        loginPageTests.asAdministratorTryToLoginWithCorrectLoginAndPasswordTest();

        String generatedFirstName = UserDataGenerator.generateFirstName();
        String generatedLastName = UserDataGenerator.generateLastName();
        String generatedUsername = UserDataGenerator.generateUsername();
        String generatedPassword = PasswordGenerator.generatePassword(15);
        pimPanelSteps
                .clickPanelSection()
                .clickAddButton()
                .setUploadImageButton("C:\\Users\\kubar\\avatar.jpg")
                .setFirstNameLabel(generatedFirstName)
                .setMiddleNameLabel(UserDataGenerator.generateMiddleName())
                .setLastNameLabel(generatedLastName)
                .clickLoginDetailsCheckBox()
                .setUsernameLabel(generatedUsername)
                .clickStatusEnabledRadioButton()
                .setPasswordLabel(generatedPassword)
                .setConfirmPasswordLabel(generatedPassword)
                .clickSaveButton();

        assertTrue(pimPanelSteps.isSuccessPopupDisplayed());

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps
                .clickDropdownButton()
                .clickLogoutButton();

        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField(generatedUsername)
                .setPasswordField(generatedPassword)
                .clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();

        assertTrue(dashboardSteps.isHrmLogoAfterLoginDisplayed());

        assertEquals(headerSteps.getLoggedUser(), generatedFirstName + " " + generatedLastName);

    }
}
