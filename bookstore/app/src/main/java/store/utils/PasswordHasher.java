
package store.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        String newHash = hashPassword(password);
        return newHash.equals(hashedPassword);
    }
}

    // public static void main(String[] args) {
    // String password = "mypassword";
    // String hashedPassword = hashPassword(password);
    // System.out.println("Hashed Password: " + hashedPassword);

    // boolean verified = verifyPassword("mypassword", hashedPassword);
    // System.out.println("Password verified: " + verified);

    // verified = verifyPassword("wrongpassword", hashedPassword);
    // System.out.println("Password verified: " + verified);
    // }