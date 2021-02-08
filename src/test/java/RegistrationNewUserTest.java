import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static pages.RegistrationPage.openUrl;

public class RegistrationNewUserTest {
    Faker faker = new Faker(new Locale("ru-RU"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress("test"),
            phone = faker.phoneNumber().subscriberNumber(10),
            fullAddress = faker.address().fullAddress();

    @Test
    void registrationNewUser() {
        openUrl("https://demoqa.com/automation-practice-form")
                .setValueInFieldWithPlaceholder(firstName, "First Name")
                .setValueInFieldWithPlaceholder(lastName, "Last Name")
                .setValueInFieldWithPlaceholder(email, "name@example.com")
                .clickByRadiobuttonWithName("Male")
                .setValueInFieldWithPlaceholder(phone, "Mobile Number")
                .setDataByCalendar("16", "July", "1993")
                .setSubjectWithName("Arts")
                .choiceOfHobbyWithName("Reading")
                .uploadPicture("src/test/resources/files/pug.jpeg")
                .enterAddressinField(fullAddress)
                .choiceFromDropdownListWithName("Select State", "NCR")
                .choiceFromDropdownListWithName("Select City", "Noida")
                .clickBySubmitButton()
                .CheckRegistrationData(firstName, lastName, email, "Male",
                        phone, "16", "July", "1993", "Arts", "Reading",
                        "pug.jpeg", fullAddress, "NCR", "Noida");
    }
}

