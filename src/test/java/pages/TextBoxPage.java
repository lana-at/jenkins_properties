package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.BrowserUtils.removeBanner;


public class TextBoxPage {


    private final SelenideElement nameInput = $("#userName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement result = $("#output");


    public TextBoxPage openPage() {
        open("/text-box");
        removeBanner();

        return this;
    }


    public TextBoxPage userName (String value) {
        nameInput.setValue(value);
        return this;
    }

    public TextBoxPage userEmail (String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.scrollTo().shouldBe(visible).click();
        return this;
    }

    public TextBoxPage outputResult() {
        result.shouldBe(visible);
        return this;
    }

    public TextBoxPage checkResult(String value) {
        result.shouldHave(text(value));
        return this;
    }

    public TextBoxPage error () {
        emailInput.shouldHave(cssClass("field-error"));
        result.shouldNotBe(visible);
        return this;
    }

}
