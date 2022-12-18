package tests;

import helpers.UserDataGenerator;
import helpers.PasswordGenerator;
import org.testng.annotations.Test;
import steps.options.PimPanelSteps;
import waits.Wait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PimPanelTests extends TestBase {

    @Test
    public void asUserICanGoToPimSectionTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();

        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps.clickPimPanelSection();

        assertTrue(pimPanelSteps.isPimSectionDisplayed());
    }

    @Test
    public void asUserICanGoToAddNewUserSectionAndItIsPresentTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();

        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps.clickPimPanelSection();
        pimPanelSteps.clickAddButton();

        assertTrue(pimPanelSteps.isAddEmployeeTextDisplayed());
        assertEquals(pimPanelSteps.getAddEmployeeText(), "Add Employee");
    }

    @Test
    public void addNewUserInOrangeHrmApplicationTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();

        PimPanelSteps pimPanelSteps = new PimPanelSteps();
        pimPanelSteps.clickPimPanelSection();
        pimPanelSteps.clickAddButton();

        Wait.waitTillElementIsPresent(pimPanelSteps.getAddEmployeeButton());

        //TODO
        //add img
        pimPanelSteps.setAddEmployeeButton("C:\\Users\\kubar\\avatar.jpg");

        //set first name
        pimPanelSteps.setFirstNameLabel(UserDataGenerator.generateFirstName());

        //set middle name
        pimPanelSteps.setMiddleNameLabel(UserDataGenerator.generateMiddleName());

        //set last name
        pimPanelSteps.setLastNameLabel(UserDataGenerator.generateLastName());

        //set create login details
        pimPanelSteps.clickLoginDetailsCheckBox();

        //set username
        pimPanelSteps.setUsernameLabel(UserDataGenerator.generateUsername());

        //set status
        pimPanelSteps.clickStatusEnabledRadioButton();

        //set password
        String password = PasswordGenerator.generatePassword();
        pimPanelSteps.setPasswordLabel(password);

        //set confirm password
        pimPanelSteps.setConfirmPasswordLabel(password);

        //click save button
        pimPanelSteps.clickSaveButton();

        assertTrue(pimPanelSteps.isSuccessPopupDisplayed());
    }
}
