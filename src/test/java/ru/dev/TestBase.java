package ru.dev;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPage;
import pages.TextBoxPage;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    protected static PracticeFormPage practiceFormPage = new PracticeFormPage();
    protected static TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "normal";
        Configuration.browserPosition = "0x0";
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }
}