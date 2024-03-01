package utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {

    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String candidatePassword, String hashedPassword) {
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }

    public static void main(String[] args) {
        String plainTextPassword = "password123";

        // Hash mật khẩu
        String hashedPassword = hashPassword(plainTextPassword);
        System.out.println("Hashed Password: " + hashedPassword);

        // Kiểm tra mật khẩu
        boolean passwordMatch = checkPassword("password123", hashedPassword);
        System.out.println("Password Match: " + passwordMatch);
    }
}
