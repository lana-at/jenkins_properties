package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SecondPage {


    private final SelenideElement nameInput = $("#userName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement result = $("#output");


    public SecondPage openPage() {
        open("/text-box");

        return this;
    }


    public SecondPage userName (String value) {
        nameInput.setValue(value);
        return this;
    }

    public SecondPage userEmail (String value) {
        emailInput.setValue(value);
        return this;
    }

    public SecondPage submitForm() {
        submitButton.scrollTo().shouldBe(visible).click();
        return this;
    }

    public SecondPage outputResult() {
        result.shouldBe(visible);
        return this;
    }

    public SecondPage checkResult(String value) {
        result.shouldHave(text(value));
        return this;
    }

    public SecondPage error () {
        emailInput.shouldHave(cssClass("field-error"));
        result.shouldNotBe(visible);
        return this;
    }

}
