package demoqatest.settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {
    private static void setLocalDriver() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1524x1080";
        pageLoadTimeout = 1000000;

    }

    @BeforeEach
    void setDriver() {
        setLocalDriver();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}

