// src/test/java/com/petrovich/ui/base/TestBase.java
package com.petrovich.ui.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.petrovich.ui.config.TestsConfig;
import com.petrovich.ui.helpers.AttachAllure;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    // Создаем экземпляр TestsConfig
    private static TestsConfig config;

    @BeforeAll
    static void openBrowser() {
        // Инициализируем конфигурацию
        config = ConfigFactory.create(TestsConfig.class);

        // Используем config для получения baseUrl
        Configuration.baseUrl = config.baseUrl();

        // Добавляем логгер Allure
        SelenideLogger.addListener("allure", new AllureSelenide());

        // password and user for remote browser
        String user = System.getProperty("user");
        String password = System.getProperty("password");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;


        Configuration.remote = "https://" + user + ":" + password + "@" + System.getProperty("remoteBrowser", "selenoid.autotests.cloud/wd/hub");
        Configuration.remote = null;
    }

    @AfterEach
    void addAttachments() {
        AttachAllure.screenshotAs("Last screenshot");
        AttachAllure.pageSource();
        AttachAllure.browserConsoleLogs();
        AttachAllure.addVideo();
        closeWebDriver();
    }
}
