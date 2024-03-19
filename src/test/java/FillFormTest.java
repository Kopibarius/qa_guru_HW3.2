import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTest {
    @Test
    void successfulSearchTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 1200000;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Melnichyk");
        $("#userEmail").setValue("egor.mel8@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9998887766");
        $("#dateOfBirthInput").click();
        //$x("//select[@class='react-datepicker__month-select']").click();
        $x("//select[@class='react-datepicker__month-select']").selectOptionByValue("8");
        $x("//select[@class='react-datepicker__year-select']").selectOptionByValue("2002");
        $x("//div[@class='react-datepicker__day react-datepicker__day--008 react-datepicker__day--weekend']").click();
        //$x("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        //$x("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']").selectOptionContainingText("Math");
        $(byText("Music")).click();
        File fileToUpload = new File("src/test/java/Resourses/1653613466_10-funart-pro-p-krisa-za-kompom-krasivo-foto-10.jpg");
        $("#uploadPicture").uploadFile(fileToUpload);
            $("#currentAddress").setValue("Гравство Капибариуса");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();
        //$(".css-tlfecz-indicatorContainer").click();
        //$(byText("Haryana")).click();
        //$(".css-19bqh2r").$(byText("Karnal")).click();
        $x("//table/tbody/tr[1]/td[2]").shouldHave(text("Egor Melnichyk"));
        $x("//table/tbody/tr[2]/td[2]").shouldHave(text("egor.mel8@gmail.com"));
        $x("//table/tbody/tr[3]/td[2]").shouldHave(text("Male"));
        $x("//table/tbody/tr[4]/td[2]").shouldHave(text("9998887766"));
        $x("//table/tbody/tr[5]/td[2]").shouldHave(text("08 September,2002"));
        $x("//table/tbody/tr[6]/td[2]").shouldHave(text("Math"));
        $x("//table/tbody/tr[7]/td[2]").shouldHave(text("Music"));
        $x("//table/tbody/tr[8]/td[2]").shouldHave(text("1653613466_10-funart-pro-p-krisa-za-kompom-krasivo-foto-10.jpg"));
        $x("//table/tbody/tr[9]/td[2]").shouldHave(text("Гравство Капибариуса"));
        $x("//table/tbody/tr[10]/td[2]").shouldHave(text("Haryana Karnal"));

    }
}
