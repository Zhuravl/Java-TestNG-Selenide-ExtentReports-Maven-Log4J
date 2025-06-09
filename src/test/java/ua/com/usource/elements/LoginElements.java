package ua.com.usource.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginElements {

    //login buttons
    public static final SelenideElement EMAIL_FIELD = $x("//div[@class='form-group']//input[@name='username']");
    public static final SelenideElement PASSWORD_FIELD = $x("//div[@class='form-group']//input[@name='password']");
    public static final SelenideElement LOGIN_BUTTON  = $x("//div[@class='form-group']/button");

    //verifying elements
    public static final SelenideElement INVALID_CREDENTIALS = $x("//div[@class='form-group']/div[@class='text-center alert alert-danger']");
    public static final SelenideElement EMAIL_REQUIRED = $x("//label[@for='username']/following-sibling::div//div[contains(@class, 'alert')]");
    public static final SelenideElement PASSWORD_REQUIRED = $x("//label[@for='password']/following-sibling::div//div[contains(@class, 'alert')]");
    public static final SelenideElement HOME_PAGE_USER_MENU = $x("//button[@id='userMenu']");

}

