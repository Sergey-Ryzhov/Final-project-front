package demoqatest.pageElements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DropDownMenu {

    String name;

    public DropDownMenu(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    SelenideElement selector;

    @Step("Открываем выпадающее меню и выбираем значение")
    public void dropDownMenuOpen(String value) {
        selector.click();
        $(byText(value)).click();
    }
}