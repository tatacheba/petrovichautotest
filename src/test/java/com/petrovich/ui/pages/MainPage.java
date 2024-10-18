// src/test/java/com/petrovich/ui/pages/MainPage.java
package com.petrovich.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    // Элементы на странице
    private SelenideElement headerTop = $x("//*[@id='header-top']").shouldBe(Condition.visible); // header-top
    private SelenideElement searchInput = $x("//*[@class='search-input']"); // Поле поиска
    private SelenideElement searchButton = $x("//button[@type='submit' and text()='Найти']").shouldBe(Condition.visible); // Кнопка поиска
    private SelenideElement logo = $x("//*[@data-test='logo']").shouldBe(Condition.visible); // Логотип
    private SelenideElement catalogButton = $x("//*[@data-test='catalog-button']").shouldBe(Condition.visible); // Кнопка каталога
    private SelenideElement suggestModal = $x("//*[@class='suggest-modal']"); // suggest-modal
    private SelenideElement headerNavigation = $x("//nav[@class='navigation']").shouldBe(Condition.visible); // headerNavigation
    private SelenideElement sectionsMenuPopup = $x("//*[@class='sections-menu-popup']"); // sections-menu-popup

    // Метод для открытия главной страницы
    @Step("Open main page.")
    public void openPage() {
        open("/"); // Открываем главную страницу
    }

    // Метод для проверки видимости header-top
    public boolean isHeaderTopVisible() {
        return headerTop.isDisplayed(); // Проверка видимости header-top
    }

    // Метод для выполнения поиска
    @Step("Search for '{query}'")
    public void searchFor(String query) {
        searchInput.setValue(query); // Ввод запроса
        searchButton.click(); // Клик по кнопке поиска
    }

    // Метод для проверки наличия логотипа
    public boolean isLogoVisible() {
        return logo.isDisplayed(); // Проверка видимости логотипа
    }

    public boolean isSuggestModalVisible() {
        return suggestModal.isDisplayed(); // Проверка видимости suggest-modal
    }

    public boolean isHeaderNavigationVisible() {
        return headerNavigation.isDisplayed(); // Проверка видимости headerNavigation
    }

    // Метод для проверки наличия каталога
    public boolean isCatalogButtonVisible() {
        return catalogButton.isDisplayed(); // Проверка видимости кнопки каталога
    }

    // Метод для проверки наличия sections-menu-popup
    public boolean isSectionsMenuPopupVisible() {
        return sectionsMenuPopup.isDisplayed(); // Проверка видимости sections-menu-popup
    }
}
