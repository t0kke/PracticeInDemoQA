import config.BaseTest;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.exactTexts;

public class StudentRegistrationFormTest extends BaseTest {
    @Test
    void checkingTheFormFilling () {
        String  firstName = "German",
                lastName = "Kataev",
                email = "test@test.tt",
                phoneNumber = "9998887766",
                gender  = "Male",
                day = "16",
                mounth = "July",
                year = "1993",
                subjects = "Arts",
                hobbies = "Reading",
                picName = "pug.jpeg",
                currentAddress = "Prostokvashino",
                state = "NCR",
                city = "Noida";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $x("//label[text()='" + gender + "']").click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $x("//option[contains(text(),'" + year + "')]").click();
        $(".react-datepicker__month-select").click();
        $x("//option[contains(text(),'" + mounth + "')]").click();
        $$(".react-datepicker__day").find(exactText("16")).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $x("//label[text()='" + hobbies + "']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/files/pug.jpeg"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $$x("//tbody//td[2]").shouldHave(exactTexts(firstName + " " + lastName, email, gender, phoneNumber,
                day + " " + mounth + "," + year , subjects, hobbies, picName, currentAddress, state + " " + city));
    }
}
