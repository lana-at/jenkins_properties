package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.BrowserUtils.removeBanner;


public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();
    ResultComponent result = new ResultComponent();
    //Elements
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement subjectsContainer = $("#subjectsInput");
    private final SelenideElement hobbiesConteiner = $("#hobbiesWrapper");
    private final SelenideElement pictureInput = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement userForm =  $("#userForm");
    private final SelenideElement modalTitle = $("#example-modal-sizes-title-lg");



    //Actions

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        removeBanner();

        return this;
    }

    public PracticeFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage typeNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeSubjects(String value) {
        subjectsContainer.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbiesConteiner.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage typePicture(String fileName) {
        pictureInput.uploadFromClasspath(fileName);

        return this;
    }

    public PracticeFormPage typeAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);


        return this;
    }

    public PracticeFormPage setState(String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }


    public PracticeFormPage setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }


    public ResultComponent submitForm() {
        submitButton.scrollTo().shouldBe(visible).click();
        return result;
    }

    public PracticeFormPage submitFormErrors() {
        submitButton.scrollTo().shouldBe(visible).click();
        return this;
    }
    public PracticeFormPage validationErrors() {
        userForm.shouldHave(cssClass("was-validated"));
        return this;
    }

    public void modalNotShown() {
        modalTitle.shouldNotBe(visible);
    }

}


