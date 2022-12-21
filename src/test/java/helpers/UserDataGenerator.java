package helpers;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.atomic.AtomicLong;

public class UserDataGenerator {

    public static String generateFirstName() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        return firstName;
    }

    public static String generateMiddleName() {
        Faker faker = new Faker();
        String middleName = faker.name().name();
        return middleName;
    }

    public static String generateLastName() {
        Faker faker = new Faker();
        String lastName = faker.name().lastName();
        return lastName;
    }

    public static String generateUsername() {
        Faker faker = new Faker();
        String username = faker.superhero().prefix() + faker.name().firstName() + faker.address().buildingNumber();
        return username;
    }

    public static String generateEmailAddress() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generatePhoneNumber() {
        return String.format("(%03d) %03d-%04d",
                (int) Math.floor(999 * Math.random()),
                (int) Math.floor(999 * Math.random()),
                (int) Math.floor(9999 * Math.random()));
    }

    public static String generateId() {
        String shortId = RandomStringUtils.randomNumeric(8);
        return shortId;
    }

    public static String generateDriversLicenseNumber(){
        String drivingString = RandomStringUtils.randomNumeric(3);
        String drivingNumber = RandomStringUtils.randomAlphabetic(8);

        return drivingString + drivingNumber;
    }
}
