package ru.dev;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


class PracticeForm {


    @BeforeEach
        // ← сначала метод настройки
    void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.clickViaJs = true;
        open("/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


    @Test
    void successfulLoginTest() {
        $("#firstName").setValue("Lana");
        $("#lastName").setValue("Neobutova");
        $("#userEmail").setValue("lanampr1986@gmail.com");
        $("#genterWrapper").find(byText("Female")).click();
        $("#userNumber").setValue("9127788492");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__month-select").selectOption(5);
        $(".react-datepicker__day--020").click();
        $("#subjectsInput").setValue("Arts");
        $$(".subjects-auto-complete__option").findBy(text("Arts")).click();
        $("#hobbiesWrapper").find(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue("wwwLeningrad");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR");
        $("#react-select-3-input").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi");
        $("#react-select-4-input").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Lana Neobutova"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("lanampr1986@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9127788492"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("20 June,1986"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("1.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("wwwLeningrad"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));


    }

    @Test
    void successfulFillOnlyMandatoryFieldsTest() {
        $("#firstName").setValue("Lana");
        $("#lastName").setValue("Neobutova");
        $("#genterWrapper").find(byText("Female")).click();
        $("#userNumber").setValue("9127788492");
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Lana Neobutova"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9127788492"));

    }

    @Test
    void negativeEmptyFirstNameTest() {
        $("#lastName").setValue("Neobutova");
        $("#genterWrapper").find(byText("Female")).click();
        $("#userNumber").setValue("9127788492");
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
    @Test
    void negativeInvalidEmail() {
        $("#firstName").setValue("Lana");
        $("#lastName").setValue("Neobutova");
        $("#userEmail").setValue("lanampr1986gmail.com");
        $("#genterWrapper").find(byText("Female")).click();
        $("#userNumber").setValue("9127788492");
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }

    @Test
    void negativeInvalidPhone() {
        $("#firstName").setValue("Lana");
        $("#lastName").setValue("Neobutova");
        $("#genterWrapper").find(byText("Female")).click();
        $("#userNumber").setValue("91277884");
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }

    @Test
    void negativeEmptyGender() {
        $("#lastName").setValue("Neobutova");
        $("#userNumber").setValue("9127788492");
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }

    @Test
    void negativeEmptyForm() {
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);

    }




}