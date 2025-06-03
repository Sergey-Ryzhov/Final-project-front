package demoqatest.pageElements;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

public class UpLoadFile {


    public UpLoadFile(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    String name;
    SelenideElement selector;

    public void upLoadFile(String file) {
        selector.uploadFile(new File("src/test/resources/images.jpg"));
    }
}
