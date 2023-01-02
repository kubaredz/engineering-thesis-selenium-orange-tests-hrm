package helpers;

import java.util.concurrent.ThreadLocalRandom;

public class PasswordGenerator {
    private static final StringBuffer stringBuffer = new StringBuffer();

    public static String generatePassword(int passwordLength) {
        String smallLetter = "abcdefghij";
        String upperLetter = "ABCDEFGHIJ";
        String digit = "0123456789";
        String chars = "!@#%^&!@#$";
        String password = smallLetter + upperLetter + digit + chars;

        for (int i = 0; i < passwordLength; i++) {
            stringBuffer.append(password.charAt(ThreadLocalRandom.current().nextInt(password.length())));
        }
        return stringBuffer.toString();
    }
}