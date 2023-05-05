import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliverySelenideTest {
    @Test
    void shouldTest(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";

        
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Казань");
//        $("[data-test-id='date'] input").setValue("12.05.2023");
        $("[data-test-id='name'] input").setValue("Иванов-Петров Иван");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $("[data-test-id='notification']").should(appear, Duration.ofSeconds(15));
    }

}
