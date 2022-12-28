package helpers;

import java.util.concurrent.ThreadLocalRandom;

public class PasswordGenerator {

    public static String generate(int length) {
        String smallAlphabet = "qrstuvwxyz";
        String upperAlphabet = "ABCDEFGHIJ";
        String numeric = "012345";
        String chars = "!@#%^&!@#$%^&!";
        String password = smallAlphabet + upperAlphabet + chars + numeric + chars;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(password.charAt(ThreadLocalRandom.current().nextInt(password.length())));
        }
        return stringBuilder.toString();
    }
}