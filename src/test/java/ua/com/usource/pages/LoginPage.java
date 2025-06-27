package ua.com.usource.pages;

import com.codeborne.selenide.SelenideElement;
import ua.com.usource.elements.BaseElements;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BaseElements {

    private final SelenideElement emailInput = $("[name='username']");
    private final SelenideElement passwordInput = $("[name='password']");
    private final SelenideElement submitButton = $("button.btn.btn-primary");
    private final SelenideElement errorMessage = $(".alert.alert-danger");
    private final SelenideElement dashboardTitle = $("div").shouldHave(text("Usource"));

    public LoginPage enterEmail(String email) {
        logger.info("Enter email: " + email);
        emailInput.clear();
        emailInput.setValue(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        logger.info("Enter password");
        passwordInput.clear();
        passwordInput.setValue(password);
        return this;
    }

    public LoginPage submit() {
        logger.info("Click on the 'Login' button");
        submitButton.click();
        return this;
    }

    public void loginAs(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        submit();
    }

    public boolean isLoginErrorVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    public boolean isOnDashboardPage() {
        return dashboardTitle.shouldBe(visible).text().contains("Usource");
    }
}