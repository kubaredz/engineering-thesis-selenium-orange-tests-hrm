package tests;

import helpers.DateGenerator;
import helpers.UserDataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import steps.options.MyInfoSteps;

import static org.testng.Assert.assertTrue;

public class MyInfoTests extends TestBase {

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'My info' przekierowuje do strony 'PIM'")
    @Severity(SeverityLevel.NORMAL)
    public void asAdminMyInfoScreenIsPresentTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        MyInfoSteps myInfoSteps = new MyInfoSteps();
        myInfoSteps.clickMyInfoSection();

        assertTrue(myInfoSteps.isUserManagementSectionDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy moge zmodyfikowac swoje dane osobowe")
    @Severity(SeverityLevel.NORMAL)
    public void asAdminModifyDataOfLoggedUserTest() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        String firstName = UserDataGenerator.generateFirstName();
        String secondName = UserDataGenerator.generateMiddleName();
        String lastName = UserDataGenerator.generateLastName();
        String username = UserDataGenerator.generateUsername();
        String id = UserDataGenerator.generateId();
        String otherId = UserDataGenerator.generateId();
        String driversLicenseNumber = UserDataGenerator.generateDriversLicenseNumber();
        String licenseExpiryDate = DateGenerator.setFutureDate(30);
        String ssn = UserDataGenerator.generateId();
        String sin = UserDataGenerator.generateId();

        MyInfoSteps myInfoSteps = new MyInfoSteps();
        myInfoSteps
                .clickMyInfoSection()
                .clickPersonalDetailsSection()
                .setFirstName(firstName)
                .setMiddleName(secondName)
                .setLastName(lastName)
                .setNicknameLabel(username)
                .setEmployeeIdLabel(id)
                .setEmployeeOtherIdLabel(otherId)
                .setDriversLicenseNumberLabel(driversLicenseNumber)
                .setLicenseExpiryDateLabel(licenseExpiryDate)
                .setSsnNumberLabel(ssn)
                .setSinNumberLabel(sin)
                .setDateOfBirthLabel("1997-10-21")
                .clickFemaleGenderRadioButton()
                .setMilitaryServiceLabel("yes")
                .isSmokerCheckBox()
                .clickNationalitySelect()
                .clickNationality()
                .setMaritalStatusList()
                .setMaritalStatusMarriedLabel()
                .clickSaveButton();

        assertTrue(myInfoSteps.isPositiveAlertDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy moge zmodyfikowac pola w sekcji 'Custom Fields'")
    @Severity(SeverityLevel.TRIVIAL)
    public void asLoggedUserIWantToChangeCustomFields() {
        CommonTests commonTests = new CommonTests();
        commonTests.loginAsAdministratorToOrangeHrmAppTest();

        MyInfoSteps myInfoSteps = new MyInfoSteps();
        myInfoSteps
                .clickMyInfoSection()
                .clickPersonalDetailsSection()
                .clickBloodTypeSection()
                .clickBloodTypeBPlusLabel()
                .clickSecondSaveButton();

        assertTrue(myInfoSteps.isPositiveAlertDisplayed());
    }

}
