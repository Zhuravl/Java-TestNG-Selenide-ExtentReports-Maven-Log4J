package ua.com.usource.actions;

import ua.com.usource.elements.LoginElements;


public class LoginActions {

    public static void enterCredentials(String email, String password) {
        LoginElements.EMAIL_FIELD.setValue(email);
        LoginElements.PASSWORD_FIELD.setValue(password);
    }

    public static void clickLoginButton() {
        LoginElements.LOGIN_BUTTON.click();
    }

}
