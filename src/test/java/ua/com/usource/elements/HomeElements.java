package ua.com.usource.elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import lombok.Getter;

@Getter
public class HomeElements extends BaseElements {

    private final SelenideElement introMessage = $x("//div[./b[text()='Usource'] and contains(text(), 'the source of your knowledge!')]");
    private final SelenideElement userMenu = $x("//button[@id='userMenu']");
}
