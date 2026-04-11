package ru.dev;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;


class PracticeForm {


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
    void successfulLoginTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").find(byText(genderWrapper)).click();
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
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(genderWrapper));
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
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").find(byText(genderWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().shouldBe(visible);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(genderWrapper));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));

    }

    @Test
    void negativeEmptyFirstNameTest() {
        open("/automation-practice-form");
        $("#lastName").setValue(lastName);
        $("#genterWrapper").find(byText(genderWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().shouldBe(visible);
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
    @Test
    void negativeInvalidEmail() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(wrongEmail);
        $("#genterWrapper").find(byText(genderWrapper)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().shouldBe(visible);
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }

    @Test
    void negativeInvalidPhone() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").find(byText(genderWrapper)).click();
        $("#userNumber").setValue(wrongNumber);
        $("#submit").scrollTo().shouldBe(visible);
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }

    @Test
    void negativeEmptyGender() {
        open("/automation-practice-form");
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().shouldBe(visible);
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }

    @Test
    void negativeEmptyForm() {
        open("/automation-practice-form");
        $("#submit").scrollTo().shouldBe(visible);
        $("#submit").click();

        $("#userForm").shouldHave(cssClass("was-validated"));
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);

    }




}