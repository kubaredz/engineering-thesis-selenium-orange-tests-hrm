package tests;

import helpers.PasswordGenerator;
import helpers.UserDataGenerator;
import org.testng.annotations.Test;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;
import steps.options.PimPanelSteps;

import static org.testng.Assert.assertTrue;

public class CommonTests extends TestBase{

    @Test
    public void loginAsAdministratorToOrangeHrmAppTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        DashboardSteps dashboardSteps = new DashboardSteps();
        assertTrue(dashboardSteps.isHrmLogoAfterLoginDisplayed());
    }

    @Test
    public void addNewUserToOrangeHrmAppTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();
        String password = PasswordGenerator.generate(10);

        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickPimPanelSection()
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
}
