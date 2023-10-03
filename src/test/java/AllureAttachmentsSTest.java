import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static io.qameta.allure.Allure.attachment;

public class AllureAttachmentsSTest {
    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final int ISSUE_NUMBER = 80;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 60000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    void testLambdaAttachments() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });
    }

    @Test
    public void testAnnotatedAttachment() {
        AllureWebSteps steps = new AllureWebSteps();

        steps.openMainPage();
        steps.takeScreenshot();
    }
}
