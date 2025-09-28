package ua.com.usource.actions;

import com.codeborne.selenide.SelenideElement;
import ua.com.usource.common.enums.UserData;
import ua.com.usource.elements.LoginElements;

import java.util.Map;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;


public class LoginActions extends BaseActions {

    private final LoginElements loginElements = new LoginElements();

    /**
     * Check that all form elements are displayed
     */
    public LoginActions checkFormVisible() {
        loginElements.emailField.shouldBe();
        loginElements.passwordField.shouldBe(visible);
        loginElements.loginButton.shouldBe(visible);
        return this;
    }

    public void clickLoginButton(){
        loginElements.loginButton.click();
    }

    /**
     * Enter login data according to chosen scenarios
     */
    public void loginAs(UserData userData) {
        loginElements.emailField.setValue(userData.getEmail());
        loginElements.passwordField.setValue(userData.getPassword());
        clickLoginButton();

        waitForPageLoadComplete();
    }

    /**
     * Verify user email on profile button
     */
    public Boolean verifyUserProfile(UserData userData){
        return loginElements.userProfileButton.getText().trim().equals(userData.getEmail().trim());
    }

    /**
     * Check user logout
     */
    public void logout() {
        loginElements.userProfileButton.click();
        loginElements.logoutButton.shouldBe(visible).click();

        waitForPageLoadComplete();
    }

    /**
     * Clear Email and Password fields
     */
    public void clearEmailAndPassword() {
        clearField(loginElements.emailField);
        clearField(loginElements.passwordField);
    }

    /**
     * Check Email field value
     */
    public String checkEmailFieldValue() {
        String result = "";
        result = Objects.requireNonNull(loginElements.emailField.getValue()).trim();
        return result;
    }

    /**
     * Check Password field value
     */
    public String checkPasswordFieldValue() {
        String result = "";
        result = Objects.requireNonNull(loginElements.passwordField.getValue()).trim();
        return result;
    }

    /**
     * Check that alerts are displayed on the login form
     */
    public LoginActions checkEmailAlertDisplayed() {
        loginElements.emailAlert.shouldBe(visible).shouldHave(text("This field is required!"));
        return this;
    }

    public LoginActions checkPasswordAlertDisplayed() {
        loginElements.passwordAlert.shouldBe(visible).shouldHave(text("This field is required!"));
        return this;
    }

     /**
     * Check that alerts are absent on the login form
     */
    public LoginActions checkEmailAlertAbsent() {
        loginElements.emailAlert.shouldNot(exist);
        return this;
    }

    public LoginActions checkPasswordAlertAbsent() {
        loginElements.passwordAlert.shouldNot(exist);
        return this;
    }

    public LoginActions checkCredentialsAlertDisplayed() {
        loginElements.credentialsAlert.shouldBe(visible).shouldHave(text("Invalid credentials!"));
        return this;
    }



}
