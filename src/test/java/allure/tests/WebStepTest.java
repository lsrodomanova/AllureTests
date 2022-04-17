package allure.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String TITLE = "С Новым Годом";

    @DisplayName("Проверка issue на github")
    @Test


        @Step("Открыть главную страницу")
            public void openMainPage() {
        open("https://github.com/");
    }

        @Step("Найти репозиторий")
                public void searchRepository() {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").pressEnter();
        }

        @Step("Открыть репозиторий")
                public void openRepository() {
            $(linkText(REPOSITORY)).click();
        }

        @Step("Кликнуть на таб Issue")
                public void clickOnTab() {
            $(partialLinkText("Issue")).click();
        }

        @Step("Найти Issue по названию")
                public void searchByTitle() {
            $(partialLinkText("С Новым Годом")).click();
        }

        @Step("Сравнить результат")
                public void resultTest() {
        $(".markdown-title").shouldHave(text(TITLE));
    }
}
