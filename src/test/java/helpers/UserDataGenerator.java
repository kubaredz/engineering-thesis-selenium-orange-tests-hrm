package helpers;

import com.github.javafaker.Faker;

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
}
