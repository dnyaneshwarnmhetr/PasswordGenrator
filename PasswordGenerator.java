import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_-+=<>?/{}[]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int passwordLength = scanner.nextInt();
        scanner.nextLine();
    

        System.out.print("You Password Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("You Password Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("You Password Include digits? (yes/no): ");
        boolean includeDigits = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("You Password Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.nextLine().equalsIgnoreCase("yes");

        String password = generatePassword(passwordLength, includeLowercase, includeUppercase, includeDigits, includeSpecialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase,
                                          boolean includeDigits, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        String charSet = "";

        if (includeLowercase) {
            charSet += LOWERCASE_CHARS;
        }
        if (includeUppercase) {
            charSet += UPPERCASE_CHARS;
        }
        if (includeDigits) {
            charSet += DIGITS;
        }
        if (includeSpecialChars) {
            charSet += SPECIAL_CHARS;
        }

        if (charSet.isEmpty()) {
            throw new IllegalArgumentException("At least one character set must be selected.");
        }

        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charSet.length());
            char randomChar = charSet.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
