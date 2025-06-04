package demoqatest.pageObjects;

import com.codeborne.selenide.Condition;
import demoqatest.pageElements.Button;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModalWindow {
    private final static String TITLE_TEXT = "Thanks for submitting the form";
    private final Button closeButton = new Button("Close", $("#closeLargeModal"));

    @Step("Проверяем видимость модального окна")
    public ResultModalWindow checkVisible() {
        $("#example-modal-sizes-title-lg").shouldBe(Condition.visible)
                .shouldHave(text(TITLE_TEXT));
        return this;
    }

    @Step("Проверяем результаты в модальном окне")
    public ResultModalWindow checkResult(String label, String expectedValue) {
        $(".table-responsive table").$(byText(label))
                .parent()
                .shouldHave(text(expectedValue));
        return this;

    }

    @Step("Закрываем модальное окно")
    public ResultModalWindow closeButton() {
        closeButton.click();
        return this;
    }
}
