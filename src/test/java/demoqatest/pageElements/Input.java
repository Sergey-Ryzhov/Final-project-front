package demoqatest.pageElements;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class Input {
    private SelenideElement selector;
    private String name;

    public Input(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    @Step("Вводим данные в поле ввода")
    public void setValue(String value) {
        selector.click();
        $(selector).shouldBe(visible, Duration.ofSeconds(30));
        selector.sendKeys(value);
    }

    @Step("Вводим данные в поле ввода и нажимаем Enter")
    public void setSubjects(String value) {
        selector.setValue(value);
        selector.pressEnter();

    }

    @Step("Получение CSS-значения элемента'Поля ввода'")
    public String getCssValue(String Css) {
        var color = selector.getCssValue(Css);
        return color;
    }
}

