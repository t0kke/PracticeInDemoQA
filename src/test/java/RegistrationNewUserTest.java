import org.junit.jupiter.api.Test;

import static pages.RegistrationPage.openToRegistrationPage;

public class RegistrationNewUserTest  {
    @Test
    void registrationNewUser() {
        openToRegistrationPage()
                .setValueInFieldWithPlaceholder("German", "First Name")
                .setValueInFieldWithPlaceholder("Kataev", "Last Name")
                .setValueInFieldWithPlaceholder("test@test.tt", "name@example.com")
                .clickByRadiobuttonWithName("Male")
                .setValueInFieldWithPlaceholder("9998887711","Mobile Number")
                .setDataByCalendar("16", "July", "1993")
                .setSubjectWithName("Arts")
                .choiceOfHobbyWithName("Reading")
                .uploadPicture("src/test/resources/files/pug.jpeg")
                .enterAddressinField("Dovatora Ul., bld. 16, appt. 55")
                .choiceFromDropdownListWithName("Select State", "NCR")
                .choiceFromDropdownListWithName("Select City", "Noida")
                .clickBySubmitButton()
                .CheckRegistrationData("German", "Kataev", "test@test.tt", "Male",
                        "9998887711","16", "July", "1993", "Arts", "Reading",
                        "pug.jpeg","Dovatora Ul., bld. 16, appt. 55", "NCR", "Noida");
    }
}

