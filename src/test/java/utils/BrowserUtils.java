package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BrowserUtils {
    private BrowserUtils() {}

    public static void removeBanner() {
        executeJavaScript("""
            document.getElementById('fixedban')?.remove();
            document.querySelector('footer')?.remove();
        """);
    }
}
