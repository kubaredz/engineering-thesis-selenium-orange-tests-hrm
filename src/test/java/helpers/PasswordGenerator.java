package helpers;

import java.util.Random;

public class PasswordGenerator {
    public static String generatePassword() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(15);
        for (int i = 0; i < 15; i++)
            stringBuilder.append(chars.charAt(random.nextInt(chars.length())));
        return stringBuilder.toString();
    }
}
