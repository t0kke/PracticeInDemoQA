package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static pages.RegistrationPage.openUrl;

public class RegistrationNewUserTest extends BaseTest {
    Faker faker = new Faker(new Locale("ru-RU"));
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress("test"),
            phone = faker.phoneNumber().subscriberNumber(10),
            fullAddress = faker.address().fullAddress();


    @Test
    @DisplayName("Регистрация нового пользователя")
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
                .checkRegistrationData(firstName, lastName, email, "Male",
                        phone, "16", "July", "1993", "Arts", "Reading",
                        "pug.jpeg", fullAddress, "NCR", "Noida");
    }

    @Test
    @Tag("negative")
    @DisplayName("Нажимаем кнопку отправки без заполнения данных")
    void clickSubmitWithoutFillingInFields() {
        openUrl("https://demoqa.com/automation-practice-form")
                .clickBySubmitButton()
                .checkRegistrationData(firstName, lastName, email, "Male",
                        phone, "16", "July", "1993", "Arts", "Reading",
                        "pug.jpeg", fullAddress, "NCR", "Noida");
    }
}

