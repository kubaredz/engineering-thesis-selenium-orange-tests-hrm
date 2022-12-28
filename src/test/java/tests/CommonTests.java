package tests;

import helpers.PasswordGenerator;
import helpers.UserDataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import steps.dashboard.DashboardSteps;
import steps.login_page.LoginPageSteps;
import steps.options.PimPanelSteps;

import static org.testng.Assert.assertTrue;

public class CommonTests extends TestBase {

    @Test
    @Description("Jako administrator zalogowanie sie na stronie: www.opensource-demo.orangehrmlive.com")
    @Severity(SeverityLevel.BLOCKER)
    public void loginAsAdministratorToOrangeHrmAppTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        DashboardSteps dashboardSteps = new DashboardSteps();

        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        assertTrue(dashboardSteps.isHrmLogoAfterLoginDisplayed());
    }

    @Test
    @Description("Jako administrator weryfikacja dodania nowego uzytkownika do systemu Orange HRM")
    @Severity(SeverityLevel.BLOCKER)
    public void addNewUserToOrangeHrmAppTest() {
        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        LoginPageTests loginPageTests = new LoginPageTests();

        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();
        String password = PasswordGenerator.generate(15);

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
}
