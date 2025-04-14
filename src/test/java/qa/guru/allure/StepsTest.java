package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

  public static final String REPOSITORY = "eroshenkoam/allure-example";
  public static final int ACTION = 280;

  @Test
  public void testLambdaSteps(){
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Открываем главную страницу", () -> {
      open("https://github.com");
    });
    step("Ищем репозиторий " + REPOSITORY, () -> {
      $(".header-search-button").click();
      $("#query-builder-test").setValue(REPOSITORY).pressEnter();
    });
    step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
      $(linkText(REPOSITORY)).click();
    });
    step("Открываем таб Actions", () -> {
      $("#actions-tab").click();
    });
    step ("Проверяем Action с номером " + ACTION, () -> {
      $(withText("#" + ACTION)).should(Condition.exist);
    });
  }

  @Test
  public void testAnnotatedStep(){
    SelenideLogger.addListener("allure", new AllureSelenide());
    WebSteps steps = new WebSteps();

    steps.openMainPage();
    steps.searchForRepository(REPOSITORY);
    steps.clickOnRepositoryLink(REPOSITORY);
    steps.openActionsTab();
    steps.shouldSeeActionWithNumber(ACTION);
  }
}
