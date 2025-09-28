package ua.com.usource.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class LoginElements extends BaseElements {

    public final SelenideElement emailField = $x("//input[@name='username']");
    public final SelenideElement passwordField = $x("//input[@name='password']");
    public final SelenideElement loginButton = $x("//button[./span[text()='Login']]");
    public final SelenideElement userProfileButton = $x("//button[@id='userMenu'][text()]");
    public final SelenideElement logoutButton = $x("//a[text()='Logout']");
    public final SelenideElement emailAlert = $x("//input[@name='username']/following-sibling::*[@role='alert']");
    public final SelenideElement passwordAlert = $x("//input[@name='password']/following-sibling::*[@role='alert']");
    public final SelenideElement credentialsAlert = $x("//*[@class='form-group']/*[@role='alert']");


}
