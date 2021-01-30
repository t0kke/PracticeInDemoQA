import config.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest extends BaseTest {
    @Test
    void checkingTheFormFilling () {
        String firstName = "German";
        String lastName = "Kataev";
        String email = "test@test.tt";
        String phoneNumber = "89998887766";
        String gender  = "Male";
        String date = "16 Jul 1993";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $x("//label[text()='" + gender + "']").click();
        $("#userNumber").setValue(phoneNumber);
        executeJavaScript(String.format("$('[id=dateOfBirthInput]').val('%s')", date));




    }
}
