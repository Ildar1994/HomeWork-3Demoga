import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormaTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void registrationTest() {
        open("/automation-practice-form");

        //заполняем фио и почту
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov@mail.ru");

        //выбор пола
        $("#genterWrapper").$(byText("Other")).click(); //лучший локатор
        // $("#gender-radio-1").parent().click();   //хороший локатор
        //$("label[for=gender-radio-1]").click();  //хороший локатор

        // номер телефона
        $("#userNumber").setValue("8917222331");

        //дата рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--022").click();

        //выбираем предмет
        $("#subjectsInput").setValue("Arts").pressEnter();

       //выбираем хобби
        $("#hobbiesWrapper").$(byText("Reading")).click();


        //загружаем файл
        $("#uploadPicture").uploadFromClasspath("img/1111.jpg");

        //вписываем адрес
        $("#currentAddress").setValue("Пушкина дом 9");

        //выбираем страну
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        //выбираем город
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        //жмем Submit
        $("#submit").click();

        //Проверяем модалку

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan"));
        $(".table-responsive").shouldHave(text("Ivanov"));
        $(".table-responsive").shouldHave(text("Ivanov@mail.ru"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("8917222331"));
        $(".table-responsive").shouldHave(text("22 March,1990"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("Arts"));
        $(".table-responsive").shouldHave(text("1111.jpg"));
        $(".table-responsive").shouldHave(text("NCR Noida"));


    }
}

