package ua.com.usource.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.usource.common.core.helpers.TestDataHelper;
import ua.com.usource.common.enums.Pages;
import ua.com.usource.pages.LoginPage;

public class LoginTests extends BaseTest {

private LoginPage loginPage;

@BeforeMethod
public void setUpTest() {
    navigation().openWebsite();
    navigation().navigateTo(Pages.SIGN_IN);
    loginPage = new LoginPage();
}

    @Test(description = "TC_LOGIN_01: Successful login with valid credentials", priority = 1)
    public void testValidLogin() {
        loginPage.loginAs(TestDataHelper.VALID_EMAIL, TestDataHelper.VALID_PASSWORD);
        Assert.assertTrue(loginPage.isOnDashboardPage(), "User should be redirected to dashboard after successful login");
    }

    @Test(description = "TC_LOGIN_02: Unsuccessful login with non-existent email", priority = 2)
    public void testLoginWithNonExistentEmail() {
        loginPage.loginAs(TestDataHelper.INVALID_EMAIL, TestDataHelper.VALID_PASSWORD);
        Assert.assertTrue(loginPage.isLoginErrorVisible(), "An error message should be displayed");
    }

    @Test(description = "TC_LOGIN_03: Unsuccessful login with incorrect password", priority = 3)
    public void testLoginWithWrongPassword() {
        loginPage.loginAs(TestDataHelper.VALID_EMAIL, TestDataHelper.getRandomString());
        Assert.assertTrue(loginPage.isLoginErrorVisible(), "An error message about incorrect password should be displayed");
    }

    @Test(description = "TC_LOGIN_04: Login with Empty Fields", priority = 4)
    public void testLoginWithEmptyFields() {
        loginPage.submit();
        Assert.assertTrue(loginPage.isLoginErrorVisible(), "An error message about incorrect password should be displayed");
    }

    @Test(description = "TC_LOGIN_05: Invalid email format", priority = 5)
    public void testInvalidEmailFormat() {
        loginPage.enterEmail(TestDataHelper.getRandomString())
                .enterPassword(TestDataHelper.VALID_PASSWORD)
                .submit();
        Assert.assertTrue(loginPage.isLoginErrorVisible(), "An invalid email format message should be displayed");
    }

    @Test(description = "TC_LOGIN_06: Only email filled", priority = 6)
    public void testOnlyEmail() {
        loginPage.enterEmail(TestDataHelper.VALID_EMAIL)
                .submit();
        Assert.assertTrue(loginPage.isLoginErrorVisible(), "An error message about incorrect password should be displayed");
    }

    @Test(description = "TC_LOGIN_07: Only password filled", priority = 7)
    public void testOnlyPassword() {
        loginPage.enterPassword(TestDataHelper.VALID_PASSWORD)
                .submit();
        Assert.assertTrue(loginPage.isLoginErrorVisible(), "An error message about incorrect password should be displayed");
    }
}