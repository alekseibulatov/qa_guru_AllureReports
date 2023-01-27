package qa.guru.allure;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideTest {

    @Test
    @Feature(" Issues в репозитории")
    @Story("Создание  кнопки Issues")
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/alekseibulatov/qa_guru_AllureReports")
    @DisplayName("Проверка названия Issues кнопки  в репозитории")
    void selenideWithListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $("input[type=text]").click();
        $("input[type=text]").setValue("alekseibulatov/qa_guru_AllureReports").submit();
        $(".codesearch-results").shouldHave(text("result"));
        $(".repo-list-item").$(byText("alekseibulatov")).click();
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
