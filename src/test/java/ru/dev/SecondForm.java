package ru.dev;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


class SecondForm {


    @BeforeEach
    void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.clickViaJs = true;
        open("/text-box");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


    @Test
    void fillForm() {
        $("#userName").setValue("Lana");
        $("#submit").click();

        $("#output").shouldHave(text("Lana"));
    }

    @Test
    void successfulFillOnlyMandatoryFieldsTest() {
        $("#userName").setValue("Lana");
        $("#userEmail").setValue("Lana@.ru");
        $("#submit").click();

        $("#userEmail").shouldHave(cssClass("field-error"));
        $("#output").shouldNotBe(visible);

    }

}