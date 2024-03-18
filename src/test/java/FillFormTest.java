import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTest {
    @Test
    void successfulSearchTest() {
        Configuration.holdBrowserOpen = true;
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
        //$x("//div[@class='react-datepicker__day react-datepicker__day--008 react-datepicker__day--weekend']").click();
        $x("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        //$x("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']").selectOptionContainingText("Math");
    }
}
