package ua.com.usource.actions;

import ua.com.usource.elements.HomeElements;

import static com.codeborne.selenide.Condition.*;

public class HomePageActions {

    private final HomeElements homeElementsElements = new HomeElements();

    public HomePageActions verifyIntroMessage() {
        homeElementsElements.getIntroMessage().shouldBe(visible);
        return this;
    }

    public HomePageActions verifyUserMenuEmail(String expectedEmail) {
        homeElementsElements.getUserMenu()
                .shouldBe(visible)
                .shouldBe(exactText(expectedEmail));
        return this;
    }
}
