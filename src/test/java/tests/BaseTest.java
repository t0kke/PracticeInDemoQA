package tests;

import com.codeborne.selenide.Configuration;
import config.EnvironmentConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.confirm;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelperToAllure.*;

public class BaseTest {
    static final EnvironmentConfig config = ConfigFactory.create(EnvironmentConfig.class, System.getProperties());
    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";

        if (config.webDriverUrl() != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = config.webDriverUrl();
        }
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (config.videoStorage()!= null)
            attachVideo();
        closeWebDriver();
    }
}
