package ru.dev;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;


class SecondForm {


    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillForm() {
        open("/text-box");
        $("#userName").setValue(firstName);
        $("#submit").click();

        $("#output").shouldHave(text(firstName));
    }

    @Test
    void successfulFillOnlyMandatoryFieldsTest() {
        open("/text-box");
        $("#userName").setValue(firstName);
        $("#userEmail").setValue(wrongEmail);
        $("#submit").click();

        $("#userEmail").shouldHave(cssClass("field-error"));
        $("#output").shouldNotBe(visible);

    }

}