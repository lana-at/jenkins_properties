package ru.dev;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


class SecondForm {


    @BeforeEach
    void setUp() {
        Configuration.clickViaJs = true;
        open("https://demoqa.com/text-box");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


    @Test
    void fillForm() {
        $("[id=userName]").setValue("Lana");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("Lana"));
    }

    @Test
    void successfulFillOnlyMandatoryFieldsTest() {
        $("[id=userName]").setValue("Lana");
        $("[id=userEmail]").setValue("Lana@.ru");
        $("[id=submit]").click();

        $("[id=userEmail]").shouldHave(cssClass("field-error"));
        $("[id=output]").shouldNotBe(visible);

    }

}