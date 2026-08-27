import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character using charAt()
    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];  // ASCII character range

        // Step 1: Count frequency of each character
        int length = 0;
        try {
            while (true) {
                char ch = text.charAt(length);
                freq[ch]++;
                length++;
            }
        } catch (Exception e) {
            // End of string
        }

        // Step 2: Find first character with frequency 1
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0';  // Null character if none found
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }
    }
}

