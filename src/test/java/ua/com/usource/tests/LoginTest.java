package ua.com.usource.tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import ua.com.usource.actions.LoginActions;
import ua.com.usource.elements.LoginElements;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {
    private static final String VALID_EMAIL    = "loginer@usource.com.ua";
    private static final String VALID_PASSWORD = "TY#pUEcGz7nN%b";

    @Test(priority = 1, description = "Empty fields")
    public void emptyCredentialsTest() {
        open("https://usource.com.ua/login");
        LoginActions.clickLoginButton();
        LoginElements.EMAIL_REQUIRED.shouldBe(Condition.visible);
        LoginElements.PASSWORD_REQUIRED.shouldBe(Condition.visible);
    }

    @Test(priority = 2, description = "Set data to email field, password still empty")
    public void passwordMessageDisappeared() {
        LoginActions.enterCredentials(VALID_EMAIL, "");
        LoginActions.clickLoginButton();
        LoginElements.EMAIL_REQUIRED.shouldNotBe(Condition.visible);
        LoginElements.PASSWORD_REQUIRED.shouldBe(Condition.visible);

    }

    @Test(priority = 3, description = "Invalid password")
    public void invalidPasswordTest() {
        LoginActions.enterCredentials(VALID_EMAIL, "WrongPassword123!");
        LoginActions.clickLoginButton();
        LoginElements.INVALID_CREDENTIALS.shouldBe(Condition.visible);

    }

    @Test(priority = 4, description = "Invalid email(format)")
    public void invalidEmailFormatTest() {
        LoginActions.enterCredentials("invalid_email", VALID_PASSWORD);
        LoginActions.clickLoginButton();
        LoginElements.INVALID_CREDENTIALS.shouldBe(Condition.visible);
    }

    @Test(priority = 5, description = "SQL Injection attempt in login")
    public void sqlInjectionTest() {
        LoginActions.enterCredentials("admin' OR '1'='1", "anything");
        LoginActions.clickLoginButton();
        LoginElements.INVALID_CREDENTIALS.shouldBe(Condition.visible);
    }

    @Test(priority = 6, description = "XSS attack attempt in email field")
    public void xssAttackTest() {
        LoginActions.enterCredentials("<script>alert('XSS')</script>", "anyPassword123");
        LoginActions.clickLoginButton();
        LoginElements.INVALID_CREDENTIALS.shouldBe(Condition.visible);
    }

    @Test(priority = 7, description = "Login with correct credentials")
    public void positiveLoginTest() {
        LoginActions.enterCredentials(VALID_EMAIL, VALID_PASSWORD);
        LoginActions.clickLoginButton();
        LoginElements.HOME_PAGE_USER_MENU.shouldBe(Condition.visible);
    }

}
