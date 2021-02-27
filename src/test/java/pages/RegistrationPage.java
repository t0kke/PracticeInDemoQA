package pages;

import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    @Step("Открываем страницу регистрации {url}")
    public static RegistrationPage openPage(String url) {
        open(url);
        return page(RegistrationPage.class);
    }

    @Step("Заполняем поле с именем {namePlaceholder}")
    public RegistrationPage setValueInFieldWithPlaceholder(String value, String namePlaceholder) {
        $("[placeholder='" + namePlaceholder + "']").setValue(value);
        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage clickByRadiobuttonWithName(String genderName) {
        $(byText(genderName)).click();
        return this;
    }

    @Step("Выбираем дату рождения")
    public RegistrationPage setDataByCalendar(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $$(".react-datepicker__day").find(exactText(day)).click();
        return this;
    }

    @Step("Выбираем предметы {subject}")
    public RegistrationPage setSubjectWithName(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбираем хобби {nameHobby}")
    public RegistrationPage choiceOfHobbyWithName(String nameHobby) {
        $(byText(nameHobby)).click();
        return this;
    }

    @Step("Загружаем фото")
    public RegistrationPage uploadPicture(String filename) {
        $("#uploadPicture").uploadFile(new File(filename));
        return this;
    }

    @Step("Заполняем адрес")
    public RegistrationPage enterAddressinField(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage choiceFromDropdownListWithName(String headingDropdownList, String itemName) {
        $(byText(headingDropdownList)).scrollTo().click();
        $(byText(itemName)).click();
        return this;
    }

    @Step("Отправляем форму регистрации")
    public RegistrationPage clickBySubmitButton() {
        $("#submit").click();
        return this;
    }

    @Step("Проверяем введенные данные с отправленными в форме подтверждения")
    public RegistrationPage checkRegistrationData(String firstName, String lastName, String email, String gender, String phoneNumber,
                                                  String day, String month, String year, String subject, String hobbie,
                                                  String picName, String currentAddress, String state, String city) {
        $$x("//tbody//td[2]").shouldHave(exactTexts(firstName + " " + lastName, email, gender, phoneNumber,
                day + " " + month + "," + year, subject, hobbie, picName, currentAddress, state + " " + city));
        return this;
    }

    @Step("Проверяем индикацию незаполненных полей")
    public RegistrationPage checkBorderField() {
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 19)"));
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
}
