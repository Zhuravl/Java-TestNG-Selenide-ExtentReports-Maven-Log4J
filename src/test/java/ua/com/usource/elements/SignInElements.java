package ua.com.usource.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import lombok.Getter;

@Getter
public class SignInElements extends BaseElements {

    private final SelenideElement emailField = $x("//input[@name='username']");
    private final SelenideElement passwordField = $x("//input[@name='password']");
    private final SelenideElement logInButton = $x("//button[@class='btn btn-primary btn-block']");
    private final SelenideElement errorMessageCredentials = $x("//div[@class='text-center alert alert-danger']");

    private final ElementsCollection errorMessageRequiredFields = $$x("//div[@class='alert alert-danger']");
}
