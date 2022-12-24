package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class HeaderTests extends TestBase {

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy na rozwijanym panelu uzytkownika wszystkie pola sa widoczne")
    public void verifyThatUserDropDownListHasAllNecessaryFieldsTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.clickDropdownButton();

        List<WebElement> listOfLinksElements = headerSteps.getDropdownMenu().findElements(By.tagName("li"));
        List<String> listOfElementsInUserDropDownList = new ArrayList<>();
        for (int i = 0; i < listOfLinksElements.size(); i++) {
            listOfElementsInUserDropDownList.add(listOfLinksElements.get(i).getText());
        }
        List<String> listOfExpectedOptions = new ArrayList<>();
        listOfExpectedOptions.add("About");
        listOfExpectedOptions.add("Support");
        listOfExpectedOptions.add("Change Password");
        listOfExpectedOptions.add("Logout");

        assertEquals(listOfExpectedOptions, listOfElementsInUserDropDownList);
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy po kliknieciu opcji 'About' przenosi ona do sekcji 'About")
    public void verifyThatAboutOptionHasAllNecessaryInformationTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.clickDropdownButton();

        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("About")) {
                option.click();
                assertEquals(headerSteps.getAboutSection().getText(), "About");
            }
        }
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy po kliknieciu opcji 'Support' przenosi ona do do strony 'Support'")
    public void verifyThatSupportOptionTransferToSupportPageTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.clickDropdownButton();

        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("Support")) {
                //TODO
                option.click();
                assertEquals(headerSteps.getPageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/help/support");
            }
        }
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy po kliknieciu opcji 'Change Password' przenosi ona do do strony zmiany hasla")
    public void verifyThatChangePasswordOptionRedirectToChangePasswordPageTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.clickDropdownButton();

        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("Change Password")) {
                //TODO
                option.click();
                assertEquals(headerSteps.getPageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/updatePassword");
            }
        }
    }

    @Test
    @Description("Jako zalogowany administrator, weryfikacja czy po kliknieciu opcji 'Logout' wylogowywuje uzytkownika oraz przechodzi do strony logowania")
    public void verifyThatLogoutOptionLogsOutUserTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPasswordTest();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.clickDropdownButton();
        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("Change Password")) {
                //TODO
                option.click();
                assertEquals(headerSteps.getPageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            }
        }
    }
}