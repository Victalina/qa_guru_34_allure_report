package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LabelsTest {

  @Test
  @Feature("Issue в репозитории")
  @Story("c")
  @Owner("eroshenkoam")
  @Severity(SeverityLevel.BLOCKER)
  @Link(value = "Testing", url = "http://testing.github.com")
  @DisplayName("Создание Issue для авторизованного пользователя")
  public void testStaticLabels(){


  }

  @Test
  public void testDynamicLabels(){
    Allure.getLifecycle().updateTestCase(t -> t.setName("Создание Issue для авторизованного пользователя"));
    Allure.feature(("Issue в репозитории"));
    Allure.story("Issue в репозитории");
    Allure.label("owner", "eroshenkoam");
    Allure.label("severity", SeverityLevel.CRITICAL.value());
    Allure.link("Testing", "http://testing.github.com");

  }
}
