package allure.tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {


        @Step("Открыть главную страницу")
            public void openMainPage() {
        open("https://github.com/");
    };

        @Step("Найти репозиторий {repo}")
                public void searchRepository(String repo) {
            $(".header-search-input").click();
            $(".header-search-input").setValue(repo);
            $(".header-search-input").pressEnter();
        };

        @Step("Открыть репозиторий {repo}")
                public void openRepository(String repo) {
            $(linkText(repo)).click();
        };

        @Step("Кликнуть на таб Issue")
                public void clickOnTab() {
            $(partialLinkText("Issue")).click();
        };

        @Step("Найти Issue по названию {title}")
                public void searchByTitle(String title) {
            $(partialLinkText(title)).click();
        };

        @Step("Сравнить результат {title}")
                public void resultTest(String title) {
        $(".markdown-title").shouldHave(text(title));
    }
}
