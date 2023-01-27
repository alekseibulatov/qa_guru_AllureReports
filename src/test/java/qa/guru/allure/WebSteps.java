package qa.guru.allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Кликаем на главной странице в  поле поиска")
    public void clickToFieldOnMainPage() {
        $("input[type=text]").click();
    }

    @Step("Вводим в поле поиска имя репозитория {value}  и нажимаем Enter")
    public void searchRepository(String value) {
        $("input[type=text]").setValue(value).submit();
    }

    @Step("Проверяем, что страница с результатами поиска открылась")
    public void checkedOpenPage(String value) {
        $(".codesearch-results").shouldHave(text(value));
    }

    @Step("Кликаем на репозиторий с именем {value}")
    public void clickToRepository(String value) {
        $(".repo-list-item").$(byText(value)).click();
    }

    @Step("Проверяем название кнопки {value}  в репозитории ")
    public void checkedNameButton(String value) {
        $("#issues-tab").shouldHave(text(value));
    }
}
