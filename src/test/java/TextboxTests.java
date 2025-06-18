import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextboxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
      Configuration.baseUrl = "https://demoqa.com";
      Configuration.timeout = 5000;
    }
    @Test
    void forma() {
        open("/text-box");
        $("#userName").setValue("ildar");
        $("#userEmail").setValue("salavat@mail.ru");
        $("#currentAddress").setValue("Kazan");
        $("#permanentAddress").setValue("Moscow");
        $("#submit").click();



        $("#output #name").shouldHave(text("ildar"));
        $("#output #email" ).shouldHave(text("salavat@mail.ru"));
        $("#output #currentAddress" ).shouldHave(text("Kazan"));
        $("#output #permanentAddress").shouldHave(text("Moscow"));



    }
}
