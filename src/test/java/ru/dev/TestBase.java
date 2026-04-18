package ru.dev;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.SecondPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    protected static TextBoxPage textBoxPage = new TextBoxPage();
    protected static SecondPage secondPage = new SecondPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "normal"; // Ждать полной загрузки
        Configuration.browserPosition = "0x0";
    }

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }
}
