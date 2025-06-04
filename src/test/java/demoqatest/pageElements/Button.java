package demoqatest.pageElements;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Button {

    public Button(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    String name;
    SelenideElement selector;

    @Step("Нажимаем кнопку")
    public void click() {
        $(selector)
                .shouldBe(visible, Duration.ofSeconds(30))
                .click();
    }

    @Step("Получение CSS-значения элемента'Кнопки'")
    public String getCssValue(String Css) {
        var color = selector.getCssValue(Css);
        return color;
    }
}