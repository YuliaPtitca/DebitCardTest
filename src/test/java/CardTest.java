import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.awt.SystemColor.text;

public class CardTest {
    
    @Test
    void shouldTestFullPositiveForm() {
        Selenide.open("http://localhost:9999");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        inputs.get(0).sendKeys("Смирнова Екатерина Петровна");
        inputs.get(1).sendKeys("+79758868855");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.className("paragraph_theme_alfa-on-white")).getText().trim();
        Assertions.assertEquals(expected, actual);
    }
}
