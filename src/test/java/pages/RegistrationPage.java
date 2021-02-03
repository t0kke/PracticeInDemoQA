package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public static RegistrationPage openUrl(String url) {
        open(url);
        return page(RegistrationPage.class);
    }

    public RegistrationPage setValueInFieldWithPlaceholder(String value, String namePlaceholder) {
        SelenideElement fieldWithPlaceholder = $x("//input[@placeholder='" + namePlaceholder + "']");

        fieldWithPlaceholder.setValue(value);
        return this;
    }

    public RegistrationPage clickByRadiobuttonWithName(String genderName){
        SelenideElement genderRadiobutton = $x("//label[text()='" + genderName + "']");

        genderRadiobutton.click();
        return this;
    }

    public RegistrationPage setDataByCalendar(String day, String month, String year){
        SelenideElement dataOfBirthInput = $("#dateOfBirthInput");
        SelenideElement yearInput = $(".react-datepicker__year-select");
        SelenideElement choiceOfYearWithList = $x("//option[contains(text(),'" + year + "')]");
        SelenideElement monthInput = $(".react-datepicker__month-select");
        SelenideElement choiceOfMonthWithList = $x("//option[contains(text(),'" + month + "')]");
        ElementsCollection dayPicker =  $$(".react-datepicker__day");

        dataOfBirthInput.click();
        yearInput.click();
        choiceOfYearWithList.click();
        monthInput.click();
        choiceOfMonthWithList.click();
        dayPicker.find(exactText(day)).click();
        return this;
    }

    public RegistrationPage setSubjectWithName(String subject){
        SelenideElement subjectInput = $("#subjectsInput");

        subjectInput.val(subject).pressEnter();
        return this;
    }

    public RegistrationPage choiceOfHobbyWithName(String nameHobby){
        SelenideElement checkboxHobby = $x("//label[text()='" + nameHobby + "']");

        checkboxHobby.click();
        return this;
    }

    public RegistrationPage uploadPicture(String filename){
        SelenideElement inputFile = $("#uploadPicture");

        inputFile.uploadFile(new File(filename));
        return this;
    }

    public RegistrationPage enterAddressinField(String address){
        SelenideElement addressField = $("#currentAddress");

        addressField.setValue(address);
        return this;
    }

    public RegistrationPage choiceFromDropdownListWithName(String HeadingDropdownList, String ItemName){
        SelenideElement dropdownInput = $x("//div[text()='" + HeadingDropdownList + "']").scrollTo();
        SelenideElement itemDropdownList = $x("//div[text()='" + ItemName + "']");
        
        dropdownInput.click();
        itemDropdownList.click();
        return this;
    }

    public RegistrationPage clickBySubmitButton(){
        SelenideElement sunmitButton = $("#submit");

        sunmitButton.click();
        return this;
    }

    public RegistrationPage CheckRegistrationData(String firstName, String lastName, String email, String gender, String phoneNumber,
                                                  String day, String month, String year, String subject, String hobbie,
                                                  String picName, String currentAddress, String state, String city){
        ElementsCollection registrationData = $$x("//tbody//td[2]");

        registrationData.shouldHave(exactTexts(firstName + " " + lastName, email, gender, phoneNumber,
                day + " " + month + "," + year , subject, hobbie, picName, currentAddress, state + " " + city));
        return this;
    }
}
