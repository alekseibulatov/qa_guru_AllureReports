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
import static io.qameta.allure.Allure.step;


public class StepTest {
    private static final String REPOSITORY = "alekseibulatov/qa_guru_AllureReports";
    private static final String NAME_BUTTON = "Issues";

    @Test
    @Feature(" Issues в репозитории")
    @Story("Создание  кнопки Issues")
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/alekseibulatov/qa_guru_AllureReports")
    @DisplayName("Проверка названия Issues кнопки  в репозитории")
    void selenideWithStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Кликаем на главной странице в  поле поиска", () -> {
            $("input[type=text]").click();
        });
        step("Вводим в поле поиска имя репозитория " + REPOSITORY + "  и нажимаем Enter", () -> {
            $("input[type=text]").setValue(REPOSITORY).submit();
        });
        step("Проверяем, что страница с результатами поиска открылась", () -> {
            $(".codesearch-results").shouldHave(text("result"));
        });
        step("Кликаем на репозиторий с именем " + REPOSITORY, () -> {
            $(".repo-list-item").$(byText("alekseibulatov")).click();
        });
        step("Проверяем название кнопки " + NAME_BUTTON + " в репозитории " + REPOSITORY, () -> {
            $("#issues-tab").shouldHave(text(NAME_BUTTON));
        });
    }
}
