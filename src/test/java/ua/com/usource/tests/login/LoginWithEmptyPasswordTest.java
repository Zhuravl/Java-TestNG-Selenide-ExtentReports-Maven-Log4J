package ua.com.usource.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.usource.common.enums.Pages;
import ua.com.usource.common.enums.UserData;
import ua.com.usource.tests.BaseTest;

/**
 * Check login with valid email and empty password"
 */
public class LoginWithEmptyPasswordTest extends BaseTest {

    @Test(priority = 1, description = "Check the user is taken to the correct page after clicking the login link")
    public void checkLoginPageLink() {
        Pages targetPage = Pages.SIGN_IN;

        navigation().openWebsite();
        navigation().navigateTo(targetPage);
        Assert.assertTrue(navigation().isOnPage(targetPage), "User is taken to the wrong page after clicking the login link!");
    }

    @Test(priority = 2, description = "Check login user with empty password")
    public void checkLoginWithEmptyPassword() {
        Pages targetPage = Pages.SIGN_IN;
        UserData empty_pass_user = UserData.EMPTY_PASSWORD;

        login().checkFormVisible().loginAs(empty_pass_user);
        Assert.assertTrue(navigation().isOnPage(targetPage), "User is taken to the wrong page after trying to login with empty password!");
        login().checkEmailAlertAbsent()
                .checkPasswordAlertDisplayed();

    }

}