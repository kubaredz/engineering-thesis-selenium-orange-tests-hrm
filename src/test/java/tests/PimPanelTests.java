package tests;

import helpers.UserDataGenerator;
import helpers.PasswordGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import steps.login_page.LoginPageSteps;
import steps.options.PimPanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PimPanelTests extends TestBase {

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'PIM' przekierowuje do strony 'PIM' z lista pracownikow")
    @Severity(SeverityLevel.NORMAL)
    public void asUserICanGoToPimSectionTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps.clickPanelSection();

        assertTrue(pimPanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy sekcja 'Dodawania nowego uzykownika' jest widoczna")
    @Severity(SeverityLevel.CRITICAL)
    public void asUserICanGoToAddNewUserSectionAndItIsPresentTest() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps
                .clickPanelSection()
                .clickAddButton();

        assertTrue(pimPanelSteps.isAddEmployeeTextDisplayed());
        assertEquals(pimPanelSteps.getAddEmployeeText(), "Add Employee");
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja dodania nowego pracownika do systemu 'PIM'")
    @Severity(SeverityLevel.CRITICAL)
    public void addNewUserInOrangeHrmApplicationTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();
        String password = PasswordGenerator.generate(15);

        PimPanelSteps pimPanelSteps = new PimPanelSteps();
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
