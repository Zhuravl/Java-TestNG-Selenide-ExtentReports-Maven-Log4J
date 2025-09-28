package ua.com.usource.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.usource.common.enums.Pages;
import ua.com.usource.common.enums.UserData;
import ua.com.usource.tests.BaseTest;

/**
 * Check login with valid email and password"
 */
public class LoginWithValidDataAndLogoutTest extends BaseTest {

    @Test(priority = 1, description = "Check the user is taken to the correct page after clicking the login link")
    public void checkLoginPageLink() {
        Pages targetPage = Pages.SIGN_IN;

        navigation().openWebsite();
        navigation().navigateTo(targetPage);
        Assert.assertTrue(navigation().isOnPage(targetPage), "User is taken to the wrong page after clicking the login link!");
    }

    @Test(priority = 2, description = "Check success login with valid email")
    public void checkLoginWithValidEmail() {
        Pages targetPage = Pages.MAIN;
        UserData validUser = UserData.VALID;

        login().checkFormVisible().loginAs(validUser);
        Assert.assertTrue(navigation().isOnPage(targetPage), "User was not redirected to the home page after login execution!");
        Assert.assertTrue(login().verifyUserProfile(validUser), "User email on profile button after login is incorrect!");
    }

    @Test(priority = 3, description = "Check logout user after success login")
    public void checkLogout() {
        Pages targetPage = Pages.SIGN_IN;

        login().logout();
        Assert.assertTrue(navigation().isOnPage(targetPage), "User is taken to the wrong page after clicking the logout button!");
    }

}