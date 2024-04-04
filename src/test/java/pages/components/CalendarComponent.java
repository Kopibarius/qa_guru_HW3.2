package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDateOfBirth(String day, String month, String year) {
        $("select.react-datepicker__month-select").selectOptionContainingText(month);
        $("select.react-datepicker__year-select").selectOptionByValue(year);
        if (Integer.valueOf(day) < 10) {
            $(".react-datepicker__day--00" + day
                    + ":not(.react-datepicker__day--outside-month)").click();
        } else {
            $(".react-datepicker__day--0" + day
                    + ":not(.react-datepicker__day--outside-month)").click();
        }
    }
}
