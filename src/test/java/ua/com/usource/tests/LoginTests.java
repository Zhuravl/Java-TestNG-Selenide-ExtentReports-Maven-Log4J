package ua.com.usource.tests;

import io.github.cdimascio.dotenv.Dotenv;
import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.com.usource.actions.HomePageActions;
import ua.com.usource.actions.NavigationActions;
import ua.com.usource.actions.SignInActions;
import ua.com.usource.common.enums.Pages;

import static ua.com.usource.common.core.helpers.GenerateCredentialsHelper.*;

public class LoginTests extends BaseTest{

    Dotenv dotenv = Dotenv.load();
    private final String PASSWORD = dotenv.get("user_password");
    private final String EMAIL = dotenv.get("user_email");
    private final SignInActions signInActions = new SignInActions();
    private final HomePageActions homePageActions = new HomePageActions();
    private final NavigationActions navigationActions = new NavigationActions();
    Pages signInPage = Pages.SIGN_IN;

    private String randomEmail = generateRandomEmail(15);
    private String randomPassword = generateRandomPassword(8);

    @DataProvider(name = "negativeLoginData")
    public Object[][] negativeLoginData () {
        return new Object[][] {
                {EMAIL, randomPassword, "Invalid credentials!"},
                {randomEmail, PASSWORD, "Invalid credentials!"},
                {randomEmail, randomPassword, "Invalid credentials!"}, // Credentials are valid, but user does`t exist
        };
    }

    @Test(description = "Positive: TC-001 Success login with correct credentials")
    public void successLoginTest() {
        navigation().openWebsite();
        navigation().navigateTo(signInPage);
        signInActions.enterCredentials(EMAIL, PASSWORD)
                .clickOnLogInButton();
        navigationActions.verifyUrl("https://usource.com.ua/");
        homePageActions.verifyIntroMessage();
        homePageActions.verifyUserMenuEmail(EMAIL);
    }

    @Test(dataProvider = "negativeLoginData")
    @Description("Negative: TC-002 - TC-004 Check for login restrictions to incorrect email and passwords")
    public void checkErrorMessage (String email, String password, String errorMessage) {
        navigation().openWebsite();
        navigation().navigateTo(signInPage);
        signInActions.enterCredentials(email, password)
                .clickOnLogInButton();
        navigationActions.verifyUrl("https://usource.com.ua/login");
        signInActions
                .enterCredentials(email, password)
                .clickOnLogInButton()
                .verifyErrorMessageText(errorMessage);
    }

    @Test(description = "Negative: TC-005 Check error messages for required fields")
    public void verifyRequiredFieldErrorMessagesTest() {
        navigation().openWebsite();
        navigation().navigateTo(signInPage);
        signInActions.clickOnLogInButton();
        navigationActions.verifyUrl("https://usource.com.ua/login");
        signInActions.verifyRequiredFieldsErrorMessages();
    }
}