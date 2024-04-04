import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FillFormTestWithPageOdject extends TestBase {

    File fileToUpload = new File("src/test/java/Resourses/1653613466_10-funart-pro-p-krisa-za-kompom-krasivo-foto-10.jpg");

    String firstName = "Egor";
    String lastName = "Melnichyk";
    String email = "egor.mel8@gmail.com";
    String gender = "Male";
    String number = "9998887766";
    String yearOfBirth = "2002";
    String monthOfBirth = "September";
    String dayOfBirth = "10";
    String subject = "Math";
    String hobbie = "Music";
    String address = "Гравство Капибариуса";
    String state = "Haryana";
    String city = "Karnal";

    @Test
    void successRegistrationTest() {

        registrationPage.openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNamber(number)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbies(hobbie)
                .uploadPicture(fileToUpload)
                .setAdress(address)
                .setState(state)
                .setCity(city)
                .clickSabmitButton();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Egor Melnichyk"),
                text("egor.mel8@gmail.com"),
                text("Male"),
                text("9998887766"),
                text("10 September,2002"),
                text("Math"),
                text("Music"),
                text("1653613466_10-funart-pro-p-krisa-za-kompom-krasivo-foto-10.jpg"),
                text("Гравство Капибариуса"),
                text("Haryana Karnal")
        );
    }
}
