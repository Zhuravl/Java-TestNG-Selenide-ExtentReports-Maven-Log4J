package ua.com.usource.common.core.helpers;

import java.security.SecureRandom;

public class GenerateCredentialsHelper {
    private final static SecureRandom random = new SecureRandom();

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!#$&'()*,-./:;<>?@[]^_{|}~\\\"";
    private static final String ALL_CHARACTERS = UPPER_CASE + LOWER_CASE + DIGITS + SPECIAL_CHARACTERS;

    public static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(randomIndex));
        }

        return password.toString();
    }

    public static String generateRandomEmail(int length) {
        StringBuilder email = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            email.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));
        }
        email.append('@');

        for (int i = 0; i < length; i++) {
            email.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));
        }
        email.append(".ua");

        return email.toString();
    }
}