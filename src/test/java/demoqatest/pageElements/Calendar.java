package demoqatest.pageElements;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public void setDate(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-dropdown-container").click();
        $(byText(year)).click();
        $(".react-datepicker__month-dropdown-container").click();
        $(byText(month)).click();
        $(".react-datepicker__day--0" + day).click();

    }
}