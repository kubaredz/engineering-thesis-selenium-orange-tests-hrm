package tests;

import helpers.UserDataGenerator;
import helpers.PasswordGenerator;
import org.testng.annotations.Test;
import steps.login_page.LoginPageSteps;
import steps.options.PimPanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PimPanelTests extends TestBase {

    @Test
    public void asUserICanGoToPimSectionTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps.clickPimPanelSection();

        assertTrue(pimPanelSteps.isPimSectionDisplayed());
    }

    @Test
    public void asUserICanGoToAddNewUserSectionAndItIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickPimPanelSection()
                .clickAddButton();

        assertTrue(pimPanelSteps.isAddEmployeeTextDisplayed());
        assertEquals(pimPanelSteps.getAddEmployeeText(), "Add Employee");
    }

    @Test
    public void addNewUserInOrangeHrmApplicationTest() {
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
