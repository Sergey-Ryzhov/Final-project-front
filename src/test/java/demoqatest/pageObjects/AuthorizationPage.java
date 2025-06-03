package demoqatest.pageObjects;


import demoqatest.data.ValidData;
import demoqatest.pageElements.Button;
import demoqatest.pageElements.DropDownMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import demoqatest.pageElements.Input;
import demoqatest.pageElements.Calendar;
import demoqatest.pageElements.UpLoadFile;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.Selenide.$;


public class AuthorizationPage {
    ValidData validData = new ValidData();
    private final Calendar calendar = new Calendar();

    private final String TITLE_TEXT = "Practice Form";

    private final String URL = "https://demoqa.com/automation-practice-form";
    private final Input firstName = new Input("Имя", $("#firstName"));
    private final Input lastName = new Input("Фамилия", $("#lastName"));
    private final Input email = new Input("Почта", $("#userEmail"));
    private final Button genderButton = new Button("Выбор пола", $(".custom-control-label"));
    private final Input telephoneNumber = new Input("Телефон", $("#userNumber"));

    private final Input subjects = new Input("Предметы", $("#subjectsInput"));
    private final Button hobbies = new Button("Хобби", $("#hobbiesWrapper"));
    private final UpLoadFile file = new UpLoadFile("Изображение", $("#uploadPicture"));
    private final Input currentAddress = new Input("Адрес", $("#currentAddress"));
    private final DropDownMenu state = new DropDownMenu("Штат", $("#state"));
    private final DropDownMenu city = new DropDownMenu("Город", $("#city"));
    private final Button submit = new Button("Submit", $("#submit"));


    @Step("Открываем страницу DemoQA")
    public AuthorizationPage go() {
        open(URL);
        return this;
    }

    @Step("Проверяем название страницы")
    public AuthorizationPage textCheck() {
        assertEquals(TITLE_TEXT, "Practice Form", "Не та страница");
        return this;
    }

    @Step("Вводим Имя")
    public AuthorizationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    @Step("Вводим Фамилию")
    public AuthorizationPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    @Step("Вводим Почту")
    public AuthorizationPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    @Step("Выбираем Гендер")
    public AuthorizationPage setGender() {
        genderButton.click();
        return this;
    }

    @Step("Вводим Телефон")
    public AuthorizationPage setTelephoneNumber(String value) {
        telephoneNumber.setValue(value);
        return this;
    }

    @Step("Выбираем Дату рождения")
    public AuthorizationPage setCalendar(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    @Step("Выбираем Субъект")
    public AuthorizationPage setSubjects(String value) {
        subjects.setSubjects(value);
        return this;
    }

    @Step("Выбираем Хобби")
    public AuthorizationPage setHobbies() {
        $(byText(validData.getHobbies())).click();
        return this;
    }

    @Step("Добавляем файл")
    public AuthorizationPage setFile(String value) {
        file.upLoadFile(value);
        return this;
    }

    @Step("Выбираем Адрес")
    public AuthorizationPage setCurrentAddress(String value) {
        $("#currentAddress").scrollTo();
        currentAddress.setValue(value);
        return this;
    }

    @Step("Выбираем Штат")
    public AuthorizationPage setState(String value) {
        state.dropDownMenuOpen(value);
        return this;
    }

    @Step("Выбираем Город")
    public AuthorizationPage setCity(String value) {
        city.dropDownMenuOpen(value);
        return this;
    }

    @Step("Нажимаем кнопку Submit")
    public AuthorizationPage submit() {
        $("#submit").scrollTo();
        submit.click();
        return this;
    }

    @Step("Получаем цвет поля 'Имя'")
    public String getInputCssValueFirstName() {
        String color = firstName.getCssValue("border-color");
        return color;
    }

    @Step("Получаем цвет поля 'Фамилия'")
    public String getInputCssValueLastName() {
        String color = lastName.getCssValue("border-color");
        return color;
    }

    @Step("Получаем цвет кнопки 'Гендер'")
    public String getButtonCssValueGender() {
        String color = genderButton.getCssValue("color");
        return color;
    }

    @Step("Получаем цвет кнопки 'Телефон'")
    public String getInputCssValueTelephone() {
        String color = telephoneNumber.getCssValue("border-color");
        return color;
    }

    @Step("Получаем цвет кнопки 'Почта'")
    public String getInputCssValueEmail() {
        String color = email.getCssValue("border-color");
        return color;
    }
}
