package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    private final SelenideElement outputResults = $(".table-responsive");
    private final SelenideElement formTitle =  $("#example-modal-sizes-title-lg");

    public ResultComponent checkForm () {
        formTitle.shouldBe(visible);
        formTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }
    public ResultComponent checkResult (String key, String value) {
        outputResults.$(byText(key)).parent().shouldHave(text(value));

        return this;

    }

}
