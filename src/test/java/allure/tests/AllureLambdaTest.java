package allure.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AllureLambdaTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String TITLE = "С Новым Годом";

    @DisplayName("Проверка issue на github")
    @Test

    public void searchIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com/");
        });

        step("Найти репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").pressEnter();
        });

        step("Открыть репозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Кликнуть на таб Issue", () -> {
            $(partialLinkText("Issue")).click();
        });

        step("Найти Issue по названию" + TITLE, () -> {
            $(partialLinkText("С Новым Годом")).click();
        });

        step("Сравнить результат", () -> {
            $(".markdown-title").shouldHave(text(TITLE));
        });
    }
}

