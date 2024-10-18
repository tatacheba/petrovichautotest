// src/test/java/com/petrovich/ui/tests/MainPageTests.java
package com.petrovich.ui.tests;

import com.codeborne.selenide.Condition;
import com.petrovich.ui.base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.petrovich.ui.pages.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Page title check")
    void checkTitleMainPage() {
        step("Open page 'https://petrovich.ru/'", () -> {
            mainPage.openPage();
        });
        step("Check that one of the h1 headers contains the text 'Строительный магазин Петрович'", () -> {
            $x("//h1[contains(text(),'Строительный магазин Петрович')]")
                    .should(Condition.exist); // проверяем, что хотя бы один элемент существует
        });

//    @ParameterizedTest
//    @CsvSource({"https://petrovich.ru/контакты, Контакты", "https://petrovich.ru/о-нас, О нас"})
//    @DisplayName("Page title check")
//    void checkTitleMainPage(String url, String title) {
//        step("Open page '" + url + "'", () -> {
//            open(url);
//        });
//        step("Check title page", () -> {
//            $("h1").shouldHave(text(title));
//        });
//    }
    }
}
