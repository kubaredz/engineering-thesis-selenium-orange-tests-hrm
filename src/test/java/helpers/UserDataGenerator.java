package helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class UserDataGenerator {
    private static final Faker faker = new Faker();

    public static String generateFirstName() {
        String generatedFirstName = faker.name().firstName();
        return generatedFirstName;
    }

    public static String generateMiddleName() {
        String generatedMiddleName = faker.name().name();
        return generatedMiddleName;
    }

    public static String generateLastName() {
        String generatedLastName = faker.name().lastName();
        return generatedLastName;
    }

    public static String generateUsername() {
        String generatedUsername = faker.superhero().prefix() + faker.name().firstName() + faker.address().buildingNumber();
        return generatedUsername;
    }

    public static String generateEmailAddress() {
        String generatedEmailAddress = faker.internet().emailAddress();
        return generatedEmailAddress;
    }

    public static String generatePhoneNumber() {
        String generatedPhoneNumber = String.format("%03d-%03d-%03d",
                (int) Math.floor(999 * Math.random()),
                (int) Math.floor(999 * Math.random()),
                (int) Math.floor(999 * Math.random()));
        return generatedPhoneNumber;
    }

    public static String generateId() {
        String generatedId = RandomStringUtils.randomNumeric(8);
        return generatedId;
    }

    public static String generateDriversLicenseNumber() {
        String generatedString = RandomStringUtils.randomNumeric(3);
        String generatedNumber = RandomStringUtils.randomAlphabetic(8);
        return generatedString + generatedNumber;
    }
}