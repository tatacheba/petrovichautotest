import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.sleep;

public class TestBase {

    @BeforeAll
    static void openBrowser() {
        Configuration.baseUrl = "https://petrovich.ru/";
        SelenideLogger.addListener("allure", new AllureSelenide());

        //password and user for remote browser
        String user = System.getProperty("user");
        String password = System.getProperty("password");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://" + user + ":" + password + "@" + System.getProperty("remoteBrowser", "selenoid.autotests.cloud/wd/hub");
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
