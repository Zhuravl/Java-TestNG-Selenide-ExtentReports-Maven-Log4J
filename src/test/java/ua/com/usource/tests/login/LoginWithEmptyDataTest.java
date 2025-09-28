package ua.com.usource.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.usource.common.enums.Pages;
import ua.com.usource.tests.BaseTest;

/**
 * Check login with empty email and password"
 */
public class LoginWithEmptyDataTest extends BaseTest {

    @Test(priority = 1, description = "Check the user is taken to the correct page after clicking the login link")
    public void checkLoginPageLink() {
        Pages targetPage = Pages.SIGN_IN;

        navigation().openWebsite();
        navigation().navigateTo(targetPage);
        Assert.assertTrue(navigation().isOnPage(targetPage), "User is taken to the wrong page after clicking the login link!");
    }

    @Test(priority = 2, description = "Clear Email and Password fields")
    public void clearLoginAndPasswordFields() {
        login().checkFormVisible().clearEmailAndPassword();
        Assert.assertTrue(login().checkEmailFieldValue().isEmpty(), "Email field is not empty after clear it!");
        Assert.assertTrue(login().checkPasswordFieldValue().isEmpty(), "Password field is not empty after clear it!");
    }

    @Test(priority = 3, description = "Check the login form after trying to login with empty data")
    public void checkLoginWithEmptyData() {
        Pages targetPage = Pages.SIGN_IN;

        login().clickLoginButton();
        Assert.assertTrue(navigation().isOnPage(targetPage), "User is taken to the wrong page after trying to login with empty email and password!");
        login().checkEmailAlertDisplayed()
                .checkPasswordAlertDisplayed();
    }

}