package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WebStepTest {

    private static final String REPOSITORY = "alekseibulatov/qa_guru_AllureReports";
    private static final String USER = "alekseibulatov";
    private static final String NAME_BUTTON = "Issues";
    private static final String RESULT_CHECK = "result";

    @Test
    @Feature(" Issues в репозитории")
    @Story("Создание  кнопки Issues")
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com/alekseibulatov/qa_guru_AllureReports")
    @DisplayName("Проверка названия Issues кнопки  в репозитории")
    void selenideWithWebStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();

        webSteps.openMainPage();
        webSteps.clickToFieldOnMainPage();
        webSteps.searchRepository(REPOSITORY);
        webSteps.checkedOpenPage(RESULT_CHECK);
        webSteps.clickToRepository(USER);
        webSteps.checkedNameButton(NAME_BUTTON);
    }
}
