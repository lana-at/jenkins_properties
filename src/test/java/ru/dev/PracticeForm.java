package ru.dev;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;


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
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").find(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        String daySelector = String.format(".react-datepicker__day--%03d", day);
        $(daySelector).click();
        $("#subjectsInput").setValue(subjects);
        $$(".subjects-auto-complete__option").findBy(text(subjects)).click();
        $("#hobbiesWrapper").find(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(uploadfile);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#react-select-3-input").setValue(state);
        $("#react-select-3-input").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(city);
        $("#react-select-4-input").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(genterWrapper));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbies));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(uploadfile));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(state + " " + city));


    }

    @Test
    void successfulFillOnlyMandatoryFieldsTest() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").find(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(genterWrapper));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));

    }

    @Test
    void negativeEmptyFirstNameTest() {
        $("#lastName").setValue(lastName);
        $("#genterWrapper").find(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
    @Test
    void negativeInvalidEmail() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(wrongEmail);
        $("#genterWrapper").find(byText(genterWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }

    @Test
    void negativeInvalidPhone() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").find(byText(genterWrapper)).click();
        $("#userNumber").setValue(wrongNumber);
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }

    @Test
    void negativeEmptyGender() {
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);
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