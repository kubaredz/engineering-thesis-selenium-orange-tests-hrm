package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class HeaderTests extends TestNgSteps {

    @Test
    @Story("PI-35")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-35")
    @Description("Jako zalogowany administrator, weryfikacja czy na rozwijanym panelu uzytkownika wszystkie pola sa widoczne")
    public void verifyUserDropDownListHasAllNecessaryFieldsTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asAdministratorTryToLoginWithCorrectLoginAndPasswordTest();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.clickDropdownButton();

        List<WebElement> listOfLinksElements = headerSteps.getDropdownMenu().findElements(By.tagName("li"));
        List<String> listOfElementsInUserDropDownList = new ArrayList<>();
        for (WebElement listOfLinksElement : listOfLinksElements) {
            listOfElementsInUserDropDownList.add(listOfLinksElement.getText());
        }
        List<String> listOfExpectedOptions = new ArrayList<>();
        listOfExpectedOptions.add("About");
        listOfExpectedOptions.add("Support");
        listOfExpectedOptions.add("Change Password");
        listOfExpectedOptions.add("Logout");

        assertEquals(listOfExpectedOptions, listOfElementsInUserDropDownList);
    }

    @Test
    @Story("PI-35")
    @Severity(SeverityLevel.TRIVIAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-35")
    @Description("Jako zalogowany administrator, weryfikacja czy po kliknieciu przycisku 'About' przenosi on do sekcji 'About")
    public void verifyAboutOptionHasAllNecessaryInformationTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asAdministratorTryToLoginWithCorrectLoginAndPasswordTest();

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
    @Story("PI-35")
    @Severity(SeverityLevel.MINOR)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-35")
    @Description("Jako zalogowany administrator, weryfikacja czy po kliknieciu przycisku 'Support' przenosi on do strony 'Support'")
    public void verifySupportButtonTransfersToSupportPageTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asAdministratorTryToLoginWithCorrectLoginAndPasswordTest();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.clickDropdownButton();

        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("Support")) {
                option.click();
                assertEquals(headerSteps.getPageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/help/support");
            }
        }
    }

    @Test
    @Story("PI-35")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-35")
    @Description("Jako zalogowany administrator, weryfikacja czy po kliknieciu przycisku 'Change Password' przenosi on do strony zmiany hasla")
    public void verifyChangePasswordButtonRedirectsToChangePasswordPageTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asAdministratorTryToLoginWithCorrectLoginAndPasswordTest();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.clickDropdownButton();

        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("Change Password")) {
                option.click();
                assertEquals(headerSteps.getPageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/updatePassword");
            }
        }
    }

    @Test
    @Story("PI-35")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-35")
    @Description("Jako zalogowany administrator, weryfikacja czy po kliknieciu przycisku 'Logout' wylogowywuje on uzytkownika oraz przechodzi do strony logowania")
    public void verifyLogoutButtonLogsOutUserTest() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asAdministratorTryToLoginWithCorrectLoginAndPasswordTest();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.clickDropdownButton();

        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("Logout")) {
                option.click();
                assertEquals(headerSteps.getPageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            }
        }
    }
}