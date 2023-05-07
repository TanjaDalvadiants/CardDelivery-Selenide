
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;



public class CardDeliverySelenideTest {

    @Test
    void shouldTestGoodPath(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";


        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Казань");
        //$("[data-test-id='date'] input").setValue("22.06.2023");
        $("[data-test-id='name'] input").setValue("Иванов-Петров Иван");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $("[data-test-id='notification']").should(appear, Duration.ofSeconds(15));
    }
    @Test
    void shouldTestIfCityEmpty(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";


        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue(" ");
        //$("[data-test-id='date'] input").setValue("22.06.2023");
        $("[data-test-id='name'] input").setValue("Иванов-Петров Иван");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $x("//span[@data-test-id='city']//span[@class='input__sub'][contains(text(), 'Поле обязательно для заполнения')]").should(appear);

    }
    @Test
    void shouldTestIfCityNotInList(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";


        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Саров");
        //$("[data-test-id='date'] input").setValue("22.06.2023");
        $("[data-test-id='name'] input").setValue("Иванов-Петров Иван");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $x("//span[@data-test-id='city']//span[@class='input__sub'][contains(text(), 'Доставка в выбранный город недоступна')]").should(appear);

    }
    @Test
    void shouldTestIfNameIsEmpty(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";


        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Казань");
        //$("[data-test-id='date'] input").setValue("22.06.2023");
        $("[data-test-id='name'] input").setValue("");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $x("//span[@data-test-id='name']//span[@class='input__sub'][contains(text(), 'Поле обязательно для заполнения')]").should(appear);

    }
    @Test
    void shouldTestIfLatinName(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";


        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Казань");
        //$("[data-test-id='date'] input").setValue("22.06.2023");
        $("[data-test-id='name'] input").setValue("Margo");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $x("//span[@data-test-id='name']//span[@class='input__sub'][contains(text(), 'Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.')]").should(appear);

    }
    @Test
    void shouldTestIfNameWithSymbol(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";


        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Казань");
        //$("[data-test-id='date'] input").setValue("22.06.2023");
        $("[data-test-id='name'] input").setValue("Марго123");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $x("//span[@data-test-id='name']//span[@class='input__sub'][contains(text(), 'Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.')]").should(appear);

    }
    @Test
    void shouldTestIfShortPhone(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";


        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Казань");
        //$("[data-test-id='date'] input").setValue("22.06.2023");
        $("[data-test-id='name'] input").setValue("Марго");
        $("[data-test-id='phone'] input").setValue("+799");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $x("//span[@data-test-id='phone']//span[@class='input__sub'][contains(text(), 'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.')]").should(appear);

    }
    @Test
    void shouldTestIfLongPhone(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";


        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Казань");
        //$("[data-test-id='date'] input").setValue("22.06.2023");
        $("[data-test-id='name'] input").setValue("Марго");
        $("[data-test-id='phone'] input").setValue("+79989797979897");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $x("//span[@data-test-id='phone']//span[@class='input__sub'][contains(text(), 'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.')]").should(appear);

    }
    @Test
    void shouldTestIfPhoneWithoutPlus(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";


        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Казань");
        //$("[data-test-id='date'] input").setValue("22.06.2023");
        $("[data-test-id='name'] input").setValue("Марго");
        $("[data-test-id='phone'] input").setValue("7999876543");
        $("[data-test-id='agreement']").click();
        $(".button__text").click();
        $x("//span[@data-test-id='phone']//span[@class='input__sub'][contains(text(), 'Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.')]").should(appear);

    }
    @Test
    void shouldTestIfAgreementNotCheck(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "200x900";


        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Казань");
        //$("[data-test-id='date'] input").setValue("22.06.2023");
        $("[data-test-id='name'] input").setValue("Марго");
        $("[data-test-id='phone'] input").setValue("+70987654321");
        //$("[data-test-id='agreement']").click();
        $(".button__text").click();
        $x("//label[@data-test-id='agreement'][contains(@class, 'input_invalid')]").shouldHave(visible);

    }


}
