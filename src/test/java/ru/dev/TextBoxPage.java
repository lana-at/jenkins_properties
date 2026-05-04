package ru.dev;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static ru.dev.TestBase.textBoxPage;
import static testdata.TestData.*;


class TextBoxPage {


    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }


    @Test
    void fillForm() {
        textBoxPage.openPage()
                .userName(firstName)
                .submitForm()
                .outputResult()
                .checkResult(firstName);

    }

    @Test
    void successfulFillOnlyMandatoryFieldsTest() {
        textBoxPage.openPage()
                .userName(firstName)
                .userEmail(wrongEmail)
                .submitForm()
                .error();

    }

}