package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GenerationFakeData {
    public static String email() {
        return faker().internet().emailAddress("test");
    }

    public static String lastName() {
        return faker().name().lastName();
    }

    public static String firstName() {
        return faker().name().firstName();
    }

    public static String phone() {
        return faker().phoneNumber().subscriberNumber(10);
    }

    public static String fullAddress() {
        return faker().address().streetAddress();
    }

    public static Faker faker() {
        return new Faker(new Locale("ru-RU"));
    }
}
