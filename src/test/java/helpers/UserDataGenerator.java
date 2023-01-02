package helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class UserDataGenerator {
    private static final Faker faker = new Faker();

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateMiddleName() {
        return faker.name().name();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateUsername() {
        return faker.superhero().prefix() + faker.name().firstName() + faker.address().buildingNumber();
    }

    public static String generateEmailAddress() {
        return faker.internet().emailAddress();
    }

    public static String generatePhoneNumber() {
        String generatedPhoneNumber = String.format("%03d-%03d-%03d",
                (int) Math.floor(999 * Math.random()),
                (int) Math.floor(999 * Math.random()),
                (int) Math.floor(999 * Math.random()));
        return generatedPhoneNumber;
    }

    public static String generateId() {
        return RandomStringUtils.randomNumeric(8);
    }

    public static String generateDriversLicenseNumber() {
        String generatedString = RandomStringUtils.randomNumeric(3);
        String generatedNumber = RandomStringUtils.randomAlphabetic(8);
        return generatedString + generatedNumber;
    }
}