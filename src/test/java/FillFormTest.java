import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillFormTest {
    @Test
    void successfulSearchTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 1200000;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Melnichyk");
        $("#userEmail").setValue("egor.mel8@gmail.com");
    }
}
