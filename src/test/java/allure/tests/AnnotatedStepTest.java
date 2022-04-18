package allure.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String TITLE = "С Новым Годом";

    @Test
    @DisplayName("Проверка Issue на GitHub")

    public void tetGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.clickOnTab();
        steps.searchByTitle(TITLE);
        steps.resultTest(TITLE);
    }



}
