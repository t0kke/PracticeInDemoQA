package pages;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public static RegistrationPage openUrl(String url) {
        open(url);
        return page(RegistrationPage.class);
    }

    public RegistrationPage setValueInFieldWithPlaceholder(String value, String namePlaceholder) {
        $x("//input[@placeholder='" + namePlaceholder + "']").setValue(value);
        return this;
    }

    public RegistrationPage clickByRadiobuttonWithName(String genderName) {
        $(byText(genderName)).click();
        return this;
    }

    public RegistrationPage setDataByCalendar(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $$(".react-datepicker__day").find(exactText(day)).click();
        return this;
    }

    public RegistrationPage setSubjectWithName(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage choiceOfHobbyWithName(String nameHobby) {
        $x("//label[text()='" + nameHobby + "']").click();
        return this;
    }

    public RegistrationPage uploadPicture(String filename) {
        $("#uploadPicture").uploadFile(new File(filename));
        return this;
    }

    public RegistrationPage enterAddressinField(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationPage choiceFromDropdownListWithName(String HeadingDropdownList, String ItemName) {
        $x("//div[text()='" + HeadingDropdownList + "']").scrollTo().click();
        $x("//div[text()='" + ItemName + "']").click();
        return this;
    }

    public RegistrationPage clickBySubmitButton() {
        $("#submit").click();
        return this;
    }

    public RegistrationPage checkRegistrationData(String firstName, String lastName, String email, String gender, String phoneNumber,
                                                  String day, String month, String year, String subject, String hobbie,
                                                  String picName, String currentAddress, String state, String city) {
        $$x("//tbody//td[2]").shouldHave(exactTexts(firstName + " " + lastName, email, gender, phoneNumber,
                day + " " + month + "," + year, subject, hobbie, picName, currentAddress, state + " " + city));
        return this;
    }
}
