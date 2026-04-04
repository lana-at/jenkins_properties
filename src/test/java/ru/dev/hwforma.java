package ru.dev;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


class PracticeForm {


    @BeforeEach
        // ← сначала метод настройки
    void setUp() {
        Configuration.clickViaJs = true;
        open("https://demoqa.com/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


    @Test
    void successfulLoginTest() {
        $("[id=firstName]").setValue("Lana");
        $("[id=lastName]").setValue("Neobutova");
        $("[id=userEmail]").setValue("lanampr1986@gmail.com");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("9127788492");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]").selectOption("1986");
        $("[class=react-datepicker__month-select]").selectOption(5);
        $("[class*=react-datepicker__day--020]").click();
        $("[id=hobbies-checkbox-1]").click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/1.jpg"));
        $("[id=currentAddress]").setValue("wwwLeningrad");
        $("[id=state]").click();
        $("[id=react-select-3-input]").setValue("NCR");
        $("[id=react-select-3-input]").pressEnter();
        $("[id=city]").click();
        $("[id=react-select-4-input]").setValue("Delhi");
        $("[id=react-select-4-input]").pressEnter();
        $("[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldBe(visible);
        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $$("tr").findBy(text("Student Name")).shouldHave(text("Lana Neobutova"));
        $$("tr").findBy(text("Student Email")).shouldHave(text("lanampr1986@gmail.com"));
        $$("tr").findBy(text("Gender")).shouldHave(text("Female"));
        $$("tr").findBy(text("Mobile")).shouldHave(text("9127788492"));
        $$("tr").findBy(text("Date of Birth")).shouldHave(text("20 June,1986"));
        $$("tr").findBy(text("Hobbies")).shouldHave(text("Sports"));
        $$("tr").findBy(text("Picture")).shouldHave(text("1.jpg")); // имя файла
        $$("tr").findBy(text("Address")).shouldHave(text("wwwLeningrad"));
        $$("tr").findBy(text("State and City")).shouldHave(text("NCR Delhi"));
    }

    @Test
    void successfulFillOnlyMandatoryFieldsTest() {
        $("[id=firstName]").setValue("Lana");
        $("[id=lastName]").setValue("Neobutova");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("9127788492");
        $("[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldBe(visible);
        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $$("tr").findBy(text("Student Name")).shouldHave(text("Lana Neobutova"));
        $$("tr").findBy(text("Gender")).shouldHave(text("Female"));
        $$("tr").findBy(text("Mobile")).shouldHave(text("9127788492"));

    }

    @Test
    void negativeEmptyFirstNameTest() {
        $("[id=lastName]").setValue("Neobutova");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("9127788492");
        $("[id=submit]").click();

        $("[id=userForm]").shouldHave(cssClass("was-validated"));
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);
    }
    @Test
    void negativeInvalideEmail() {
        $("[id=firstName]").setValue("Lana");
        $("[id=lastName]").setValue("Neobutova");
        $("[id=userEmail]").setValue("lanampr1986gmail.com");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("9127788492");
        $("[id=submit]").click();

        $("[id=userForm]").shouldHave(cssClass("was-validated"));
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);
    }

    @Test
    void negativeInvalidePhone() {
        $("[id=firstName]").setValue("Lana");
        $("[id=lastName]").setValue("Neobutova");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("91277884");
        $("[id=submit]").click();

        $("[id=userForm]").shouldHave(cssClass("was-validated"));
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);
    }

    @Test
    void negativeEmptyGender() {
        $("[id=lastName]").setValue("Neobutova");
        $("[id=userNumber]").setValue("9127788492");
        $("[id=submit]").click();

        $("[id=userForm]").shouldHave(cssClass("was-validated"));
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);
    }

    @Test
    void negativeEmptyForm() {
        $("[id=submit]").click();

        $("[id=userForm]").shouldHave(cssClass("was-validated"));
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);

    }




}