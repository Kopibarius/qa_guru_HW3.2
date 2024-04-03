import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTestWithPageOdject extends TestBase {

    String firstName = "Egor";

    @Test
    void successRegistrationTest() {

        registrationPage.openRegistrationPage()
                .setFirstName(firstName);


        $("#lastName").setValue("Melnichyk");
        $("#userEmail").setValue("egor.mel8@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9998887766");
        $("#dateOfBirthInput").click();
        $x("//select[@class='react-datepicker__month-select']").selectOptionByValue("8");
        $x("//select[@class='react-datepicker__year-select']").selectOptionByValue("2002");
        $(".react-datepicker__day--008:not(.react-datepicker__day--outside-month)").click();
        //$x("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        File fileToUpload = new File("src/test/java/Resourses/1653613466_10-funart-pro-p-krisa-za-kompom-krasivo-foto-10.jpg");
        $("#uploadPicture").uploadFile(fileToUpload);
        $("#currentAddress").setValue("Гравство Капибариуса");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Egor Melnichyk"),
                text("egor.mel8@gmail.com"),
                text("Male"),
                text("9998887766"),
                text("08 September,2002"),
                text("Math"),
                text("Music"),
                text("1653613466_10-funart-pro-p-krisa-za-kompom-krasivo-foto-10.jpg"),
                text("Гравство Капибариуса"),
                text("Haryana Karnal")
        );
    }
}
