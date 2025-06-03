package demoqatest.test;

import com.codeborne.selenide.Selenide;
import demoqatest.data.InvalidData;
import demoqatest.data.ValidData;
import demoqatest.pageObjects.AuthorizationPage;
import demoqatest.pageObjects.ResultModalWindow;
import demoqatest.settings.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DemoQaTest extends BaseTest {
    AuthorizationPage authorizationData = new AuthorizationPage();
    ValidData validData = new ValidData();
    InvalidData invalidData = new InvalidData();
    ResultModalWindow resultModalWindow = new ResultModalWindow();

    @Test
    @DisplayName("Проверка открытия DemoQA и вызов модального окна с валидными данными")
    void checkDemoQaModalWindowValid() {
        authorizationData.go()
                .textCheck()
                .setFirstName(validData.getFirstName())
                .setLastName(validData.getLastName())
                .setEmail(validData.getEmail())
                .setGender()
                .setTelephoneNumber(validData.getTelephoneNumber())
                .setCalendar(validData.getDay(), validData.getMonth(), validData.getYear())
                .setSubjects(validData.getSubjects())
                .setHobbies()
                .setFile(validData.getFile())
                .setCurrentAddress(validData.getCurrentAddress())
                .setState(validData.getState())
                .setCity(validData.getCity())
                .submit();

        resultModalWindow.checkVisible()
                .checkResult("Student Name", validData.getFirstName() + " " + validData.getLastName())
                .checkResult("Student Email", validData.getEmail())
                .checkResult("Gender", validData.getGender())
                .checkResult("Mobile", validData.getTelephoneNumber())
                .checkResult("Date of Birth", validData.getDay() + " " + validData.getMonth() + ","
                        + validData.getYear())
                .checkResult("Subjects", validData.getSubjects())
                .checkResult("Hobbies", validData.getHobbies())
                .checkResult("Picture", validData.getFile())
                .checkResult("Address", validData.getCurrentAddress())
                .checkResult("State and City", validData.getState() + " " + validData.getCity())
                .closeButton();

    }

    @Test
    @DisplayName("Проверка валидации полей (Почта)")
    void InputEmailNegativeData() {
        authorizationData.go()
                .setEmail(invalidData.getEmail())
                .submit();
        Selenide.sleep(500);
        Assertions.assertEquals(
                invalidData.getInputRedColor(),
                authorizationData.getInputCssValueEmail(),
                "Неверный цвет поля Email");
    }


    @Test
    @DisplayName("Проверка валидации полей (Телефон)")
    void InputTelephoneNegativeData() {
        authorizationData.go()
                .setTelephoneNumber(invalidData.getTelephoneNumber())
                .submit();
        Selenide.sleep(500);
        Assertions.assertEquals(
                invalidData.getInputRedColor(),
                authorizationData.getInputCssValueTelephone(),
                "Неверный цвет поля Mobile");
    }

    @Test
    @DisplayName("Проверка валидации полей (Все поля пустые)")
    void areAllFieldsEmpty() {
        authorizationData.go()
                .submit();
        Selenide.sleep(500);
        Assertions.assertEquals(
                invalidData.getInputRedColor(),
                authorizationData.getInputCssValueFirstName(),
                "Неверный цвет поля Name");
        Assertions.assertEquals(
                invalidData.getInputRedColor(),
                authorizationData.getInputCssValueLastName(),
                "Неверный цвет поля Last Name");
        Assertions.assertEquals(
                invalidData.getButtonRedColor(),
                authorizationData.getButtonCssValueGender(),
                "Неверный цвет кнопки Gender");
        Assertions.assertEquals(
                invalidData.getInputRedColor(),
                authorizationData.getInputCssValueTelephone(),
                "Неверный цвет поля Mobile");
    }
}
