package ua.com.usource.actions;

import ua.com.usource.elements.SignInElements;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

public class SignInActions {

    private final SignInElements signInElements = new SignInElements();

    public SignInActions enterCredentials(String email, String password) {
        signInElements.getEmailField().shouldBe(visible).sendKeys(email);
        signInElements.getPasswordField().shouldBe(visible).sendKeys(password);
        return this;
    }

    public SignInActions clickOnLogInButton() {
        signInElements.getLogInButton().shouldBe(clickable).click();
        return this;
    }

    public SignInActions verifyErrorMessageText(String errorMessage) {
        signInElements.getErrorMessageCredentials()
                .shouldBe(visible)
                .shouldBe(exactOwnText(errorMessage));
        return this;
    }

    public SignInActions verifyRequiredFieldsErrorMessages() {
        signInElements.getErrorMessageRequiredFields()
                .shouldHave(size(2))
                .forEach(el -> el.shouldHave(exactOwnText("This field is required!")));
        return this;
    }
}
