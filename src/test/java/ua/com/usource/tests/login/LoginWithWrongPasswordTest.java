package ua.com.usource.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.usource.common.enums.Pages;
import ua.com.usource.common.enums.UserData;
import ua.com.usource.tests.BaseTest;

/**
 * Check login with wrong password"
 */
public class LoginWithWrongPasswordTest extends BaseTest {

    @Test(priority = 1, description = "Check the user is taken to the correct page after clicking the login link")
    public void checkLoginPageLink() {
        Pages targetPage = Pages.SIGN_IN;

        navigation().openWebsite();
        navigation().navigateTo(targetPage);
        Assert.assertTrue(navigation().isOnPage(targetPage), "User is taken to the wrong page after clicking the login link!");
    }

    @Test(priority = 2, description = "Check login with invalid email")
    public void checkLoginWithUnregisteredEmail() {
        Pages targetPage = Pages.SIGN_IN;
        UserData wrongPasswordUser = UserData.WRONG_PASSWORD;

        login().checkFormVisible().loginAs(wrongPasswordUser);
        Assert.assertTrue(navigation().isOnPage(targetPage), "User is taken to the wrong page after trying to login with wrong password!");
        login().checkCredentialsAlertDisplayed()
                .checkEmailAlertAbsent()
                .checkPasswordAlertAbsent();
    }



}