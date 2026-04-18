package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
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

    public TextBoxPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public TextBoxPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public TextBoxPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public TextBoxPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public TextBoxPage typeNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public TextBoxPage typeSubjects(String value) {
        subjectsContainer.setValue(value).pressEnter();

        return this;
    }

    public TextBoxPage setHobbies(String value) {
        hobbiesConteiner.$(byText(value)).click();

        return this;
    }

    public TextBoxPage typePicture(String fileName) {
        pictureInput.uploadFromClasspath(fileName);

        return this;
    }

    public TextBoxPage typeAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public TextBoxPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);


        return this;
    }

    public TextBoxPage setState(String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }


    public TextBoxPage setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }


    public ResultComponent submitForm() {
        submitButton.scrollTo().shouldBe(visible).click();
        return result;
    }

    public TextBoxPage submitFormErrors() {
        submitButton.scrollTo().shouldBe(visible).click();
        return this;
    }
    public TextBoxPage ValidationErrors() {
        userForm.shouldHave(cssClass("was-validated"));
        return this;
    }

    public void ModalNotShown() {
        modalTitle.shouldNotBe(visible);
    }

}


