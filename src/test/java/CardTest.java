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
       $("[data-test-id=name] input").setValue("Смирнова Екатерина");
        $("[data-test-id=phone] input").setValue("+79758868855");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual =  $("[data-test-id=order-success]").getText();
    }
}
