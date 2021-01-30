import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {
    @Test
    void checkingTheFormFilling() {
        String firstName = "German";
        String lastName = "Kataev";
        String email = "test@test.tt";
        String number = "89998887766";
        String sex  = "Male";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);

        $x("//label[text()='" + sex + "']").click();
        $("#userNumber").setValue(number);



    }
}
